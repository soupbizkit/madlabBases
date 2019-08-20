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
public class orden {
    
    private int codigo;
    private int idemp;
    private int nit;
    private int cantidad;
    private String estado;
    private String fecha;
    
    public orden(int codigo, int idemp, int nit, int cantidad, String estado, String fecha ){
        this.codigo = codigo;
        this.idemp = idemp;
        this.nit = nit;
        this.cantidad = cantidad;
        this.estado = estado;
        this.fecha = fecha;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public int getIdemp() {
        return idemp;
    }
    
    public int getNit() {
        return nit;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public String getFecha() {
        return fecha;
    }
    
    public void setIdemp(int idemp) {
        this.idemp = idemp;
    }
    
    public void setNit(int nit) {
        this.nit = nit;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }    
}
