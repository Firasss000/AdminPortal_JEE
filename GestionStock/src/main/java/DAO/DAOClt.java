package DAO;

import Entities.Client;
import utility.SingletonConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOClt implements DAOClient{
    Connection conx = SingletonConnection.seConnecter() ;

    @Override
    public void ajouterClient(Client client) {
        String query = "INSERT INTO clients(codeClt, nom, prenom, email, password) VALUES (?, ?, ?, ?, ?)";
        try{
            PreparedStatement pst = conx.prepareStatement(query);
            pst.setInt(1, client.getCodeClt());
            pst.setString(2, client.getNom());
            pst.setString(3,client.getPrenom());
            pst.setString(4, client.getEmail());
            pst.setString(5, client.getPassword());

            int n = pst.executeUpdate();
            if(n == 1){
                System.out.println("Client ajouté avec succés");
            }
        }catch(SQLException e){
            System.out.println("Erreu d'ajout du Client : "+e.getMessage());
        }
    }

    @Override
    public void modifierClient(Client client, int codeClt) {
        String query = "UPDATE clients" +
                " SET codeClt = ?, nom = ?, prenom = ? , email = ?, password = ?" +
                "WHERE codeClt = ? ;";
        try{
            PreparedStatement pst = conx.prepareStatement(query);
            pst.setLong(1, client.getCodeClt());
            pst.setString(2, client.getNom());
            pst.setString(3,client.getPrenom());
            pst.setString(4, client.getEmail() );
            pst.setString(5, client.getPassword());
            pst.setInt(6, codeClt );

            int n = pst.executeUpdate();
            if(n == 1){
                System.out.println("Client modifié avec succés");
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void archiverClient(int codeClt) {
        String query = "DELETE FROM clients WHERE codeClt = ?";
        try{
            PreparedStatement pst = conx.prepareStatement(query);
            pst.setInt(1, codeClt);

            int n = pst.executeUpdate();
            if(n == 1){
                System.out.println("Client archivé avec succés");
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public List<Client> getTousClients() {
        List<Client> clients = new ArrayList<>();
        String query = "SELECT * FROM clients";
        try{
            PreparedStatement pst = conx.prepareStatement(query);
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                Client client = new Client(
                        result.getInt("codeClt"),
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getString("email"),
                        result.getString("password")
                );
                clients.add(client);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return clients;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
