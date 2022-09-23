package test;

import beans.Usuarios;
import connection.DBConnection;
import controller.UsuariosController;
import controller.RegistrosController;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesBD {

    public static void main(String[] args) {
        
        UsuariosController usuarios = new UsuariosController();
        RegistrosController registros = new RegistrosController();

        //registrarUsuarios();
        //listarUsuarios();
        //actualizarUsuarios("1111222333", "Miguel", "Pérez", "mperez@gmail.com", "3112113344", "peruano");
        //ingresarRegistro();
        System.out.println(registros.listarRegistros());
        System.out.println(usuarios.listarUsuarios());
    }

    public static void registrarUsuarios() {
        DBConnection conn = new DBConnection();

        String sql = "INSERT INTO usuarios (cedula, nombre, apellido, email, telefono, nacionalidad) VALUES\n"
                + "(\"1111444555\", \"Marcos\", \"Méndez\", \"mm@gmail.com\", \"3113002211\", \"Mexicano\")";

        try {
            Statement st = conn.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            conn.desconectar();
        }
    }

    public static void actualizarUsuarios(String cedula, String nombre, String apellido, String email, String telefono, String nacionalidad) {
        DBConnection conn = new DBConnection();

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

    public static void listarUsuarios() {

        DBConnection conn = new DBConnection();

        String sql = "SELECT * FROM usuarios";

        try {
            Statement st = conn.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
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

    public static void ingresarRegistro() {
        DBConnection conn = new DBConnection();

        String sql = "INSERT INTO ingresos (cedula, fecha_llegada, fecha_salida, ciudad_origen, id_habitacion) VALUES\n"
                + "(\"1020333444\", \"2022-09-17\", \"2022-09-18\", \"Lima\", \"10\")";

        try {
            Statement st = conn.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            conn.desconectar();
        }

        System.out.println("Ingreso registrado con éxitoso.");
    }
}
