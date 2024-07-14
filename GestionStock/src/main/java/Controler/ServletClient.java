package Controler;

import Entities.Client;
import Model.ModelClient;
import Model.ModelProd;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( name = "ServletClt", urlPatterns = {"/listClt","/ajtClt","/suppClt","/modifClt"})

public class ServletClient extends HttpServlet {
    private ModelClient modelClient ;

    public ServletClient() {
    }
    public void init() throws ServletException {
        modelClient = new ModelClient(); //  méthode d'initialisation
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String path = req.getServletPath() ;

         switch (path) {
             case "/listClt" :
                 listerClt(req, resp);
                break ;
             case "/ajtClt" :
                 ajouterClt(req, resp);
                 break;
             case "/suppClt":
                 supprimerClt(req, resp);
                 break;
             case "/modifClt" :
                 modifierClt(req, resp);
                 break;
             default :
                 break;
         }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp) ;
    }
    public void listerClt(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Client> listClt = modelClient.getClients() ;
        req.setAttribute("listClients", listClt);
        req.getRequestDispatcher("/Clients.jsp").forward(req,resp);
    }
    public void ajouterClt(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String code = req.getParameter("codeClt") ;
        String nom = req.getParameter("nom") ;
        String prenom = req.getParameter("prenom") ;
        String email = req.getParameter("email") ;
        String password = req.getParameter("password") ;

        Client client = new Client(Integer.parseInt(code), nom, prenom, email, password) ;
        modelClient.setClient(client);
        modelClient.ajouterClt();

        resp.sendRedirect("./listClt");
    }

    public void supprimerClt(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String codeClt = req.getParameter("codeClt") ;

        modelClient.supprimerClt(Integer.parseInt(codeClt));
        resp.sendRedirect("./listClt");
    }
    public void modifierClt(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String codeCltAModifier = req.getParameter("ancienCode");
        String codeClt = req.getParameter("codeClt");
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String email = req.getParameter("email");
        String password1 = req.getParameter("password");
        String password2 = req.getParameter("password2");

        if (password1.equals(password2)) {
            Client client = new Client(Integer.parseInt(codeClt), nom, prenom, email, password1);
            modelClient.setClient(client);
            modelClient.modifierClt(client, Integer.parseInt(codeCltAModifier)) ;

            resp.sendRedirect("./listClt");
        }else {
            ErrorPassword(password1, password2, req, resp) ;
        }
    }
    public void ErrorPassword(String pw1, String pw2, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!pw1.equals(pw2)) {
             String Err = "Les passwords ne ressemblent pas" ;
            req.setAttribute("ErrorMessage", Err);
            req.getRequestDispatcher("/Clients.jsp").forward(req,resp);
        }
    }


}
