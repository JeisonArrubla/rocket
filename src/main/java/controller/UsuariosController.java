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
}
