package Controler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet ( name = "ServletLogin", urlPatterns = {"/login","/logout"})
public class ServletLogin extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath() ;

        if (path.equals("/login")) {
            login(req, resp);
        }else if (path.equals("/logout")) {

        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId  = req.getParameter("userId");
        String password = req.getParameter("password");

        //Admin logins
        String adminId = "Administrateur";
        String adminPassword = "52586943";

        if (adminId.equals(userId) && adminPassword.equals(password)) {
            HttpSession session = req.getSession() ;
            session.setAttribute("user", "admin");
            resp.sendRedirect("Home.jsp");
        }else{
            req.setAttribute("errorMessage", "Invalid email or password");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
