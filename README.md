# Projet NoSQL - Gestion de fleurs (Spring Boot & MongoDB)

Mini application de gestion de fleurs et de leurs fournisseurs avec Spring Boot et MongoDB

Le projet inclut une **interface web (front-end)** directement intégrée pour tester facilement toutes les fonctionnalités (ajout, modification, suppression, recherches, statistiques)

## Lancer le projet

### Méthode 1 : Tout dans Docker (le plus simple)

```bash
docker compose up --build
```

L'application et le front-end sont disponibles sur **http://localhost:8080**

### Méthode 2 : Lancement local

1. Préparer les variables d'environnement
```bash
cp .env.example .env
```
 

2. Démarrer la base MongoDB
```bash
docker compose up -d mongo mongo-express
```
 

3. Lancer le serveur Spring Boot :
```bash
./mvnw spring-boot:run
```
 

## Accès

- **Interface web (Front-end)** : http://localhost:8080
- **Interface MongoDB (Mongo Express)** : http://localhost:8081
Des données de démonstration sont ajoutées automatiquement au premier démarrage si la base est vide   
Une collection Postman est également disponible dans le dossier `postman/` 

## Routes principales de l'API

- `GET /fleurs` : Récupérer toutes les fleurs 
- `POST /fleurs` : Ajouter une fleur (via paramètres de requête) 
- `GET /fleurs/{id}` : Récupérer une fleur par son identifiant 
- `PUT /fleurs/{id}` : Modifier une fleur 
- `DELETE /fleurs/{id}` : Supprimer une fleur 
- `GET /fleurs/couleur?couleur=...` : Recherche par couleur 
- `GET /fleurs/saison?saison=...` : Recherche par saison 
- `GET /fleurs/prix-max?prix=...` : Recherche par prix plafond 
- `GET /fleurs/recherche?nom=...` : Recherche par mot-clé dans le nom 
- `GET /fleurs/{id}/fournisseur` : Obtenir le fournisseur lié à la fleur 
- `GET /stats/saisons` : Statistiques agrégées par saison 
- `GET /fournisseurs` : Liste des fournisseurs 
