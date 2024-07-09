package org.example.gestionstock;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
// >> mapping su servlet
//pour acceder on doit preciser le chemin /hello-servlet"
public class helloServlet extends HttpServlet {
    private String message;

    public helloServlet() {
        super() ;
    }

    public void init() {
        message = "Hello World, this is hello servlet !";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");


        PrintWriter out = response.getWriter(); // retourne un objet de type PrintWriter
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public void destroy() {
    }
}