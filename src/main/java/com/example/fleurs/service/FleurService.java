package com.example.fleurs.service;

import com.example.fleurs.model.Entretien;
import com.example.fleurs.model.Fleur;
import com.example.fleurs.model.Fournisseur;
import com.example.fleurs.repository.FleurRepository;
import com.example.fleurs.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FleurService {

    private final FleurRepository fleurRepository;
    private final FournisseurRepository fournisseurRepository;

    @Autowired
    public FleurService(FleurRepository fleurRepository, FournisseurRepository fournisseurRepository) {
        this.fleurRepository = fleurRepository;
        this.fournisseurRepository = fournisseurRepository;
    }

    // ---------- CRUD ----------

    // CREATE (comme dans le cours : on reçoit des paramètres simples et on construit l'objet ici)
    public Fleur create(String nom, String couleur, String saison, double prix, int stock,
                        String arrosage, String soleil, String fournisseurId) {
        if (fleurRepository.existsByNom(nom)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cette fleur existe déjà");
        }
        verifierFournisseur(fournisseurId);
        Fleur fleur = new Fleur(nom, couleur, saison, prix, stock, new Entretien(arrosage, soleil), fournisseurId);
        return fleurRepository.save(fleur);
    }

    // READ (tout)
    public List<Fleur> getAll() {
        return fleurRepository.findAll();
    }

    // READ (un seul)
    public Fleur getById(String id) {
        return fleurRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fleur introuvable"));
    }

    // UPDATE
    public Fleur update(String id, String nom, String couleur, String saison, double prix, int stock,
                        String arrosage, String soleil, String fournisseurId) {
        Fleur fleur = getById(id); // vérifie que la fleur existe
        if (!fleur.getNom().equals(nom) && fleurRepository.existsByNom(nom)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ce nom est déjà utilisé");
        }
        verifierFournisseur(fournisseurId);
        fleur.setNom(nom);
        fleur.setCouleur(couleur);
        fleur.setSaison(saison);
        fleur.setPrix(prix);
        fleur.setStock(stock);
        fleur.setEntretien(new Entretien(arrosage, soleil));
        fleur.setFournisseurId(fournisseurId);
        return fleurRepository.save(fleur); // save() remplace le document qui a cet id
    }

    // DELETE
    public void delete(String id) {
        getById(id);
        fleurRepository.deleteById(id);
    }

    // ---------- Requêtes ----------

    public List<Fleur> getByCouleur(String couleur) {
        return fleurRepository.findByCouleur(couleur);
    }

    public List<Fleur> getBySaison(String saison) {
        return fleurRepository.findBySaison(saison);
    }

    public List<Fleur> getPrixInferieurA(double prix) {
        return fleurRepository.findByPrixLessThan(prix);
    }

    public List<Fleur> rechercherParNom(String texte) {
        return fleurRepository.findByNomContainingIgnoreCase(texte);
    }

    public List<Fleur> getCouleurEtPrixMax(String couleur, double prixMax) {
        return fleurRepository.chercherParCouleurEtPrixMax(couleur, prixMax);
    }

    public List<Fleur> getNomEtPrix() {
        return fleurRepository.findNomEtPrix();
    }

    // Avec le REFERENCING, il faut faire 2 requêtes : la fleur, puis son fournisseur
    public Fournisseur getFournisseurDeLaFleur(String id) {
        Fleur fleur = getById(id);
        return fournisseurRepository.findById(fleur.getFournisseurId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fournisseur introuvable"));
    }

    // Avec MongoDB, il n'y a pas de clé étrangère : c'est à nous de vérifier que le fournisseur existe
    private void verifierFournisseur(String fournisseurId) {
        if (!fournisseurRepository.existsById(fournisseurId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fournisseur inconnu");
        }
    }
}
