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
public class producto {
    
    private int nit;
    private String color;
    private String talla;
    private String precio;
    private int cantidad;
    private String nombre;
   
    public producto (int nit, String color, String talla, String precio, int cantidad,String nombre){
        this.nit = nit;
        this.color = color;
        this.talla = talla;
        this.precio = precio;
        this.cantidad = cantidad;                
        this.nombre = nombre;                
    }
    
    public int getNit() {
        return nit;
    }
    
    public String getColor() {
        return color;
    }
    
    public String getTalla() {
        return talla;
    }
    
    public String getPrecio() {
        return precio;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public String getNombre() {
        return nombre;
    }
        
    public void setColor(String color) {
        this.color = color;
    }
    
    public void setTalla(String talla) {
        this.talla = talla;
    }
    
    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
