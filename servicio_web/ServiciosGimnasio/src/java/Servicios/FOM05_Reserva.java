/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.Clase;
import Dominio.Critica;
//import Dominio.Reserva;
import Dominio.Sql;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author GESTION
 */

public class FOM05_Reserva {
/*    
    private Connection _conn = Sql.getConInstance();
    private Gson _gson = new Gson();
    private ArrayList<Reserva> _listaReservas;
    private String result;
    
    @GET
    
    @Path("/consultarReservas")
    
    @Produces("application/json")
    
    public String consultarReservas() throws SQLException
    {
        String query = "Select * from HORARIO_CLASE";
        
        try
        {
            Statement st = _conn.createStatement();           
            ResultSet rs = st.executeQuery(query);
            Reserva reserva = new Reserva();
         
            while (rs.next())
            {    
               
                reserva.setId(rs.getInt("id"));
                reserva.setFecha(rs.getDate("fecha"));
                reserva.setCapacidad(rs.getInt("capacidad"));
                reserva.setHoraInicio(rs.getDate("hora_inicio"));
                reserva.setHoraFin(rs.getDate("hora_fin"));
                reserva.setDuracion(rs.getDate("duracion"));
                reserva.setIdUsuario(rs.getInt("usuario"));
                reserva.setIdInstructor(rs.getInt("instructor"));
                reserva.setIdClase(rs.getInt("clase"));
                
                _listaReservas.add(reserva);
            }
            //result = _gson.toJson(_listaReservas);
            return _gson.toJson(_listaReservas);
        }
        catch (SQLException e)
        {
            return e.getMessage();
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
        finally
        {
            Sql.bdClose(_conn);
        }
    } 
    /*
    @GET
    
    @Path("/reservarClase")
    
    @Produces("application/json")
    
    public String reservarClase(@QueryParam("fk_clase") int _idClase,
            @QueryParam("fk_instructor") int _idInstructor, @QueryParam("fk_usuario") int _idUsuario,
            @QueryParam("hc_fecha") Date _fecha, @QueryParam("hc_dia") String _dia,
            @QueryParam("hc_capacidad") int _capacidad, @QueryParam("hc_hora_inicio") Date _hora_inicio,
            @QueryParam("hc_hora_fin") Date _hora_fin,@QueryParam("hc_status") String _status,
            @QueryParam("hc_duracion") Date _duracion,  @QueryParam("fk_clase") int _idClase) throws SQLException
    {
        String query = "insert into HORARIO_CLASE (hc_fecha,hc_dia,hc_capacidad,hc_hora_inicio,hc_hora_fin,hc_status,hc_duracion,fk_usuario,fk_instructor,fk_clase) "
                + "values ('"+_fecha+"','"+_dia+"',"+_capacidad+",'"+_hora_inicio+"','"+_hora_fin+"','"+_status+"',"+_duracion+","+_idUsuario+","+_idInstructor+","+_idClase+")";
        
        try
        {
            Statement st = _conn.createStatement();           
            st.executeUpdate(query);
            return _gson.toJson(true);
        }
        catch (SQLException e)
        {
            return e.getMessage();
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
        finally
        {
            Sql.bdClose(_conn);
        }
    } 
    */
    /*
    @GET
    
    @Path("/verificarDisponibilidad")
    
    @Produces("application/json")
    
    public String verificarDisponibilidad(@QueryParam("pk_clase") int _idClase) throws SQLException
    {
        String query = "Select (count(hc_id)) as disp from HORARIO_CLASE where pk_clase="+_idClase;
        int _disp=0,_cap=0;
        try
        {
            Statement st = _conn.createStatement();           
            ResultSet rs = st.executeQuery(query);
         
            while (rs.next())
            {    
               
                _disp = rs.getInt("disp");
                query="select hc_capacidad from horario_clase where pk_clase="+_idClase+" limit 1";
                rs = st.executeQuery(query);
                rs.next();
                _cap=rs.getInt("capacidad");
                if(_cap >=_disp){
                    return _gson.toJson(true);
                }
                else
                {
                    return _gson.toJson(false);
                }
                
            }
            //result = _gson.toJson(_listaReservas);
            return _gson.toJson(true);
        }
        catch (SQLException e)
        {
            return e.getMessage();
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
        finally
        {
            Sql.bdClose(_conn);
        }
    } 
    
    */
}
