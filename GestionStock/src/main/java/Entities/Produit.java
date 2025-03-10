package Entities;

public class Produit {
    private long codeProduit;
    private String libelle;
    private double prixProduit;

    public Produit() {

    }

    @Override
    public String toString() {
        return "Produit{" +
                "codeProduit=" + codeProduit +
                ", libelle='" + libelle + '\'' +
                ", prixProduit=" + prixProduit +
                '}';
    }

    public Produit(long codeProduit, String libelle, double prixProduit) {
        this.codeProduit = codeProduit;
        this.libelle = libelle;
        this.prixProduit = prixProduit;
    }

    // Getters
    public long getCodeProduit() {
        return codeProduit;
    }
    public String getLibelle() {
        return libelle;
    }
    public double getPrixProduit() {
        return prixProduit;
    }

    // setters
    public void setCodeProduit(long codeProduit) {
        this.codeProduit = codeProduit;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public void setPrixProduit(double prixProduit) {
        this.prixProduit = prixProduit;
}


}