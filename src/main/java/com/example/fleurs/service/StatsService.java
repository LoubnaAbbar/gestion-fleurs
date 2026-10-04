package com.example.fleurs.service;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsService {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public StatsService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    // AGRÉGATION : pour chaque saison, on calcule le nombre de fleurs, le stock total et le prix moyen
    // Équivalent mongosh :
    // db.fleurs.aggregate([ { $group: { _id: "$saison", nbFleurs: { $sum: 1 },
    //                                   stockTotal: { $sum: "$stock" }, prixMoyen: { $avg: "$prix" } } } ])
    public List<Document> statsParSaison() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("saison")
                        .count().as("nbFleurs")
                        .sum("stock").as("stockTotal")
                        .avg("prix").as("prixMoyen")
        );
        return mongoTemplate.aggregate(aggregation, "fleurs", Document.class).getMappedResults();
    }
}
