/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoBase;
import Modelos.cliente;
import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrés Felipe
 */
public class DaoCliente {
    
    DefaultTableModel tabla;
    fachadaBase fachada;
    
    public DaoCliente() {
        fachada = new fachadaBase();
    }
    
    public String guardarCliente(cliente c){
        String sql_guardar;
        sql_guardar = "INSERT INTO cliente VALUES('" + c.getId()+ "', '" + 
                c.getNombre()+ "', '" + c.getTelefono() + "', '" + c.getDireccion() + "')";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();             
            if(sentencia.executeUpdate(sql_guardar)==1){
                return "Cliente creado correctamente";
            }else{
                return "Error: No se insertó el cliente";
            }
        }
        catch(SQLException e){
            System.out.println(e);
            return "Ha ocurrido un error al crear el cliente";
        }
        catch(Exception e){ 
            System.out.println(e); 
            return "Ha ocurrido un error al crear el cliente";
        }        
    }
    
    public String[] consultarCliente(String id){
        String sql_select;        
        String consulta[] = new String[10];
        sql_select = "SELECT * FROM cliente WHERE id = '" + id + "'";
        try{
            Connection conn= fachada.getConnetion();            
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);   
            
            if(tabla.next()){
                consulta[0] = tabla.getString(1);
                consulta[1] = tabla.getString(2);
                consulta[2] = tabla.getString(3);
                consulta[3] = tabla.getString(4);
  
            }else{
                consulta = null;
            }
            return consulta;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public String modificarCliente(cliente c){
        String sql_modificar;
        sql_modificar = "UPDATE cliente SET nombre='" + c.getNombre() + "', telefono='" + c.getTelefono() +
                "', direccion='" + c.getDireccion() + "'";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if(sentencia.executeUpdate(sql_modificar)==1){
                return "Cliente modificado exitosamente";
            }else{
                return "No existe un cliente con ese id";
            }            
        }catch(Exception e){
            System.out.println(e);
            return "Ha ocurrido un error al modificar el cliente";
        }
    }
    
    public String eliminarCliente(String id){
        String sql_delete;
        sql_delete = "DELETE FROM cliente WHERE id = '" + id + "'";
        
        try{
            Connection conn= fachada.getConnetion();       
            Statement sentencia = conn.createStatement();            
            if(sentencia.executeUpdate(sql_delete)==1){
                return "cliente eliminado exitosamente";
            }else{
                return "No se eliminó el cliente";
            }                
        }catch(Exception e){
            System.out.println(e);
            return "Ocurrió un problema al eliminar el cliente";
        }                             
    }
    
    public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }
    
}
