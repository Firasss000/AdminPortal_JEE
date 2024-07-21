package DAO;

import Entities.Commande;

import java.util.List;

public interface DAOCommande {
    void ajouterCommande(Commande commande);
    void archiverCommande(int idCom);
    void modifierCommande(Commande commande, int idCom);
    List<Commande> listerCommande();

}
