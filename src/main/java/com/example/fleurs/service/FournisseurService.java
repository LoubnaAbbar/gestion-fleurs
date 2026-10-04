package com.example.fleurs.service;

import com.example.fleurs.model.Fournisseur;
import com.example.fleurs.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FournisseurService {

    private final FournisseurRepository fournisseurRepository;

    @Autowired
    public FournisseurService(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    public Fournisseur create(String nom, String ville) {
        return fournisseurRepository.save(new Fournisseur(nom, ville));
    }

    public List<Fournisseur> getAll() {
        return fournisseurRepository.findAll();
    }

    public Fournisseur getById(String id) {
        return fournisseurRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fournisseur introuvable"));
    }

    public Fournisseur update(String id, String nom, String ville) {
        Fournisseur fournisseur = getById(id);
        fournisseur.setNom(nom);
        fournisseur.setVille(ville);
        return fournisseurRepository.save(fournisseur);
    }

    public void delete(String id) {
        getById(id);
        fournisseurRepository.deleteById(id);
    }
}
