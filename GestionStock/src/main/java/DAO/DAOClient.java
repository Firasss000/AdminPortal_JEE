package DAO;

import Entities.Client;

import java.util.List;

public interface DAOClient {
    void ajouterClient(Client client) ;
    void modifierClient(Client client, int codeClt) ;
    void archiverClient(int codeClt) ;
    List<Client> getTousClients() ;


}
