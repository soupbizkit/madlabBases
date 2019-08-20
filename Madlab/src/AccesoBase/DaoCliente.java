/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoBase;
import Modelos.cliente;
import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrés Felipe
 */
public class DaoCliente {
    
    DefaultTableModel tabla;
    fachadaBase fachada;
    
    public DaoCliente() {
        fachada = new fachadaBase();
    }
    
}
