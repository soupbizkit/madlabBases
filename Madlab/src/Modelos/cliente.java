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
public class cliente {
    
    private int id;
    private String nombre;
    private String telefono;
    private String direccion;
   
    public cliente (int id, String nombre, String telefono, String direccion){
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;               
    }
    
    public int getId() {
        return id;
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
        
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }    
}
