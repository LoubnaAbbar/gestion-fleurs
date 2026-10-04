package com.example.fleurs.controller;

import com.example.fleurs.model.Fleur;
import com.example.fleurs.model.Fournisseur;
import com.example.fleurs.service.FleurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fleurs")
public class FleurController {

    private final FleurService fleurService;

    @Autowired
    public FleurController(FleurService fleurService) {
        this.fleurService = fleurService;
    }



    @PostMapping
    public Fleur create(@RequestParam String nom,
                        @RequestParam String couleur,
                        @RequestParam String saison,
                        @RequestParam double prix,
                        @RequestParam int stock,
                        @RequestParam String arrosage,
                        @RequestParam String soleil,
                        @RequestParam String fournisseurId) {
        return fleurService.create(nom, couleur, saison, prix, stock, arrosage, soleil, fournisseurId);
    }

    @GetMapping
    public List<Fleur> getAll() {
        return fleurService.getAll();
    }

    @GetMapping("/{id}")
    public Fleur getById(@PathVariable String id) {
        return fleurService.getById(id);
    }

    @PutMapping("/{id}")
    public Fleur update(@PathVariable String id,
                        @RequestParam String nom,
                        @RequestParam String couleur,
                        @RequestParam String saison,
                        @RequestParam double prix,
                        @RequestParam int stock,
                        @RequestParam String arrosage,
                        @RequestParam String soleil,
                        @RequestParam String fournisseurId) {
        return fleurService.update(id, nom, couleur, saison, prix, stock, arrosage, soleil, fournisseurId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        fleurService.delete(id);
    }


    @GetMapping("/couleur")
    public List<Fleur> getByCouleur(@RequestParam String couleur) {
        return fleurService.getByCouleur(couleur);
    }


    @GetMapping("/saison")
    public List<Fleur> getBySaison(@RequestParam String saison) {
        return fleurService.getBySaison(saison);
    }


    @GetMapping("/prix-max")
    public List<Fleur> getPrixInferieurA(@RequestParam double prix) {
        return fleurService.getPrixInferieurA(prix);
    }

    @GetMapping("/recherche")
    public List<Fleur> rechercher(@RequestParam String nom) {
        return fleurService.rechercherParNom(nom);
    }


    @GetMapping("/couleur-prix")
    public List<Fleur> getCouleurEtPrix(@RequestParam String couleur, @RequestParam double prixMax) {
        return fleurService.getCouleurEtPrixMax(couleur, prixMax);
    }

    @GetMapping("/projection")
    public List<Fleur> getNomEtPrix() {
        return fleurService.getNomEtPrix();
    }


    @GetMapping("/{id}/fournisseur")
    public Fournisseur getFournisseur(@PathVariable String id) {
        return fleurService.getFournisseurDeLaFleur(id);
    }
}
