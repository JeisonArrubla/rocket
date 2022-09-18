package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.IngresosController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet implementation class ServletUsuarioRegister
 */
@WebServlet("/ServletRegistrarIngreso")
public class ServletRegistrarIngreso extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistrarIngreso() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        IngresosController ingreso = new IngresosController();
        
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");

        String cedula = request.getParameter("cedula");
        Date fechaLlegada = new Date();
        try {
            fechaLlegada = sdf.parse(request.getParameter("fechaLlegada"));
        } catch (ParseException ex) {
            Logger.getLogger(ServletRegistrarIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date fechaSalida = new Date();
        try {
            fechaSalida = sdf.parse(request.getParameter("fechaSalida"));
        } catch (ParseException ex) {
            Logger.getLogger(ServletRegistrarIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
        String ciudadOrigen = request.getParameter("ciudadOrigen");
        int idHabitacion = Integer.parseInt(request.getParameter("idHabitacion"));

        String result = ingreso.registrarIngreso(cedula, fechaLlegada, fechaSalida, ciudadOrigen, idHabitacion);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
