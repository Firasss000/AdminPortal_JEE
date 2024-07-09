package Model;

import DAO.DAOProd;
import Entities.Produit;

import java.util.List;

public class ModelProd {
    private Produit produit ;
    private DAOProd service = new DAOProd() ;



    public void setProd(Produit produit) {
        this.produit = produit;
    }

    public void ajouterProd() {
        service.ajouterProduit(produit);
    }

    public void supprimerProd(Long id) {
        service.archiverProduit(id);
    }

    public List<Produit> getProduits() {
        return service.getTousProduits() ;
    }

    public void modifierProd(Produit produit, Long idProd) {
        service.modifierProduit(produit, idProd) ;
    }
}
