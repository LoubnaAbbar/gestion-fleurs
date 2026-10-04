package com.example.fleurs.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fournisseurs")
public class Fournisseur {

    @Id
    private String id;
    private String nom;
    private String ville;

    public Fournisseur() {
    }

    public Fournisseur(String nom, String ville) {
        this.nom = nom;
        this.ville = ville;
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

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
