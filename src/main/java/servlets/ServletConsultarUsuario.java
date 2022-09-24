package servlets;

import controller.UsuariosController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ServletConsultarUsuario", urlPatterns = {"/ServletConsultarUsuario"})
public class ServletConsultarUsuario extends HttpServlet {
    
    public ServletConsultarUsuario() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UsuariosController usuario = new UsuariosController();
        
        String cedula = request.getParameter("cedula");

        String strUsuario = usuario.consultarUsuario(cedula);
        response.setContentType("text/html;charset=UTF-8");        
        PrintWriter out = response.getWriter();
        out.println(strUsuario);
        out.flush();
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

}
