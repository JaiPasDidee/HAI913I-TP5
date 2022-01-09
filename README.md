# TP5 - Traçabilité logicielle (HAI913I)

___

<p align="center">
  Réalisé par <strong>LAURET Nicolas</strong> et <strong>PIRES Andréa</strong>
</p>

___

### Installation et utilisation

Clonez le projet et lancez le fichier `TP5/.../log4j/Main.java` pour les questions 1 et 2. Un fichier `commands.log` permet de voir les résultats des tests du logger.

Pour les questions 3 et 4 concernant la génération de code avec Spoon pour la traçabilité, il suffit de lancer le fichier `TP5/.../spoon/Main.java`. Une fois fait, le projet `TP5_Spooned` contiendra l'ensemble des fichiers modifiés permettant le fonctionnement de l'application e-commerce.

Enfin, pour la question 5 il suffit de lancer le fichier `TP5_Spooned/.../ecommerce/Main.java` qui exécutera les différents scénarios automatiquement. Les résultats des logs sont visibles dans les fichiers `reads.log` et `writes.log` (séparés selon les opérations de lecture/écriture). L'extraction des profils depuis les logs est disponible depuis les fichiers `mostReads.json`, `mostWrites.json` et `mostExpensive.json`.

Pour la fluidité et la rapidité d'exécution des scénarios, la CLI a été remplacée par une fonction qui exécute divers scénarios (~60 lectures/écritures sur 5 profils différents).

### Résultats

Pour le stockage des logs, chaque ligne correspond à un message de log contenant la date de l'opération, le type d'opération, l'utilisateur l'ayant effectuée, l'objet sur lequel il l'a effectuée et l'action réalisée.

**Extrait du fichier `writes.log` :**
```
...
[09/01/2022 21:42:05 - WRITE] L'utilisateur { "id": 1, "name": "Georges", "email": "georges97@gmail.com", "age": 75 } a réalisé l'opération add sur le produit { "id": 4, "name": "P4", "expirationDate": "09/01/23", "price": 400 }
[09/01/2022 21:42:05 - WRITE] L'utilisateur { "id": 1, "name": "Georges", "email": "georges97@gmail.com", "age": 75 } a réalisé l'opération add sur le produit { "id": 5, "name": "P5", "expirationDate": "09/01/23", "price": 60 }
...
[09/01/2022 21:42:05 - WRITE] L'utilisateur { "id": 2, "name": "Sandrine", "email": "sand-rine@yahoo.fr", "age": 23 } a réalisé l'opération update sur le produit { "id": 13, "name": "P13u", "expirationDate": "09/01/23", "price": 69 }
[09/01/2022 21:42:05 - WRITE] L'utilisateur { "id": 2, "name": "Sandrine", "email": "sand-rine@yahoo.fr", "age": 23 } a réalisé l'opération delete sur le produit 5
...
```

Pour le stockage des profils, nous avons décidé de dresser un profil en lecture, écriture et recherche de produits chers pour chaque utilisateur sous la forme d'un fichier JSON composé d'une liste de profils utilisateurs.

Chaque profil contient les informations de l'utilisateur ainsi que le nombre d'opérations qu'il a effectué (en lecture ou en écriture) ou le produit le plus cher qu'il a recherché.

De plus, les profils sont ordonnés par ordre décroissant en fonction de la métrique traquée sur le profil afin d'observer plus facilement les utilisateurs avec le plus d'opérations en lecture, en écriture ou les utilisateurs qui recherchent des produits dont le prix est le plus élevé.

**Extrait du fichier `mostExpensive.json` (profil) :**
```json
...
{
   "user":{
      "id":4,
      "name":"Lucas",
      "email":"XxLucasxX@gmail.com",
      "age":17
   },
   "mostExpensiveProduct":{
      "id":9,
      "name":"P9",
      "expirationDate":"09/01/23",
      "price":2499
   }
},
...
```
