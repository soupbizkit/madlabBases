/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;
import Modelos.empleado;
import AccesoBase.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andresfv
 */
public class ControlEmpleado {
    Daoempleado daoempleado;
    
    public ControlEmpleado() {
        daoempleado = new Daoempleado();
    }
    
    public String agregarUsuario (int id, String contraseña, String nombre, String telefono, String direccion, String cargo, String salario) {
        empleado u = new empleado(id, contraseña, nombre, telefono, direccion, cargo, salario);
        return daoempleado.guardarUsuario(u);
    }
    
    public String[] consultarUsuario(String id){
        return daoempleado.consultarUsuario(id);
    }
    
    public String modificarUsuario(int id, String contraseña, String nombre, String telefono, String direccion, String cargo, String salario){
        empleado u = new empleado(id, contraseña, nombre, telefono, direccion, cargo, salario);
        return daoempleado.modificarUsuario(u);
    }
    
    public String eliminarUsuario (String cedula){
        return daoempleado.eliminarUsuario(cedula);
    }
    
    public String[] verificarUsuario(String cedula, String password) {
        return daoempleado.verificar(cedula, password);
    }
    
    public DefaultTableModel cargarUsuarios(String busqueda){
        return daoempleado.cargarUsuarios(busqueda);
    }
    
    public DefaultTableModel cargarVendedores(){
         return daoempleado.cargarVendedores();
    }
    
    public void cerrarConexionBD(){
        daoempleado.cerrarConexionBD();
    }
    
}
