package entities;

import java.util.Objects;

public class Participation {

    private int id_p;
    private String nom_p;
    private String prenom_p;
    private int age;
    private String email;
   // private Utilisateur utilisateur;
    private Evenement event;

    public Participation(String nomP, String prenomP, int age, String email, Evenement e/*, Utilisateur utilisateur*/) {
        this.nom_p = nomP;
        this.prenom_p = prenomP;
        this.age = age;
        this.email = email;
        //this.utilisateur = utilisateur;
        this.event = e;
    }

    public Participation(int id_p, String nom_p, String prenom_p, int age, String email,/*Utilisateur user*/Evenement event) {
        this.id_p = id_p;
        this.nom_p = nom_p;
        this.prenom_p = prenom_p;
        this.age = age;
        this.email = email;
        //this.utilisateur = user;
        this.event = event;
    }

    public int getId_p() {
        return id_p;
    }

    public String getNom_p() {
        return nom_p;
    }

    public String getPrenom_p() {
        return prenom_p;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
  /*  public Utilisateur getUtilisateur() {
        return utilisateur;
    }*/
    public Evenement getEvent() {
        return event;
    }


    public void setNom_p(String nom_p) {
        this.nom_p = nom_p;
    }

    public void setPrenom_p(String prenom_p) {
        this.prenom_p = prenom_p;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   /* public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }*/
    public void setEvent(Evenement event) {
        this.event = event;
    }


    @Override
    public String toString() {
        return "Participation{" +
                "id_p=" + id_p +
                ", nom_p='" + nom_p + '\'' +
                ", prenom_p='" + prenom_p + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
               // ", utilisateur=" + utilisateur +
                ", event=" + event +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participation that = (Participation) o;
        return id_p == that.id_p && age == that.age && Objects.equals(nom_p, that.nom_p) && Objects.equals(prenom_p, that.prenom_p) && Objects.equals(email, that.email) &&/* Objects.equals(utilisateur, that.utilisateur) &&*/ Objects.equals(event, that.event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_p, nom_p, prenom_p, age, email, event);
    }

}





