/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Andrés Felipe
 */
public class empleado {
    
    private int id;
    private String nombre;
    private String contraseña;
    private String telefono;
    private String direccion;
    private String cargo;
    private String salario;
    
    public empleado (int id, String contraseña, String nombre, String telefono, String direccion, String cargo, String salario){
        this.id = id;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cargo = cargo;
        this.salario = salario;
        
    }
    
    public int getId() {
        return id;
    }
    
    public String getContraseña() {
        return contraseña;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public String getCargo() {
        return cargo;
    }
    
    public String getSalario() {
        return salario;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public void setSalario(String salario) {
        this.salario = salario;
    }
    
    
    
   
}
