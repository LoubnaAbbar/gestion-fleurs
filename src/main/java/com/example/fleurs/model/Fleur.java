package com.example.fleurs.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fleurs")
public class Fleur {

    @Id
    private String id;

    @Indexed(unique = true)
    private String nom;

    private String couleur;
    private String saison;
    private double prix;
    private int stock;


    private Entretien entretien;

    private String fournisseurId;

    public Fleur() {
    }

    public Fleur(String nom, String couleur, String saison, double prix, int stock,
                 Entretien entretien, String fournisseurId) {
        this.nom = nom;
        this.couleur = couleur;
        this.saison = saison;
        this.prix = prix;
        this.stock = stock;
        this.entretien = entretien;
        this.fournisseurId = fournisseurId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getSaison() {
        return saison;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Entretien getEntretien() {
        return entretien;
    }

    public void setEntretien(Entretien entretien) {
        this.entretien = entretien;
    }

    public String getFournisseurId() {
        return fournisseurId;
    }

    public void setFournisseurId(String fournisseurId) {
        this.fournisseurId = fournisseurId;
    }
}
