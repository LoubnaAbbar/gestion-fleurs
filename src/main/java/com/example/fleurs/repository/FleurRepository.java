package com.example.fleurs.repository;

import com.example.fleurs.model.Fleur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FleurRepository extends MongoRepository<Fleur, String> {


    List<Fleur> findByCouleur(String couleur);

    List<Fleur> findBySaison(String saison);

    List<Fleur> findByPrixLessThan(double prix);

    List<Fleur> findByNomContainingIgnoreCase(String texte);

    boolean existsByNom(String nom);


    @Query(value = "{}", fields = "{ 'nom': 1, 'prix': 1 }")
    List<Fleur> findNomEtPrix();


    @Query("{ $and: [ { 'couleur': ?0 }, { 'prix': { $lte: ?1 } } ] }")
    List<Fleur> chercherParCouleurEtPrixMax(String couleur, double prixMax);
}
