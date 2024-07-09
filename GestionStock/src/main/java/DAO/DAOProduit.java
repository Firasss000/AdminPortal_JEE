package DAO;

import Entities.Produit;

import java.util.List;

public interface DAOProduit {
    void ajouterProduit(Produit produit);
    void modifierProduit(Produit produit, Long idPord);
    void archiverProduit(Long id);
    Produit getProduit(Long id);
    List<Produit> getTousProduits();
}
