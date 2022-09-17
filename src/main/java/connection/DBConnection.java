/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Jeison
 */
public class DBConnection {
    
    Connection connection;
    
    static String bd = "registros"; // Nombre de la base de datos
    static String port = "3306";
    static String login = "root";
    static String password = "admin";

    public DBConnection() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:"+this.port+"/"+this.bd;
            connection = DriverManager.getConnection(url, this.login, this.password);
            System.out.println("Conexión exitosa!");
        } catch (Exception ex) {
            System.out.println("Error de conexión: "+ex);
        }
        
    }
    
    public Connection getConnection(){
        return connection;
    }
    
    public void desconectar(){
        connection = null;
    }
    
}
