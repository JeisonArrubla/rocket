/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import beans.Usuarios;
import connection.ConnectionDB;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Jeison
 */
public class OperacionesBD {

    public static void main(String[] args) {
        
        //listarUsuarios();
        //actualizarUsuarios("1111222333", "Miguel", "Pérez", "mperez@gmail.com", "3112113344", "peruano");
        listarUsuarios();
        registrarUsuarios();
        listarUsuarios();

    }

    public static void actualizarUsuarios(String cedula, String nombre, String apellido, String email, String telefono, String nacionalidad) {
        ConnectionDB conn = new ConnectionDB();

        String sql = "UPDATE usuarios SET nombre = '" + nombre + "' WHERE cedula = " + cedula;

        try {
            Statement st = conn.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            conn.desconectar();
        }
    }
    
    public static void listarUsuarios(){
        
        ConnectionDB conn = new ConnectionDB();

        String sql = "SELECT * FROM usuarios";

        try {
            Statement st = conn.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String cedula = rs.getString("cedula");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                String nacionalidad = rs.getString("nacionalidad");
                
                Usuarios usuario = new Usuarios(cedula, nombre, apellido, email, telefono, nacionalidad);
                System.out.println(usuario.toString());
                
            }
            
            st.executeQuery(sql);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            conn.desconectar();
        }
        
    }
    
    public static void registrarUsuarios(){
        ConnectionDB conn = new ConnectionDB();
        
        String sql = "INSERT INTO usuarios (cedula, nombre, apellido, email, telefono, nacionalidad) VALUES\n" +
"(\"1111444555\", \"Marcos\", \"Méndez\", \"mm@gmail.com\", \"3113002211\", \"Mexicano\")";
        
        try {
            Statement st = conn.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            conn.desconectar();
        }
    }

}
