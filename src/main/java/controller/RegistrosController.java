package controller;

import java.sql.Statement;
import com.google.gson.Gson;

import beans.Registros;
import connection.DBConnection;
import utilities.Queries;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegistrosController {

    public String registrarIngreso(String cedula, String fechaLlegada, String fechaSalida, String ciudadOrigen,
            int idHabitacion) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        Queries querie = new Queries();
        int id = querie.generarId("id_registro", "registros");

        String sql = "INSERT INTO registros VALUES('" + id + "', '" + cedula + "', '" + fechaLlegada + "', '"
                + fechaSalida + "', '" + ciudadOrigen + "', '" + idHabitacion + "')";

        try {

            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Registros ingreso = new Registros(id, cedula, fechaLlegada, fechaSalida, ciudadOrigen, idHabitacion);

            st.close();

            return gson.toJson(ingreso);

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            
        } finally {
            con.desconectar();
        }
        return "false";
    }

    public String listarRegistros() {

        Gson gson = new Gson();
        List<String> registros = new ArrayList<String>();
        DBConnection con = new DBConnection();

        String sql = "SELECT * FROM registros";

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("id_registro");
                String cedula = rs.getString("cedula");
                String fecha_llegada = rs.getString("fecha_llegada");
                String fecha_salida = rs.getString("fecha_salida");
                String ciudad_origen = rs.getString("ciudad_origen");
                int id_habitacion = rs.getInt("id_habitacion");

                Registros ingreso = new Registros(id, cedula, fecha_llegada, fecha_salida, ciudad_origen, id_habitacion);

                registros.add(gson.toJson(ingreso));
            }
        } catch (Exception ex) {
            
            System.out.println("Error: " + ex.getMessage());
            
        } finally {
            
            con.desconectar();
        }
        return gson.toJson(registros);
    }
}
