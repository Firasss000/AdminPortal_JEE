package DAO;

import Entities.Commande;
import utility.SingletonConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOCom implements DAOCommande{
    Connection con = SingletonConnection.seConnecter() ;

    public DAOCom() {
    }

    @Override
    public void ajouterCommande(Commande commande) {
        String query = "INSERT INTO commandes VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, commande.getIdClt());
            ps.setString(2, commande.getTitre());
            ps.setString(3, commande.getDateCom());
            ps.setString(4, commande.getAdresse());
            ps.setInt(5,commande.getIdClt());

            if (ps.executeUpdate() > 0) {
                System.out.println("Commande ajouté avec succès");
            }
        } catch (SQLException e) {
            System.out.println("Erreur ajouterCommande: "+e.getMessage());
        }
    }

    @Override
    public void archiverCommande(int idCom) {
        String query = "DELETE FROM commandes WHERE numCom = ?";
        try{
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, idCom);

            int n = pst.executeUpdate();
            if(n == 1){
                System.out.println("Commande archivé avec succés");
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void modifierCommande(Commande commande, int idCom) {
        String query = "UPDATE commandes" +
                " SET numCom = ?, titre = ?, date_commande = ? , adresse = ?, id_client = ? " +
                "WHERE numCom = ? ;";
        try{
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, commande.getNumCom());
            pst.setString(2, commande.getTitre());
            pst.setString(3,commande.getDateCom());
            pst.setString(4,commande.getAdresse());
            pst.setInt(5,commande.getIdClt());

            pst.setInt(6, idCom);

            if(pst.executeUpdate() > 0 ){
                System.out.println("Commande modifié avec succés");
            }else {
                System.out.println("erreur");
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public List<Commande> listerCommande() {
        List<Commande> commandes = new ArrayList<Commande>();

        String query = "SELECT * FROM commandes";

        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                Commande commande = new Commande(
                        rs.getInt("numCom"),
                        rs.getString("titre"),
                        rs.getString("date_commande"),
                        rs.getString("adresse"),
                        rs.getInt("id_client")
                );
                commandes.add(commande) ;
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return commandes;
    }
}
