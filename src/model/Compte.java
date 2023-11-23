package model;

public class Compte {
    private int idc;
    private float solde;
    private String nomCl;

    public Compte(int i, String nom) {
    }

    public Compte(int idc, float solde, String nomCl) {
        this.idc = idc;
        this.solde = solde;
        this.nomCl = nomCl;
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public String getNomCl() {
        return nomCl;
    }

    public void setNomCl(String nomCl) {
        this.nomCl = nomCl;
    }
}
