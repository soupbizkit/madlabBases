/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;
import Modelos.cliente;
import AccesoBase.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andresfv
 */
public class ControlCliente {
    DaoCliente daoCliente;
    
    public ControlCliente() {
        daoCliente= new DaoCliente();
    }
    
    public String agregarCliente (int id, String nombre, String telefono, String direccion) {
        cliente i = new cliente(id, nombre, telefono, direccion);
        return daoCliente.guardarCliente(i);
    }
    
    public String[] cargarClientes(String busqueda){
        return daoCliente.consultarCliente(busqueda);
    }
    
    public String modificarClientes(int id, String nombre, String telefono, String direccion){
        cliente i = new cliente(id, nombre, telefono, direccion);
        return daoCliente.modificarCliente(i);
    }
    
    public String eliminarClientes (String id){
        return daoCliente.eliminarCliente(id);
    }
    
    public void cerrarConexionBD(){
        daoCliente.cerrarConexionBD();
    }
    
}
