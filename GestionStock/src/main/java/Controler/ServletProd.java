package Controler;

import Entities.Produit;
import Model.ModelProd;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletProd", urlPatterns = {"/ajtProd","/suppProd","/modifProd","/listProd"})
// >> mapping su servlet
//pour acceder on doit preciser le chemin /hello-servlet"
public class ServletProd extends HttpServlet {
    private ModelProd modelProd ; // pour l enregistrement des donnés reçus par le client


    public ServletProd() {
    }
    @Override
    public void init() throws ServletException {
        modelProd = new ModelProd(); //  méthode d'initialisation
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getServletPath() ; // retourne la valeur de l'attribut action du form envoyé <form action ="" >

        switch(path) {
            case "/listProd":
                listerProd(req,resp);
                break;
            case "/ajtProd":
                ajouterProduit(req,resp);
                break;
            case "/suppProd":
                suppProd(req,resp);
                break;
            case "/modifProd":
                modifProd(req, resp);
            default:
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void listerProd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Produit> list = modelProd.getProduits() ;
        req.setAttribute("listProduits",list); // pour faire le binding des donnés ( list / JSP )
        req.getRequestDispatcher("Produits.jsp").forward(req,resp); // configurer la target page pour le binding
    }
    public void ajouterProduit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String code = req.getParameter("code");
        String libelle = req.getParameter("libelle");
        String prix = req.getParameter("prix");
        Produit produit = new Produit(Long.parseLong(code),libelle,Double.parseDouble(prix)) ;

        modelProd.setProd(produit) ;
        modelProd.ajouterProd();

        resp.sendRedirect("./listProd");
    }

    public void suppProd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String code = req.getParameter("code");

        modelProd.supprimerProd(Long.parseLong(code));
        resp.sendRedirect("./listProd");
    }

    public void modifProd(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String ancienCode = req.getParameter("ancienCode") ;
        String code = req.getParameter("code");
        String libelle = req.getParameter("libelle");
        String prix = req.getParameter("prix");

        Produit produit = new Produit(Long.parseLong(code),libelle,Double.parseDouble(prix)) ;

        modelProd.setProd(produit);
        modelProd.modifierProd(produit, Long.parseLong(ancienCode) );

        resp.sendRedirect("./listProd");
    }
}
