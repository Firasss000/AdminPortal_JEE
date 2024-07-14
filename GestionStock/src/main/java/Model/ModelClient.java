package Model;

import DAO.DAOClient;
import DAO.DAOClt;
import Entities.Client;

import java.util.List;

public class ModelClient {
    private Client client ;
    private DAOClient service = new DAOClt();

    public void setClient(Client client) {
        this.client = client;
    }
    public void ajouterClt(){
        service.ajouterClient(client);
    }
    public void supprimerClt(int codeClt){
        service.archiverClient(codeClt);
    }
    public void modifierClt(Client clt, int code){
        service.modifierClient(clt, code);
    }
    public List<Client> getClients(){
        return service.getTousClients() ;
    }

}
