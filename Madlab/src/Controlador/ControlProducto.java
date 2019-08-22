/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;
import Modelos.producto;
import AccesoBase.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andresfv
 */
public class ControlProducto {
    DaoProducto daoInventario;
    
    public ControlProducto() {
        daoInventario= new DaoProducto();
    }
    
    public String agregarInventario (int nit, String color, String talla, String precio, int cantidad,String nombre) {
        producto i = new producto(nit, color, talla, precio,cantidad,nombre);
        return daoInventario.guardarProducto(i);
    }
    
    public DefaultTableModel cargarInventario(String busqueda){
        return daoInventario.cargarProducto(busqueda);
    }
    
    public String modificarInventario(int nit, String color, String talla, String precio, int cantidad,String nombre){
        producto i = new producto(nit, color, talla, precio,cantidad,nombre);
        return daoInventario.modificarProducto(i);
    }
    
    public String eliminarInvetario (String id){
        return daoInventario.eliminarProducto(id);
    }
    
    public void cerrarConexionBD(){
        daoInventario.cerrarConexionBD();
    }
    
    
}
