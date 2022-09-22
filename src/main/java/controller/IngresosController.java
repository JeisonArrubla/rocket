package controller;

import java.sql.Statement;
import com.google.gson.Gson;

import beans.Ingresos;
import connection.DBConnection;
import connection.Queries;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IngresosController {

    public String registrarIngreso(String cedula, String fechaLlegada, String fechaSalida, String ciudadOrigen,
            int idHabitacion) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        Queries querie = new Queries();
        int id = querie.generarId("id_registro", "ingresos");

        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String fechaLlegadaFormateada = fechaLlegada;
        String fechaSalidaFormateada = fechaSalida;

        String sql = "INSERT INTO ingresos VALUES('" + id + "', '" + cedula + "', '" + fechaLlegadaFormateada + "', '"
                + fechaSalidaFormateada + "', '" + ciudadOrigen + "', '" + idHabitacion + "')";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Ingresos ingreso = new Ingresos(id, cedula, fechaLlegada, fechaSalida, ciudadOrigen, idHabitacion);

            st.close();

            return gson.toJson(ingreso);

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";

    }

    public String listar() {//boolean ordenar, String orden

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM ingresos";
        /*
        if (ordenar == true) {
            sql += " ORDER BY cedula " + orden;
        }
        */

        List<String> registros = new ArrayList<String>();
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

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

                Ingresos ingreso = new Ingresos(id, cedula, fecha_llegada, fecha_salida, ciudad_origen, id_habitacion);

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
