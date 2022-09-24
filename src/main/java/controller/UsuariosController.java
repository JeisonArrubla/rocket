package controller;

import java.sql.Statement;
import com.google.gson.Gson;

import beans.Usuarios;
import connection.DBConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuariosController {

    public String registrarUsuario(String cedula, String nombre, String apellido, String email,
            String telefono, String nacionalidad) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "INSERT INTO usuarios VALUES('" + cedula + "', '" + nombre + "', '" + apellido
                + "', '" + email + "', '" + telefono + "', '" + nacionalidad + "')";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Usuarios usuario = new Usuarios(cedula, nombre, apellido, email, telefono, nacionalidad);

            st.close();

            return gson.toJson(usuario);
            
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());

        } finally {
            con.desconectar();
        }
        return "false";
    }

    public String listarUsuarios() {

        Gson gson = new Gson();
        List<String> usuarios = new ArrayList<String>();
        DBConnection con = new DBConnection();

        String sql = "SELECT * FROM usuarios";

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String cedula = rs.getString("cedula");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                String nacionalidad = rs.getString("nacionalidad");

                Usuarios usuario = new Usuarios(cedula, nombre, apellido, email, telefono, nacionalidad);

                usuarios.add(gson.toJson(usuario));
            }
        } catch (Exception ex) {

            System.out.println("Error: " + ex.getMessage());

        } finally {

            con.desconectar();
        }
        return gson.toJson(usuarios);
    }

    public String consultarUsuario(String cedulaUsuario) {

        Gson gson = new Gson();
        String strUsuario = "";
        DBConnection con = new DBConnection();

        String sql = "SELECT * FROM usuarios WHERE cedula=" + cedulaUsuario;

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String cedula = cedulaUsuario;
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                String nacionalidad = rs.getString("nacionalidad");

                Usuarios usuario = new Usuarios(cedula, nombre, apellido, email, telefono, nacionalidad);

                strUsuario = gson.toJson(usuario);
            }
        } catch (Exception ex) {

            System.out.println("Error: " + ex.getMessage());

        } finally {

            con.desconectar();
        }
        return gson.toJson(strUsuario);
    }

    public String actualizarUsuario(String cedula, String nombre, String apellido, String email,
            String telefono, String nacionalidad) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "UPDATE usuarios SET nombre='" + nombre + "', apellido='" + apellido + "', email='" + email + "',telefono='" + telefono + "',nacionalidad='" + nacionalidad + "' WHERE cedula='" + cedula + "'";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Usuarios usuario = new Usuarios(cedula, nombre, apellido, email, telefono, nacionalidad);

            st.close();

            return gson.toJson(usuario);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());

        } finally {
            con.desconectar();
        }
        return "false";
    }
}
