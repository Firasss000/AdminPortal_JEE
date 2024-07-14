import DAO.DAOClt;
import DAO.DAOProd;
import DAO.DAOProduit;
import Entities.Client;
import Entities.Produit;
import Model.ModelClient;
import Model.ModelProd;

public class Test {
    public static void main(String[] args) {
//          Produit p = new Produit(1548975388, "PRODUIT 1", 35.50);
//        //Produit p2 = new Produit(15489915, "produit 2", 15.75);
//
//        DAOProd daoProduit = new DAOProd() ;
//        ModelProd modelProd = new ModelProd() ;

//        daoProduit.ajouterProduit(p1);
//        daoProduit.ajouterProduit(p2);
//        System.out.println(modelProd.getProduits()) ;
//        System.out.println(daoProduit.getProduit(15489753L));
        //daoProduit.archiverProduit(15489753L) ;
        //daoProduit.modifierProduit(p1, 15489915L);
//        daoProduit.archiverProduit(15489753L);

//        modelProd.modifierProd(p,15489753L);

        //DAOClt daoClt = new DAOClt() ;
        ModelClient modelClient = new ModelClient() ;

        Client client = new Client(01,"Malek","Takrouni","mt@tm","******") ;
//        modelClient.setClient(client);
//        modelClient.ajouterClt(client);
//        modelClient.supprimerClt(2);
//        modelClient.modifierClt(client, 1);
       // System.out.println(modelClient.getClients());
//        System.out.println(modelClient.getClients() );

       // daoClt.modifierClient(client, 01);
       // daoClt.ajouterClient(client);
       // System.out.println(daoClt.getTousClients()) ;
      //  daoClt.archiverClient(2);

    }
}
