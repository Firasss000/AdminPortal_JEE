package DAO;

import Entities.Produit;
import utility.SingletonConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOProd implements DAOProduit{
    Connection conx = SingletonConnection.seConnecter();

    @Override
    public void ajouterProduit(Produit produit) {
        String query = "INSERT INTO produit(code, libelle, prix) VALUES (?, ?, ?)";
        try{
            PreparedStatement pst = conx.prepareStatement(query);
            pst.setLong(1, produit.getCodeProduit());
            pst.setString(2, produit.getLibelle());
            pst.setDouble(3,produit.getPrixProduit());
            int n = pst.executeUpdate();
            if(n == 1){
                System.out.println("Produit ajouté avec succés");
            }
        }catch(SQLException e){
            System.out.println("Erreu d'ajout du produit : "+e.getMessage());
        }
    }

    @Override
    public void modifierProduit(Produit produit, Long idProd) {
        String query = "UPDATE produit" +
                " SET code = ?, libelle = ?, prix = ? " +
                "WHERE code = ? ;";
        try{
            PreparedStatement pst = conx.prepareStatement(query);
            pst.setLong(1, produit.getCodeProduit());
            pst.setString(2, produit.getLibelle());
            pst.setDouble(3,produit.getPrixProduit());
            pst.setLong(4, idProd);
            int n = pst.executeUpdate();
            if(n == 1){
                System.out.println("Produit modifié avec succés");
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void archiverProduit(Long id) {
        String query = "DELETE FROM produit WHERE code = ?";
        try{
            PreparedStatement pst = conx.prepareStatement(query);
            pst.setLong(1, id);

            int n = pst.executeUpdate();
            if(n == 1){
                System.out.println("Produit archivé avec succés");
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Produit getProduit(Long id) {
        Produit produit = new Produit();
        String query = "SELECT * FROM produit WHERE code = ?";
        try{
            PreparedStatement pst = conx.prepareStatement(query);
            pst.setLong(1, id);

            ResultSet result = pst.executeQuery();
            if(result.next()){
                produit.setCodeProduit(result.getLong("code"));
                produit.setLibelle(result.getString("libelle"));
                produit.setPrixProduit(result.getDouble("prix"));
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return produit;
    }

    @Override
    public List<Produit> getTousProduits() {
        List<Produit> produits = new ArrayList<>();
        String query = "SELECT * FROM produit";
        try{
            PreparedStatement pst = conx.prepareStatement(query);
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                Produit produit = new Produit(
                        result.getLong("code"),
                        result.getString("libelle"),
                        result.getDouble("prix")
                );
                produits.add(produit);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return produits;
    }


}