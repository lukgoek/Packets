/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packets;

import java.sql.Connection;
import java.sql.DriverManager;



/**
 *
 * @author Humberto Lugo
 */

public class Conexion {
    
    Connection conectar = null;
    
    //este es metodo no un constructor
    public Connection conectar(){
       
        try{
            //esta clase permite cargar una nueva libreria
            //Carga la libreria si no loa tienes
            Class.forName("com.mysql.jdbc.Driver");
            
                    //diver : tipoBDaconectar :// ruta(ip de servidor) / nombreBD
                    //Usuario
                    //Contraseña
                    conectar = DriverManager.getConnection(
                    "jdbc:mysql://localhost/packets", "root", "");
            
            
        }catch(Exception ex){
            System.out.println("Error: "+ex);
            
        }
        
        
    return conectar;
    }
    
    
    
    
}
