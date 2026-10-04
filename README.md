# Projet NoSQL - Gestion de fleurs (Spring Boot & MongoDB)

Mini application de gestion de fleurs et de leurs fournisseurs avec Spring Boot et MongoDB[cite: 10].

Le projet inclut une **interface web (front-end)** directement intégrée pour tester facilement toutes les fonctionnalités (ajout, modification, suppression, recherches, statistiques)[cite: 10].

## Lancer le projet

### Méthode 1 : Tout dans Docker (le plus simple)

```bash
docker compose up --build
```
[cite: 10]

L'application et le front-end sont disponibles sur **http://localhost:8080**[cite: 5, 10].

### Méthode 2 : Lancement local

1. Préparer les variables d'environnement[cite: 10] :
```bash
cp .env.example .env
```
[cite: 10]

2. Démarrer la base MongoDB[cite: 10] :
```bash
docker compose up -d mongo mongo-express
```
[cite: 10]

3. Lancer le serveur Spring Boot[cite: 10] :
```bash
./mvnw spring-boot:run
```
[cite: 10]

## Accès

- **Interface web (Front-end)** : http://localhost:8080[cite: 5, 10]
- **Interface MongoDB (Mongo Express)** : http://localhost:8081[cite: 5, 10]

Des données de démonstration sont ajoutées automatiquement au premier démarrage si la base est vide[cite: 10].  
Une collection Postman est également disponible dans le dossier `postman/`[cite: 10].

## Routes principales de l'API

- `GET /fleurs` : Récupérer toutes les fleurs[cite: 10]
- `POST /fleurs` : Ajouter une fleur (via paramètres de requête)[cite: 10]
- `GET /fleurs/{id}` : Récupérer une fleur par son identifiant[cite: 10]
- `PUT /fleurs/{id}` : Modifier une fleur[cite: 10]
- `DELETE /fleurs/{id}` : Supprimer une fleur[cite: 10]
- `GET /fleurs/couleur?couleur=...` : Recherche par couleur[cite: 10]
- `GET /fleurs/saison?saison=...` : Recherche par saison[cite: 10]
- `GET /fleurs/prix-max?prix=...` : Recherche par prix plafond[cite: 10]
- `GET /fleurs/recherche?nom=...` : Recherche par mot-clé dans le nom[cite: 10]
- `GET /fleurs/{id}/fournisseur` : Obtenir le fournisseur lié à la fleur[cite: 10]
- `GET /stats/saisons` : Statistiques agrégées par saison[cite: 10]
- `GET /fournisseurs` : Liste des fournisseurs[cite: 10]