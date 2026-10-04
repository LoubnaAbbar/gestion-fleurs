package com.example.fleurs;

import com.example.fleurs.model.Entretien;
import com.example.fleurs.model.Fleur;
import com.example.fleurs.model.Fournisseur;
import com.example.fleurs.repository.FleurRepository;
import com.example.fleurs.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DonneesDepart implements CommandLineRunner {

    @Autowired
    private FleurRepository fleurRepository;

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Override
    public void run(String... args) {
        if (fleurRepository.count() > 0) {
            return;
        }

        Fournisseur f1 = fournisseurRepository.save(new Fournisseur("Horticulture de Hollande", "Aalsmeer"));
        Fournisseur f2 = fournisseurRepository.save(new Fournisseur("Fleurs du Var", "Hyères"));

        fleurRepository.save(new Fleur("Rose", "rouge", "ETE", 3.5, 120, new Entretien("Tous les jours", "Plein soleil"), f1.getId()));
        fleurRepository.save(new Fleur("Tulipe", "jaune", "PRINTEMPS", 1.8, 200, new Entretien("Tous les 2 jours", "Mi-ombre"), f1.getId()));
        fleurRepository.save(new Fleur("Pivoine", "rose", "PRINTEMPS", 4.9, 60, new Entretien("Tous les 2 jours", "Soleil"), f2.getId()));
        fleurRepository.save(new Fleur("Tournesol", "jaune", "ETE", 2.5, 90, new Entretien("Tous les jours", "Plein soleil"), f2.getId()));
        fleurRepository.save(new Fleur("Lavande", "violet", "ETE", 2.2, 150, new Entretien("1 fois par semaine", "Plein soleil"), f2.getId()));
        fleurRepository.save(new Fleur("Dahlia", "rouge", "AUTOMNE", 3.0, 80, new Entretien("Tous les jours", "Soleil"), f1.getId()));
        fleurRepository.save(new Fleur("Orchidée", "blanc", "HIVER", 12.0, 25, new Entretien("1 fois par semaine", "Lumière indirecte"), f1.getId()));
    }
}
