package Entities;

public class Client {
    private int codeClt ;
    private  String nom ;
    private  String prenom ;
    private  String email ;
    private String password ;

    public Client(int codeClt, String nom, String prenom, String email, String password) {
        this.codeClt = codeClt;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "codeClt=" + codeClt +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setCodeClt(int codeClt) {
        this.codeClt = codeClt;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCodeClt() {
        return codeClt;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
