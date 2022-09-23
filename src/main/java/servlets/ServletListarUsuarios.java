package servlets;

import controller.UsuariosController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletListarUsuarios", urlPatterns = {"/ServletListarUsuarios"})
public class ServletListarUsuarios extends HttpServlet {
    
    public ServletListarUsuarios() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UsuariosController objUsuarios = new UsuariosController();
        
        String usuarios = objUsuarios.listarUsuarios();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println(usuarios);
        out.flush();
        out.close();

    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }
}
