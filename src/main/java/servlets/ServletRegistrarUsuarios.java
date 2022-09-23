package servlets;

import controller.UsuariosController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletRegistrarUsuarios", urlPatterns = {"/ServletRegistrarUsuarios"})
public class ServletRegistrarUsuarios extends HttpServlet {

    public ServletRegistrarUsuarios() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UsuariosController usuario = new UsuariosController();

        String cedula = request.getParameter("cedula");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String nacionalidad = request.getParameter("nacionalidad");

        String result = usuario.registrarUsuario(cedula, nombre, apellido, email, telefono, nacionalidad);

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
