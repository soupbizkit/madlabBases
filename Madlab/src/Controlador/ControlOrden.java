/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;
import Modelos.orden;
import AccesoBase.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andresfv
 */
public class ControlOrden {
    DaoOrden daoOrden;
    
    public ControlOrden() {
        daoOrden= new DaoOrden();
    }
    
    public String agregarOrden (int codigo, int idemp, int nit, int cantidad, String estado, String fecha ) {
        orden o = new orden(codigo, idemp, nit, cantidad, estado, fecha);
        return daoOrden.guardarOrden(o);
    }
    
    public String[] consultarOrden(String id){
        return daoOrden.consultarOrden(id);
    }
    
    public String modificarOrden(int codigo, int idemp, int nit, int cantidad, String estado, String fecha ){
        orden o = new orden(codigo, idemp, nit, cantidad, estado, fecha);
        return daoOrden.modificarOrden(o);
    }
    
    public String eliminarOrden (String id){
        return daoOrden.eliminarOrden(id);
    }
    
    public String aprobarOrden(String id_orden, String producto, int peticion){
        return daoOrden.aprobarOrden(id_orden, producto, peticion);
    }
    
    public DefaultTableModel cargarOrdenes(String busqueda){
        return daoOrden.cargarOrdenes(busqueda);
    }
    
    public DefaultTableModel cargarTodasOrdenes(String busqueda){
        return daoOrden.cargarTodasOrdenes(busqueda);
    }
    
    public String generarIdOrden(){
        return daoOrden.generarIdOrden();
    }
    
    public void cerrarConexionBD(){
        daoOrden.cerrarConexionBD();
    }
    
}
