/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FOM05;

import Dominio.Sql;
import Servicios.FOM05_Critica;
import com.google.common.base.Predicate;
import static com.google.common.base.Predicates.equalTo;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Elberg
 */
public class FOM05_ServicioCriticaTest {
    Sql _conn;
    ResultSet _rs;
    Gson _gson = new Gson();
    FOM05_Critica _M05Crit;
    
    @Before
    public void setup()
    {
        String queryAddPerson ="INSERT INTO USUARIO ( usu_id, usu_cedula, usu_nombre,usu_apellido, usu_sexo, usu_fecha_nac ) "
                + "VALUES (9999, 123321,'WEB', 'SERVICES', 'M', '12-12-93' )";
        String queryAddInst ="INSERT INTO INSTRUCTOR(INS_NOMBRE,INS_APELLIDO,INS_FECHA_NAC,INS_SEXO,INS_CORREO,INS_FOTO)"
                + " VALUES('Pedro','Alvares','13-12-94','M','fitpedro@gmail.com',null)";
        String queryAddClass="INSERT INTO CLASE(CLA_NOMBRE,CLA_DESCRIPCION) VALUES ('TRX','TRX master class') ";
        String queryAddHC="INSERT INTO HORARIO_CLASE(HC_ID,HC_FECHA,HC_DIA\n" 
                + ",HC_CAPACIDAD,HC_HORA_INICIO,HC_HORA_FIN,HC_STATUS\n" 
                + ",HC_DURACION,FK_USUARIO,FK_INSTRUCTOR,FK_CLASE) "
                + "VALUES (9999,'12-11-17','LUNES',20,'12:00:00','14:00:00','A',null,null,\n"
                + "(SELECT INS_ID FROM INSTRUCTOR WHERE INS_NOMBRE='Pedro'),\n"
                + "(SELECT CLA_ID FROM CLASE WHERE CLA_NOMBRE='TRX'))";
        String queryAddPersonInClass ="Select * from m05_agregar_participacion(9999,9999)";
        _M05Crit = new FOM05_Critica();
         try 
         {
            _rs = _conn.sql ( queryAddPerson );
            _conn = new Sql();
            _rs = _conn.sql ( queryAddInst );
            _conn = new Sql();
            _rs = _conn.sql ( queryAddClass );
            _conn = new Sql();
            _rs = _conn.sql ( queryAddHC );
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
    }
    
    @Ignore
    @Test
    public void testConsultarClasesSinCritica() throws SQLException{
     
    }
    
    @Test
    public void testInsertarCritica()
    {
  
        try {
            HttpUriRequest request = new HttpGet( "http://localhost:8080/ServiciosGimnasio/FOM05_Critica//insertarCritica?referencia=3&fecha=12-12-12&comentario=HOLAA&valoracion=5" );
            
            HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
            
            assertEquals(
                    httpResponse.getStatusLine().getStatusCode(),
                    equalTo(HttpStatus.SC_NOT_FOUND));
            
        } catch (IOException ex) {
            Logger.getLogger(FOM05_ServicioCriticaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Ignore
    @Test
    public void testEliminarCritica(){
    }

    
}
