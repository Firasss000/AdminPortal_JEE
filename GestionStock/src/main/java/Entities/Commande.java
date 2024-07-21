package Entities;

public class Commande {
    private int numCom;
    private String titre;
    private String dateCom;
    private String adresse ;
    private int idClt ;

    public Commande(int numCom, String titre, String dateCom, String adresse, int idClt) {
        this.numCom = numCom;
        this.titre = titre;
        this.dateCom = dateCom;
        this.adresse = adresse;
        this.idClt = idClt;
           }

    @Override
    public String toString() {
        return "Commande{" +
                "numCom=" + numCom +
                ", titre='" + titre + '\'' +
                ", dateCom='" + dateCom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", idClt=" + idClt +
                '}';
    }

    public Commande() {

    }

    public void setNumCom(int numCom) {
        this.numCom = numCom;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDateCom(String dateCom) {
        this.dateCom = dateCom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setIdClt(int idClt) {
        this.idClt = idClt;
    }


    public int getNumCom() {
        return numCom;
    }

    public String getTitre() {
        return titre;
    }

    public String getDateCom() {
        return dateCom;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getIdClt() {
        return idClt;
    }

}
