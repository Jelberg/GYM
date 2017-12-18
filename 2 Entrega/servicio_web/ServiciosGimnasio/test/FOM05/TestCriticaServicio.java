/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FOM05;

import Dominio.Critica;
import Dominio.Sql;
import Servicios.FOM05_Critica;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Elberg
 */
public class TestCriticaServicio {
    
       Sql _conn = new Sql();
    ResultSet _rs;
    Gson _gson = new Gson();
    FOM05_Critica _M05Crit;
    Critica _critica;
    ArrayList<Critica> _criticas;
    
    @Before
    public void setup()
    {
        _gson = new Gson();
        _M05Crit = new FOM05_Critica();
        _criticas = new ArrayList<Critica>();
        String queryAddPerson = "INSERT INTO USUARIO ( usu_id, usu_cedula, usu_nombre,usu_apellido, usu_sexo, usu_fecha_nac,usu_telefono, usu_estatura,usu_foto,usu_correo ) VALUES (9999, 123321,'WEB', 'SERVICES', 'M', '12-12-93','67382',13,null,'elberg@gmail.com' )";
        String insertIns ="INSERT INTO INSTRUCTOR(INS_ID,INS_NOMBRE,INS_APELLIDO,INS_FECHA_NAC,INS_SEXO,INS_CORREO,INS_FOTO) VALUES(9999,'Pedro','Alvares','13-12-94','M','fitpedro@gmail.com',null);";
        String insertCl="INSERT INTO CLASE(CLA_ID,CLA_NOMBRE,CLA_DESCRIPCION) VALUES (9999,'Yoga','yoga master class') ;";
        String insertHc="INSERT INTO HORARIO_CLASE(HC_ID,HC_FECHA,HC_DIA\n" +
",HC_CAPACIDAD,HC_HORA_INICIO,HC_HORA_FIN,HC_STATUS\n" +
",HC_DURACION,FK_USUARIO,FK_INSTRUCTOR,FK_CLASE) VALUES (9999,'12-11-17','LUNES',20,'12:00:00','14:00:00','A',null,9999,\n" +
"9999,\n" +
"9999 );";
       String insertCritica ="INSERT INTO CRITICA(CRI_ID,CRI_FECHA,CRI_COMENTARIO,CRI_VALORACION,fk_hc_id)VALUES(9999,'12-12-12','ESTO ES UNA CRITICA',5,9999";
    
        try 
         {
            _rs = _conn.sql ( queryAddPerson );
            Sql conn = new Sql();
            _rs = conn.sql ( insertIns );
            Sql conne = new Sql();
            _rs = conne.sql ( insertCl );
            Sql connex = new Sql();
            _rs = connex.sql ( insertHc );
            Sql c = new Sql();
               _rs = c.sql ( insertCritica );
            
        }
         catch (NullPointerException e) 
        {
            e.printStackTrace();
        }
        catch (Exception e){}
    }
    
    @After
    public void teardown()
    {
        String deleteHC =" delete from horario_clase where hc_id=9999";
        String deleteUsu="delete from usuario where usu_id=9999";
        String deleteIns="delete from instructor where ins_id=9999";
        String deleteCla=" delete from clase where cla_id=9999";
        String deleteCri ="delete from critica where cri_id=8888";
         try 
         {
            Sql c = new Sql();
            _rs = c.sql ( deleteHC );
            Sql conn = new Sql();
            _rs = conn.sql (  deleteUsu );
            Sql conne = new Sql();
            _rs = conne.sql ( deleteIns );
            Sql connex = new Sql();
            _rs = connex.sql ( deleteCla );
            Sql conex = new Sql();
               _rs = conex.sql ( deleteCri);
        }
         catch (NullPointerException e) 
        {
            e.printStackTrace();
        }
        catch (Exception e){}
    }
    
    @Ignore
    @Test
    public void testConsultarClasesSinCritica()   
    {
     String insertCritica ="INSERT INTO CRITICA(CRI_ID,CRI_FECHA,CRI_COMENTARIO,CRI_VALORACION,fk_hc_id)VALUES(8888,'12-12-12','ESTO ES UNA CRITICA',5,9999";
     String delete ="delete from critica where cri_id=8888";
     String respuesta;
           try {
               Sql connexion = new Sql();
              _rs = connexion.sql ( insertCritica );
               respuesta = _M05Crit.consultarCritica(8888);
               _criticas = _gson.fromJson( respuesta, new TypeToken<List<Critica>>(){}.getType());
                assertEquals( "ESTO ES UNA CRITICA", _criticas.get(0).getComentario() );
                
               //Limpia la bd 
                Sql c = new Sql();
               _rs = c.sql ( delete );
               
           } catch (SQLException ex) {
               Logger.getLogger(TestCriticaServicio.class.getName()).log(Level.SEVERE, null, ex);
           }
        
    }
    
   
    @Test
    public void testInsertarCritica()
    {
        String response;
           try {
               response = _M05Crit.insertarCritica(1,1, "comentario", 1);
                 assertNotNull( response );
           } catch (SQLException ex) {
               Logger.getLogger(TestCriticaServicio.class.getName()).log(Level.SEVERE, null, ex);
           }
   
    }
    
 
    @Test
    public void testEliminarCritica()
    {
        String response;
         try {
               response = _M05Crit.eliminarCritica(9999);
                 assertNotNull( response );
           } catch (SQLException ex) {
               Logger.getLogger(TestCriticaServicio.class.getName()).log(Level.SEVERE, null, ex);
           }
        
    }

    
}
