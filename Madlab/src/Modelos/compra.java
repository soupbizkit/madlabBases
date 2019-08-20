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
public class compra {
    private int codfactura;
    private int idcliente;
    private int nit;
    private String fecha;

   
    public compra (int codfactura, int idcliente, int nit, String fecha){
        this.codfactura = codfactura;
        this.idcliente = idcliente;
        this.nit = nit;
        this.fecha = fecha;                
    }
    
    public int getCodfactura() {
        return codfactura;
    }
    
    public int getIdcliente() {
        return idcliente;
    }
    
    public int getNit() {
        return nit;
    }
    
    public String getFecha() {
        return fecha;
    }
            
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
        
}
