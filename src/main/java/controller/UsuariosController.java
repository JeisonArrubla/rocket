package controller;

import java.sql.Statement;
import com.google.gson.Gson;

import beans.Usuarios;
import connection.DBConnection;

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

}
