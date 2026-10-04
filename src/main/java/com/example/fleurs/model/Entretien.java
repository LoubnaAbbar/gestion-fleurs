package com.example.fleurs.model;


public class Entretien {

    private String arrosage;
    private String soleil;

    public Entretien() {
    }

    public Entretien(String arrosage, String soleil) {
        this.arrosage = arrosage;
        this.soleil = soleil;
    }

    public String getArrosage() {
        return arrosage;
    }

    public void setArrosage(String arrosage) {
        this.arrosage = arrosage;
    }

    public String getSoleil() {
        return soleil;
    }

    public void setSoleil(String soleil) {
        this.soleil = soleil;
    }
}
