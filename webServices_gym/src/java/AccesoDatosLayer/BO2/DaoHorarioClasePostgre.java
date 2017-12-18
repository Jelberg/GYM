/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.BO2;

import AccesoDatosLayer.DaoPostgre;
import Comun.Dominio.Clase;
import Comun.Dominio.Entidad;
import Comun.Dominio.HorarioClase;
import Comun.Excepciones.ParameterNullException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marvian
 */
public class DaoHorarioClasePostgre extends DaoPostgre implements IDaoHorarioClase {
    private Connection _conn = getInstancia();
    private ArrayList<HorarioClase> jsonArray;
    
    public DaoHorarioClasePostgre() {}
       

    @Override
    public Entidad consultar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   
    @Override
    public Entidad insertar(Entidad ent) {
       try {
            
            String query = "select * from bo_m02_inserta_horario_clase(?,?,?,?,?,?,?,?,?)";
            _conn = getConexion();
            HorarioClase horarioclase = ( HorarioClase ) ent;
            PreparedStatement st = _conn.prepareStatement(query);
                st.setDate(1, horarioclase.getFecha());
                st.setString(2, horarioclase.getDia());
                st.setInt(3, horarioclase.getCapacidad());
                st.setTime(4, horarioclase.getHoraInicio());
                st.setTime(5, horarioclase.getHoraFin());
                st.setString(6, horarioclase.getStatus());
                st.setInt(7, horarioclase.getDuracion());
                st.setInt(8, horarioclase.getNombreclase());
                st.setInt(9, horarioclase.getInstructor());
                st.executeQuery();
            ent.setMensaje( "Se ha insertado correctamente." );
        }
        catch (SQLException e){
            ent.setMensaje( "Se ha insertado correctamente." );
        }
        catch (ParameterNullException e) {
            ent.setMensaje( "Error al ingresa valor, intente de nuevo." );
        }
        catch (Exception e) {
            ent.setMensaje( "Error" );
        }
        finally {
            cerrarConexion(_conn);
            return ent;
        }
    }

    @Override
    public Entidad modificar(Entidad ent) {
      try {
            
            String query = "select * from bo_m02_modifica_horario_clase(?,?,?,?,?,?,?)";
            _conn = getConexion();
            HorarioClase horarioclase = ( HorarioClase ) ent;
            PreparedStatement st = _conn.prepareStatement(query);
                st.setInt(1, horarioclase.getNombreclase());
                st.setInt(2, horarioclase.getInstructor());
                st.setDate(3, horarioclase.getFecha());
                st.setString(4, horarioclase.getDia());
                st.setInt(5, horarioclase.getCapacidad());
                st.setTime(6, horarioclase.getHoraInicio());
                st.setTime(7, horarioclase.getHoraFin());
            ResultSet rs = st.executeQuery();
            
            ent.setMensaje( "Se ha Eliminado correctamente." );
        }
        catch (SQLException e){
            ent.setMensaje( "Error, intente de nuevo" );
        }
        catch (ParameterNullException e) {
            ent.setMensaje( "Error al ingresa valor, intente de nuevo." );
        }
        catch (Exception e) {
            ent.setMensaje( "Error" );
        }
        finally {
            cerrarConexion(_conn);
            return ent;
        }
    } 

    @Override
    public Entidad eliminar(Entidad ent) {
     try{
        HorarioClase horarioclase = ( HorarioClase ) ent;
        _conn = getConexion();
        String query = "SELECT * from bo_m02_elimina_horario_clase(?)";
        PreparedStatement st = _conn.prepareStatement(query);
        st.setInt(1, horarioclase.getId());
        ResultSet rs = st.executeQuery();
        ent.setMensaje( "Se ha Eliminado correctamente." );
        }
        catch (SQLException e){
            ent.setMensaje( "Error, intente de nuevo" );
        }
        catch (ParameterNullException e) {
            ent.setMensaje( "Error al ingresa valor, intente de nuevo." );
        }
        catch (Exception e) {
            ent.setMensaje( "Error" );
        }
        finally {
            cerrarConexion(_conn);
            return ent;
        }
    }

    @Override
    public ArrayList<HorarioClase> consultarHorarioClase() {
      try{
            _conn = getConexion();
            String query = "SELECT * FROM bo_m02_get_horarios();";
            jsonArray = new ArrayList<>();
            PreparedStatement st = _conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                jsonArray.add(new HorarioClase());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("id"));
                jsonArray.get(jsonArray.size() - 1).setNombreConsulta(rs.getString("nombreclase"));
                jsonArray.get(jsonArray.size() - 1).setInstructorConsulta(rs.getString("instructor"));
                jsonArray.get(jsonArray.size() - 1).setFecha(rs.getDate("fecha"));
                jsonArray.get(jsonArray.size() - 1).setDia(rs.getString("dia"));
                jsonArray.get(jsonArray.size() - 1).setCapacidad(rs.getInt("capacidad"));
                jsonArray.get(jsonArray.size() - 1).setHoraInicio(rs.getTime("hora_inicio"));
                jsonArray.get(jsonArray.size() - 1).setHoraFin(rs.getTime("hora_fin"));        
            }
        }
        catch(SQLException e) {
            jsonArray.get(0).setMensaje( "Error con la conexion, intente de nuevo." );
        
        }
        catch (ParameterNullException e) {
            jsonArray.get(0).setMensaje( "Parametro vacio" );
        }
        catch (Exception e) {
            jsonArray.get(0).setMensaje( "Error." );

        }
        finally {
            cerrarConexion(_conn);
            return jsonArray;
        }
    }
    
}
