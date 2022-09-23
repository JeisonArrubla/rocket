package servlets;

import controller.RegistrosController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletIngresarRegistro", urlPatterns = {"/ServletIngresarRegistro"})
public class ServletIngresarRegistro extends HttpServlet {

    public ServletIngresarRegistro() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RegistrosController ingreso = new RegistrosController();

        String cedula = request.getParameter("cedula");
        String fechaLlegada = request.getParameter("fechaLlegada");
        String fechaSalida = request.getParameter("fechaSalida");
        String ciudadOrigen = request.getParameter("ciudadOrigen");
        int idHabitacion = Integer.parseInt(request.getParameter("idHabitacion"));

        String result = ingreso.registrarIngreso(cedula, fechaLlegada, fechaSalida, ciudadOrigen, idHabitacion);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

}
