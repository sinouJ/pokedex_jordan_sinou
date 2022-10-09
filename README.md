# pokedex_jordan_sinou

Cette app Android est un pokedex permettant de consulter les infos des pokemons de toutes les générations. 
Les données proviennent de l'API [pokeapi](pokeapi.co)

## Stack technique
---
- API externe : [pokeapi.co](pokeapi.co)
- Android jetpack compose
- UI Material design
- API Android = 33 (Tiramisu)
- Kotlin

## Pages
---

### Nom du dresseur
Input permettant de renseigner son nom à l'application

### Home
Page home affichant le nom renseigné précedemment

### Recherche
Page affichant la totalité des pokemon ainsi que leur ID
Input permettant de rechercher un pokemon via son ID afin de voir les détails le concernant

### Pokemon
Bouton de retour permettant de revenir à la liste
Détails du pokemon et représentation : 
- Nom
- Numéro
- Taille et poids
- Types
- Stats

## Organisation
---
- Services permettant de gérer la gestion des données au sein de l'app
- Chaque package est organisé en 2 parties : view et viewModel
  - la partie view contient plutôt la partie UI
  - la partie viewModel contient la logique du code et ce qui concerne la récupération de données
- Un fichier Theme qui va centraliser tous les éléments graphiques de l'application
- Des models permettant d'organiser les données récupérées par l'API externe


## Bugs
---
~~Cliquer sur Home dans la navbar provoque le crash de l'app dû à la route dynamique permettant d'afficher le nom du dresseur~~ (Corrigé)
