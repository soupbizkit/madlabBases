/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoBase;

import Modelos.empleado;
import java.sql.*;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrés Felipe
 */
public class Daoempleado {
    DefaultTableModel tabla;
    fachadaBase fachada;
    
    
    public Daoempleado() {
        fachada = new fachadaBase();
    }
    
    public String guardarUsuario(empleado u){
        String sql_guardar;
        sql_guardar = "INSERT INTO usuarios VALUES('" + u.getId()+ "', '" + 
                u.getNombre()+ "', '" + u.getTelefono() + "', '" + u.getDireccion() + "', '" +
                u.getCargo() + "', '" +  u.getContraseña() + "', '" + u.getSalario() + "')";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();             
            if(sentencia.executeUpdate(sql_guardar)==1){
                return "Usuario creado correctamente";
            }else{
                return "Error: No se insertó el usuario";
            }
        }
        catch(SQLException e){
            System.out.println(e);
            return "Ha ocurrido un error al crear el usuario";
        }
        catch(Exception e){ 
            System.out.println(e); 
            return "Ha ocurrido un error al crear el usuario";
        }        
    }
    
    public String[] consultarUsuario(String id){
        String sql_select;        
        String consulta[] = new String[10];
        sql_select = "SELECT * FROM empleado WHERE id = '" + id + "'";
        try{
            Connection conn= fachada.getConnetion();            
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);   
            
            if(tabla.next()){
                consulta[0] = tabla.getString(1);
                consulta[1] = tabla.getString(2);
                consulta[2] = tabla.getString(3);
                consulta[3] = tabla.getString(4);
                consulta[4] = tabla.getString(5);
                consulta[5] = tabla.getString(6);
                consulta[6] = tabla.getString(7);
  
            }else{
                consulta = null;
            }
            return consulta;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public String modificarUsuario(empleado u){
        String sql_modificar;
        sql_modificar = "UPDATE usuarios SET nombre='" + u.getNombre() + "', telefono='" + u.getTelefono() +
                "', direccion='" + u.getDireccion() + "', cargo='" + u.getCargo() + "', contraseña='" + u.getContraseña() +
                 "', direccion='" + u.getDireccion() + "', salario='" + u.getSalario() + "' WHERE cedula = '" + u.getId() + "'";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if(sentencia.executeUpdate(sql_modificar)==1){
                return "Usuario modificado exitosamente";
            }else{
                return "No existe un usuario con ese id";
            }            
        }catch(Exception e){
            System.out.println(e);
            return "Ha ocurrido un error al modificar el usuario";
        }
    }
    
    public String eliminarUsuario(String id){
        String sql_delete;
        sql_delete = "DELETE FROM empleado WHERE id = '" + id + "'";
        
        try{
            Connection conn= fachada.getConnetion();       
            Statement sentencia = conn.createStatement();            
            if(sentencia.executeUpdate(sql_delete)==1){
                return "Usuario eliminado exitosamente";
            }else{
                return "No se eliminó el usuario";
            }                
        }catch(Exception e){
            System.out.println(e);
            return "Ocurrió un problema al eliminar el usuario";
        }                             
    }
    
    public String[] verificar(String cedula, String password){
        String sql_select;        
        String consulta[] = new String[2];
        sql_select = "SELECT cargo FROM empleado WHERE id = '" + cedula + "' and contraseña = '" + password + "'";
        try{
            Connection conn= fachada.getConnetion();            
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);   
            
            if(tabla.next()){
                consulta[0] = tabla.getString(1);
                consulta[1] = tabla.getString(2);     
            }else{
                consulta[0] = "El usuario o la contraseña son incorrectos";
                consulta[1] = "";
            }
            return consulta;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public DefaultTableModel cargarUsuarios(String busqueda){
        String [] Titulo = {"CEDULA","NOMBRE"};
        tabla=new DefaultTableModel(null,Titulo);
        String sql_select;        
        String consulta[] = new String[2];
        sql_select = "SELECT * FROM empleado WHERE (nombre) ilike '%" +busqueda + "%' ORDER BY id";
        try{
            Connection conn= fachada.getConnetion();            
            Statement sentencia = conn.createStatement();
            ResultSet rs = sentencia.executeQuery(sql_select);   
            
            while(rs.next()){
                consulta[0] = rs.getString(1);
                consulta[1] = rs.getString(4);
                tabla.addRow(consulta);
            }
            return tabla;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public DefaultTableModel cargarVendedores(){
        String [] Titulo = {"CEDULA","NOMBRE"};
        tabla=new DefaultTableModel(null,Titulo);
        String sql_select;        
        String consulta[] = new String[2];
        sql_select = "SELECT * FROM empleado WHERE cargo = 'Vendedor' ORDER BY id";
        try{
            Connection conn= fachada.getConnetion();            
            Statement sentencia = conn.createStatement();
            ResultSet rs = sentencia.executeQuery(sql_select);   
            
            while(rs.next()){
                consulta[0] = rs.getString(1);
                consulta[1] = rs.getString(4);
                tabla.addRow(consulta);
            }
            return tabla;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }
    
}
