    package connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Queries {

    public int generarId(String columna, String tabla) {

        int id = 1;

        DBConnection conn = new DBConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            ps = conn.getConnection().prepareStatement("SELECT MAX(" + columna + ") FROM " + tabla );
            rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1) + 1;
            }
        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        } finally {

            try {

                ps.close();
                rs.close();
                conn.desconectar();
            } catch (Exception e) {
            }
        }

        return id;
    }
}
