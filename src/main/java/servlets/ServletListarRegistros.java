package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.RegistrosController;

@WebServlet(name = "ServletListarRegistros", urlPatterns = {"/ServletListarRegistros"})
public class ServletListarRegistros extends HttpServlet {
    
    public ServletListarRegistros() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RegistrosController objRegistros = new RegistrosController();
        
        String registros = objRegistros.listarRegistros();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println(registros);
        out.flush();
        out.close();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }
}
