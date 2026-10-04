package com.example.fleurs.repository;

import com.example.fleurs.model.Fournisseur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends MongoRepository<Fournisseur, String> {
}
