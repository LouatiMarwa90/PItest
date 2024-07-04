package entities;

import java.util.Date;
import java.util.Objects;

public class Evenement {
    private int IdEv;
    private Date DateD;
    private Date DateF;
    private int nbMax;
    private String Lieux;
    private Type type;
    private String image_eve;

    public Evenement(int idEv, Date DateD, int nbMax, String lieux, Type type, String image_eve) {
        IdEv = idEv;
        DateD = DateD;
        DateF = DateF;
        this.nbMax = nbMax;
        Lieux = lieux;
        this.type = type;
        this.image_eve = image_eve;
    }



    public Evenement(int idEv, Date DateD, int nbMax, String lieux, Type type) {
        IdEv = idEv;
        DateD = DateD;
        DateF = DateF;
        this.nbMax = nbMax;
        Lieux = lieux;
        this.type = type;

    }

    public Evenement( Date DateD, int nbMax, String lieux, Type type) {

        DateD = DateD;
        DateF = DateF;
        this.nbMax = nbMax;
        Lieux = lieux;
        this.type = type;

    }


    public Evenement() {
        DateD = DateD;
        DateF = DateF;
        this.nbMax = nbMax;
        Lieux = Lieux;
        this.type = type;
        this.image_eve = image_eve;
    }


    public int getIdEv() {
        return IdEv;
    }

    public void setIdEv(int idEv) {
        IdEv = idEv;
    }

    public Date getDateD() {
        return DateD;
    }
    public Date getDateF() {
        return DateF;
    }
    public void setDateD(Date dateD) {
        DateD = dateD;
    }

    public void setDateF(Date dateF) {
        DateF = dateF;
    }

    public int getNbMax() {
        return nbMax;
    }

    public void setNbMax(int nbMax) {
        this.nbMax = nbMax;
    }

    public String getLieux() {
        return Lieux;
    }

    public void setLieux(String lieux) {
        Lieux = lieux;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getImage_eve() {
        return image_eve;
    }

    public void setImage_eve(String image_eve) {
        this.image_eve = image_eve;
    }

    @Override
    public String toString() {
        return "Evenement{" +
                "IdEv=" + IdEv +
                ", DateD=" + DateD +
                ", DateF=" + DateF +
                ", nbMax=" + nbMax +
                ", Lieux='" + Lieux + '\'' +
                ", type=" + type +
                ", image_eve='" + image_eve + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evenement evenement = (Evenement) o;
        return IdEv == evenement.IdEv && nbMax == evenement.nbMax && Objects.equals(DateD, evenement.DateD) && Objects.equals(DateF, evenement.DateF) && Objects.equals(Lieux, evenement.Lieux) && type == evenement.type && Objects.equals(image_eve, evenement.image_eve);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IdEv, DateD, DateF, nbMax, Lieux, type, image_eve);
    }
}



