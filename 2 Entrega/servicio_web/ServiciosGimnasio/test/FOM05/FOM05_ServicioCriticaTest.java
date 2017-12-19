/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FOM05;

import Dominio.Sql;
import Servicios.FOM05_Critica;

import com.google.gson.Gson;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.http.HttpStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Elberg
 */
public class FOM05_ServicioCriticaTest {
    Sql _conn = new Sql();
    ResultSet _rs;
    Gson _gson = new Gson();
    FOM05_Critica _M05Crit;
    
    @Before
    public void setup()
    {
        String queryAddPerson = "INSERT INTO USUARIO ( usu_id, usu_cedula, usu_nombre,usu_apellido, usu_sexo, usu_fecha_nac,usu_telefono, usu_estatura,usu_foto,usu_correo ) VALUES (9999, 123321,'WEB', 'SERVICES', 'M', '12-12-93','67382',13,null,'elberg@gmail.com' )";
        String insertIns ="INSERT INTO INSTRUCTOR(INS_ID,INS_NOMBRE,INS_APELLIDO,INS_FECHA_NAC,INS_SEXO,INS_CORREO,INS_FOTO) VALUES(9999,'Pedro','Alvares','13-12-94','M','fitpedro@gmail.com',null);";
        String insertCl="INSERT INTO CLASE(CLA_ID,CLA_NOMBRE,CLA_DESCRIPCION) VALUES (9999,'Yoga','yoga master class') ;";
        String insertHc="INSERT INTO HORARIO_CLASE(HC_ID,HC_FECHA,HC_DIA\n" +
",HC_CAPACIDAD,HC_HORA_INICIO,HC_HORA_FIN,HC_STATUS\n" +
",HC_DURACION,FK_USUARIO,FK_INSTRUCTOR,FK_CLASE) VALUES (9999,'12-11-17','LUNES',20,'12:00:00','14:00:00','A',null,9999,\n" +
"9999,\n" +
"9999 );";
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
        String deleteCla=" delete from clase where cla_id=9999";
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
    
  
    
    @Ignore
    @Test
    public void testConsultarClasesSinCritica() throws SQLException{
     
    }
    
    @Ignore
    @Test
    public void testInsertarCritica() throws URISyntaxException
    {
        try{
        final URI prueba = new URI ( "http://localhost:8080/ServiciosGimnasio/FOM05_Critica/insertarCritica?referencia=9999&fecha=12-12-12&comentario=HOLAA&valoracion=5" );     
         given().accept(ContentType.JSON).when().get(prueba).then().assertThat().statusCode(HttpStatus.SC_OK);
        
       //   String json = given().accept(ContentType.JSON).when().get(prueba).thenReturn().body().asString();
        
       // assertNotNull(json);
        }
        catch(URISyntaxException e){
            e.printStackTrace();
        }
        catch(NullPointerException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    @Ignore
    @Test
    public void testEliminarCritica(){
    }

    
}
