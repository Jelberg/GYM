/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.BO2;

import AccesoDatosLayer.Dao;
import AccesoDatosLayer.DaoPostgre;
import AccesoDatosLayer.IDao;
import Comun.Dominio.Entidad;
import Comun.Dominio.Entrenador;
import Comun.Excepciones.ParameterNullException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author gilbert
 */
public class DaoEntrenadorPostgre extends DaoPostgre implements IDaoEntrenador{
    private Connection _conn;
    private ArrayList<Entrenador> jsonArray;
    public DaoEntrenadorPostgre(){}
    
    @Override
    public Entidad consultar(Entidad ent) {
        try{
            String query = "SELECT * FROM bo_m02_get_entrenadores( ? );";
            _conn = Dao.getPostgreBdConnect();
            Entrenador entrenador = ( Entrenador ) ent;
            jsonArray = new ArrayList<>();
            PreparedStatement st = _conn.prepareStatement(query);
            st.setString( 1, entrenador.getCorreo() );
            ResultSet rs = st.executeQuery();
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                jsonArray.add(new Entrenador());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("id"));
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("nombre"));
                jsonArray.get(jsonArray.size() - 1).setApellido(rs.getString("apellido"));
                Date dte;
                Date dte1=rs.getDate("fechanac");
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = formatter.format(dte1);
                dte  = formatter.parse(formattedDate);
                jsonArray.get(jsonArray.size() - 1).setFecha_nac(rs.getDate("fechanac"));
                jsonArray.get(jsonArray.size() - 1).setSexo(rs.getString("sexo"));
                jsonArray.get(jsonArray.size() - 1).setCorreo(rs.getString("correo"));
                jsonArray.get(jsonArray.size() - 1).setHistorial(rs.getString("historial"));           
                }
            
        }
        catch(SQLException | ParameterNullException e) {
            
        }
        finally {
            Dao.closePostgreConnection( _conn );
            return jsonArray.get(0);
        }
        
    }

    @Override
    public Entidad eliminar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entidad modificar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entidad insertar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Entrenador> consultarEntrenadores() {
        try{
            _conn = Dao.getPostgreBdConnect();
            String query = "SELECT ent_id, ent_nombre, ent_apellido, ent_fecha_nac, ent_sexo, ent_correo, ent_historial FROM entrenador;";
            jsonArray = new ArrayList<>();
            PreparedStatement st = _conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                jsonArray.add(new Entrenador());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("ENT_ID"));
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("ENT_NOMBRE"));
                jsonArray.get(jsonArray.size() - 1).setApellido(rs.getString("ENT_APELLIDO"));
                jsonArray.get(jsonArray.size() - 1).setFecha_nac(rs.getDate("ENT_FECHA_NAC"));
                jsonArray.get(jsonArray.size() - 1).setSexo((rs.getString("ENT_SEXO")));
                jsonArray.get(jsonArray.size() - 1).setCorreo(rs.getString("ENT_CORREO"));
                jsonArray.get(jsonArray.size() - 1).setHistorial(rs.getString("ENT_HISTORIAL"));
                          
            }
            
        }
        catch(SQLException e) {
            
        }
        catch (ParameterNullException e) {
        }
        finally {
            Dao.closePostgreConnection( _conn );
            return jsonArray;
        }
    }
    
    
}
