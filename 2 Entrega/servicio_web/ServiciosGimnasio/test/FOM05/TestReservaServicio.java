/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FOM05;

import Dominio.Horario_Clase;
import Dominio.Sql;
import Servicios.FOM05_Reserva;
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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Elberg
 */
public class TestReservaServicio {
    Sql _conn = new Sql();
    ResultSet _rs;
    Gson _gson = new Gson();
    FOM05_Reserva _M05R;
    Horario_Clase _hc;
    ArrayList<Horario_Clase> _arrayHc;
    String prueba;
    
    @Before
    public void setup()
    {
        _gson = new Gson();
        _M05R = new FOM05_Reserva();
        _arrayHc = new ArrayList<Horario_Clase>();
        String queryAddPerson = "INSERT INTO USUARIO ( usu_id, usu_cedula, usu_nombre,usu_apellido, usu_sexo, usu_fecha_nac,usu_telefono, usu_estatura,usu_foto,usu_correo ) VALUES (9999, 123321,'WEB', 'SERVICES', 'M', '12-12-93','67382',13,null,'elberg@gmail.com');";
        String insertIns ="INSERT INTO INSTRUCTOR(INS_ID,INS_NOMBRE,INS_APELLIDO,INS_FECHA_NAC,INS_SEXO,INS_CORREO,INS_FOTO) VALUES(9999,'Pedro','Alvares','13-12-94','M','fitpedro@gmail.com',null);";
        String insertCl="INSERT INTO CLASE(CLA_ID,CLA_NOMBRE,CLA_DESCRIPCION) VALUES (9999,'Yoga','yoga master class');";
        String insertHc="INSERT INTO HORARIO_CLASE(HC_ID,HC_FECHA,HC_DIA,HC_CAPACIDAD,HC_HORA_INICIO,HC_HORA_FIN,HC_STATUS,HC_DURACION,FK_USUARIO,FK_INSTRUCTOR,FK_CLASE) VALUES (9999,'12-11-17','LUNES',20,'12:00:00','14:00:00','A',null,9999,9999,9999 );";
     
        try 
         {
            _rs = _conn.sql ( queryAddPerson );
            Sql conn = new Sql();
            _rs = conn.sql ( insertIns );
            Sql conne = new Sql();
            _rs = conne.sql ( insertCl );
            Sql connex = new Sql();
            _rs = connex.sql ( insertHc );
          
            
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
        String deleteCla="delete from clase where cla_id=9999";
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
            
        }
         catch (NullPointerException e) 
        {
            e.printStackTrace();
        }
        catch (Exception e){}
    }
   
    @Test
    public void insertaReservaTest(){
         try {
             String response = _M05R.insertarReserva(9999, 9999);
             assertNotNull( response );
         } catch (SQLException ex) {
             Logger.getLogger(TestReservaServicio.class.getName()).log(Level.SEVERE, null, ex);
         }
          
    }
    
    @Test
    public void eliminarReservaTest() throws SQLException{
        String response = _M05R.eliminarReserva(9999, 9999);
        assertNotNull (response);
        
            }
    @Ignore
    @Test
    public void testConsultaReserva()   
    {
     String consultaReserva ="SELECT HC_ID, CLA_NOMBRE, INS_NOMBRE, HC_FECHA, HC_DIA FROM HORARIO_CLASE, INSTRUCTOR, CLASE, USUARIO WHERE USU_ID =9999 AND USU_ID = FK_USUARIO AND CLA_ID=FK_CLASE AND FK_INSTRUCTOR = INS_ID";
     String respuesta;
           try {
               Sql connexion = new Sql();
              _rs = connexion.sql ( consultaReserva );
               respuesta = _M05R.consultaReserva(9999);
                 _arrayHc = _gson.fromJson( respuesta, new TypeToken<List<Horario_Clase>>(){}.getType());
                assertEquals( "Yoga", _arrayHc.get(0).getNombreclase());
                
                           
           } catch (SQLException ex) {
               Logger.getLogger(TestReservaServicio.class.getName()).log(Level.SEVERE, null, ex);
           }
                  } 
    }
    
