package com.example.fleurs.controller;

import com.example.fleurs.model.Fournisseur;
import com.example.fleurs.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fournisseurs")
public class FournisseurController {

    private final FournisseurService fournisseurService;

    @Autowired
    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @PostMapping
    public Fournisseur create(@RequestParam String nom, @RequestParam String ville) {
        return fournisseurService.create(nom, ville);
    }

    @GetMapping
    public List<Fournisseur> getAll() {
        return fournisseurService.getAll();
    }

    @GetMapping("/{id}")
    public Fournisseur getById(@PathVariable String id) {
        return fournisseurService.getById(id);
    }

    @PutMapping("/{id}")
    public Fournisseur update(@PathVariable String id, @RequestParam String nom, @RequestParam String ville) {
        return fournisseurService.update(id, nom, ville);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        fournisseurService.delete(id);
    }
}
