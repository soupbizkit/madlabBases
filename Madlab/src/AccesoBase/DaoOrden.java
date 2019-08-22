/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoBase;
import Modelos.orden;
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
public class DaoOrden {
    DefaultTableModel tabla;
    fachadaBase fachada;
    
    public DaoOrden() {
        fachada = new fachadaBase();
    }
    
    public String guardarOrden(orden o){
        String sql_guardar;
        sql_guardar = "INSERT INTO orden(codigo, idemp, nit, cantidad, fecha, estado) VALUES('" + 
                o.getNit() + "', '" + o.getIdemp() + "', " + o.getNit() + ", " + o.getCantidad() + ", " + o.getEstado() + ", " + o.getFecha() + ")";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();             
            if(sentencia.executeUpdate(sql_guardar)==1){
                return "Orden creada correctamente";
            }else{
                return "Error: No se creo la orden";
            }
        }
        catch(SQLException e){
            System.out.println(e);
            return "Ya existe una orden con ese id";
        }
        catch(Exception e){ 
            System.out.println(e); 
            return "Ha ocurrido un error al crear la orden";
        }        
    }
    public String[] consultarOrden(String id){
        String sql_select;        
        String consulta[] = new String[6];
        sql_select = "SELECT * FROM orden WHERE codigo = '" + id + "'";
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
            }else{
                consulta = null;
            }
            return consulta;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public String modificarOrden(orden o){
        String sql_modificar;
        sql_modificar = "UPDATE ordenes SET idemp='" + o.getIdemp() + "', nit='" + 
                o.getNit() + "', cantidad=" + o.getCantidad() + ", estado ='" + o.getEstado() + ", fecha ='" + o.getFecha() + 
                "' WHERE codigo = '" + o.getCodigo() + "'";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if(sentencia.executeUpdate(sql_modificar)==1){
                return "Orden modificada exitosamente";
            }else{
                return "No existe una orden con ese id";
            }            
        }catch(Exception e){
            System.out.println(e);
            return "Ha ocurrido un error al modificar la orden";
        }
    }
    
    public String eliminarOrden(String id){
        String sql_delete;
        sql_delete = "DELETE FROM orden WHERE codigo= '" + id + "'";
        
        try{
            Connection conn= fachada.getConnetion();       
            Statement sentencia = conn.createStatement();            
            if(sentencia.executeUpdate(sql_delete)==1){
                return "Orden eliminada exitosamente";
            }else{
                return "No se eliminó la orden";
            }                
        }catch(Exception e){
            System.out.println(e);
            return "Ocurrió un problema al eliminar la orden";
        }                             
    }
    
    public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }
    
    public DefaultTableModel cargarOrdenes(String busqueda){
        String [] Titulo = {"CODIGO","CEDULA JEFE","PRODUCTO","CANTIDAD","ESTADO","FECHA"};
        tabla=new DefaultTableModel(null,Titulo);
        String sql_select;        
        String consulta[] = new String[6];
        sql_select = "SELECT * FROM orden WHERE (codigo) ilike '%" +busqueda + "%' and estado = 'Sin aprobar' ORDER BY codigo";
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
    
    public DefaultTableModel cargarTodasOrdenes(String busqueda){
        String [] Titulo = {"CODIGO", "ESTADO"};
        tabla=new DefaultTableModel(null,Titulo);
        String sql_select;        
        String consulta[] = new String[6];
        sql_select = "SELECT * FROM orden WHERE (codigo) ilike '%" + busqueda + "%' ORDER BY codigo";
        try{
            Connection conn= fachada.getConnetion();            
            Statement sentencia = conn.createStatement();
            ResultSet rs = sentencia.executeQuery(sql_select);   
            
            while(rs.next()){
                consulta[0] = rs.getString(1);
                consulta[1] = rs.getString(6);
                tabla.addRow(consulta);
            }
            return tabla;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public void sumarProducto(String id_producto, int peticion){
        String sql_select;
        String consulta = "";
        sql_select = "SELECT cantidad FROM producto WHERE nit = '" + id_producto + "'";
        String sql_modificar;
        
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement(); 
             ResultSet tabla = sentencia.executeQuery(sql_select);   
            
            if(tabla.next()){
                consulta = tabla.getString(1);
            }
            
            int cantidad = Integer.parseInt(consulta);
            int valorActualizado = cantidad + peticion;
              
            sql_modificar = "UPDATE producto SET cantidad=" + valorActualizado + " WHERE nit ='" + id_producto + "'";
            sentencia.executeQuery(sql_modificar);
        }
        catch(Exception e){
            System.out.println(e);
        }       
    }
    
    public String aprobarOrden(String id, String producto, int peticion){
        String sql_modificar;
        sql_modificar = "UPDATE orden SET estado='Aprobada' WHERE codigo = '" + id + "'";
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if(sentencia.executeUpdate(sql_modificar)==1){
                sumarProducto(producto, peticion);
                return "La orden fue aprobada exitosamente";
            }else{
                return "Ha ocurrido un error al aprobar la orden";
            } 
        }catch(Exception e){
            System.out.println(e);
            return "Ha ocurrido un error al modificar la orden";
        }
    }
    
    public String generarIdOrden(){
        String sql_select;        
        String id_orden = "001"; 
        sql_select = "SELECT MAX(codigo) FROM orden";
        try{
            Connection conn= fachada.getConnetion();            
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);   
            
            if(tabla.next()){
                if(tabla.getString(1) != null){
                    int codigo = Integer.parseInt(tabla.getString(1)) + 1;
                    if((codigo >= 100) && (codigo < 1000)){
                        id_orden = Integer.toString(codigo);
                    }
                    if((codigo >= 10) && (codigo < 100)){
                        id_orden = "0" + codigo;
                    }
                    if(codigo <= 9){
                        id_orden = "00" + codigo;
                    }
                }else{
                    id_orden = "001";
                }
            }else{
                id_orden = "001";
            }
            return id_orden;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
}
