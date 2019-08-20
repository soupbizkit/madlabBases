/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoBase;
import Modelos.producto;
import java.sql.*;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrés Felipe
 */
public class DaoProducto {
    DefaultTableModel tabla;
    fachadaBase fachada;
    
    public DaoProducto() {
        fachada = new fachadaBase();
    }
    
    public String guardarProducto(producto p){
        String sql_guardar;
        sql_guardar = "INSERT INTO producto(nit, color, talla, precio, cantidad, nombre) VALUES('" + 
                p.getNit() + "', '" + p.getColor() + "', " + p.getTalla() + ", " + p.getPrecio() + ", " + p.getCantidad() + ", " + p.getNombre() + ")";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();             
            if(sentencia.executeUpdate(sql_guardar)==1){
                return "Producto creado correctamente";
            }else{
                return "Error: No se insertó el producto";
            }
        }
        catch(SQLException e){
            System.out.println(e);
            return "Ya existe un producto con ese Nit";
        }
        catch(Exception e){ 
            System.out.println(e); 
            return "Ha ocurrido un error al crear el producto";
        }        
    }

    public DefaultTableModel cargarProducto(String busqueda){
        String [] Titulo = {"CODIGO","COLOR","TALLA","PRECIO","CANTIDAD","NOMBRE"};
        tabla=new DefaultTableModel(null,Titulo);
        String sql_select;        
        String consulta[] = new String[6];
        sql_select = "SELECT * FROM inventario WHERE (nombre) ilike '%" +busqueda + "%' ORDER BY nit";
        try{
            Connection conn= fachada.getConnetion();            
            Statement sentencia = conn.createStatement();
            ResultSet rs = sentencia.executeQuery(sql_select);   
            
            while(rs.next()){
                consulta[0] = rs.getString(1);
                consulta[1] = rs.getString(2);
                consulta[2] = rs.getString(3);
                consulta[3] = rs.getString(4);
                consulta[4] = rs.getString(5);
                consulta[5] = rs.getString(6);
                tabla.addRow(consulta);
            }
            return tabla;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    public String modificarProducto(producto p){
        String sql_modificar;
        sql_modificar = "UPDATE producto SET nombre='" + p.getNombre() + "', cantidad=" + 
                p.getCantidad() + ", precio=" + p.getPrecio() + " WHERE nit = '" + p.getNit() + "'";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if(sentencia.executeUpdate(sql_modificar)==1){
                return "Producto modificado exitosamente";
            }else{
                return "No existe un producto con ese id";
            }            
        }catch(Exception e){
            System.out.println(e);
            return "Ha ocurrido un error al modificar el producto";
        }
    }

    public String eliminarProducto(String nit){
        String sql_delete;
        sql_delete = "DELETE FROM producto WHERE nit= '" + nit + "'";
        
        try{
            Connection conn= fachada.getConnetion();       
            Statement sentencia = conn.createStatement();            
            if(sentencia.executeUpdate(sql_delete)==1){
                return "Producto eliminado exitosamente";
            }else{
                return "No se eliminó el producto";
            }                
        }catch(Exception e){
            System.out.println(e);
            return "Ocurrió un problema al eliminar el producto";
        }                             
    }
    
    public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }
    
}
