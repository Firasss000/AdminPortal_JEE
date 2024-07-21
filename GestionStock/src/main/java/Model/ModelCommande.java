package Model;

import DAO.DAOCom;
import DAO.DAOCommande;
import Entities.Commande;

import java.util.List;

public class ModelCommande {

    private Commande commande = new Commande();
    private DAOCom service ;

    public ModelCommande() {
        this.service = new DAOCom();
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public void ajtCommande() {
        service.ajouterCommande(commande);
    }
    public void suppCommande(int idCom){
        service.archiverCommande(idCom);
    }
    public List<Commande> getCommandes() {
        return service.listerCommande() ;
    }
    public void modifierCommande(Commande commande, int idCom) {
        service.modifierCommande(commande,idCom);
    }
}
