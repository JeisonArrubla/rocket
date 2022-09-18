package controller;

import java.sql.Statement;
import com.google.gson.Gson;

import beans.Ingresos;
import connection.DBConnection;
import connection.Queries;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IngresosController implements IIngresosController {

    @Override
    public String registrarIngreso(String cedula, Date fechaLlegada, Date fechaSalida, String ciudadOrigen,
            int idHabitacion) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        
        Queries querie = new Queries();
        int id = querie.generarId("id_registro", "ingresos");

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");

        String fechaLlegadaFormateada = sdf.format(fechaLlegada);
        String fechaSalidaFormateada = sdf.format(fechaSalida);

        String sql = "INSERT INTO ingresos VALUES('" + id + "', '" + cedula + "', '" + fechaLlegadaFormateada + "', '" + fechaSalidaFormateada
                + "', '" + ciudadOrigen + "', '" + idHabitacion + "')";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Ingresos ingreso = new Ingresos(cedula, fechaLlegada, fechaSalida, ciudadOrigen, idHabitacion);

            st.close();

            return gson.toJson(ingreso);

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());

        } finally {
            con.desconectar();

            System.out.println(id);
            System.out.println(fechaSalidaFormateada);
        }

        return "false";

    }

}
