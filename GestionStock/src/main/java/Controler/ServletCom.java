package Controler;

import Entities.Client;
import Entities.Commande;
import Model.ModelClient;
import Model.ModelCommande;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet ( name = "ServletCom", urlPatterns = {"/listCom","/ajtCom","/suppCom","/modifCom"})

public class ServletCom extends HttpServlet {

    private ModelCommande modelCommande ;

    public ServletCom() {
    }

    @Override
    public void init() throws ServletException {
        modelCommande = new ModelCommande() ;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         
        String path = req.getServletPath();
        
        switch (path){
            case "/listCom":
                listerCom(req,resp) ; 
            break ; 
            case "/ajtCom":
                ajoutCom(req,resp) ; 
                break ; 
            case "/suppCom":
                suppCom(req,resp) ;
                break ; 
            case "/modifCom":
                modifCom(req,resp) ;
                break;
            default:
                break ;
                
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void listerCom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Commande> listCom = modelCommande.getCommandes() ;
        req.setAttribute("listCommandes", listCom) ;
        req.getRequestDispatcher("/Commandes.jsp").forward(req,resp); ;
    }
    public void modifCom(HttpServletRequest req, HttpServletResponse resp) throws IOException {

            String codeComModif = req.getParameter("ancienCode");

            String numCom = req.getParameter("numCom");
            String titre = req.getParameter("titre");
            String dateCommande = req.getParameter("dateCommande");
            String adresse = req.getParameter("adresse");
            String codeClt = req.getParameter("codeClt");


            Commande commande = new Commande(Integer.parseInt(numCom),
                    titre,
                    dateCommande,
                    adresse,
                    Integer.parseInt(codeClt));

            modelCommande.setCommande(commande);
            modelCommande.modifierCommande(commande,Integer.parseInt(codeComModif));

            resp.sendRedirect("./listCom");

        }


    public void suppCom(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String codeCommande = req.getParameter("numCom");

        modelCommande.suppCommande(Integer.parseInt(codeCommande));
        resp.sendRedirect("./listCom");
    }

    public void ajoutCom(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String numCom = req.getParameter("numCom");
        String titre = req.getParameter("titre");
        String dateCommande = req.getParameter("dateCommande");
        String adresse = req.getParameter("adresse");
        String idClient = req.getParameter("codeClt");

        Commande commande = new Commande(Integer.parseInt(numCom),
                titre,
                dateCommande,
                adresse,
                Integer.parseInt(idClient));

        modelCommande.setCommande(commande);
        modelCommande.ajtCommande();

        resp.sendRedirect("./listCom");
    }




}
