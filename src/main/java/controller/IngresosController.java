package controller;

import java.sql.Statement;
import com.google.gson.Gson;

import beans.Ingresos;
import connection.DBConnection;

public class IngresosController implements IIngresosController {

    @Override
    public String registrarIngreso(String cedula, String fechaLlegada, String fechaSalida, String ciudadOrigen,
            int idHabitacion) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "INSERT INTO ingresos VALUES('" + cedula + "', '" + fechaLlegada + "', '" + fechaSalida
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
        }

        return "false";

    }

}
