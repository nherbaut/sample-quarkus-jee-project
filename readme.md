# Acteurs
Tom Nook, le maire
Les habitants
Les commerçants
Les fournisseurs (?)

# Objectifs du système à modéliser

On propose de modéliser un système de gestion de village permettant à ses habitants de communiquer directement avec le maire (Tom Nook) afin d’effectuer des achats pour améliorer leur habitat. 

Chaque personne doit obtenir l’approbation de Tom Nook pour devenir habitant et faire construire sa maison dans le village. Une personne peut se voir refuser la demande de devenir habitant si le village est trop petit. En effet, le village a un nombre maximum de maisons. Lorsque ce maximum est atteint, les habitants doivent payer une somme pour permettre d’agrandir le village.

Une fois installé, les habitants peuvent acheter des objets chez les commerçants afin d'emménager. Les commerçants interagissent directement avec les fournisseurs et doivent vérifier à chaque vente, si le stock est suffisant. Dans le cas contraire, ils passent commande chez les fournisseurs qui se chargent de leur donner du stock. 

Il y a une limite maximum d’objet dans une maison. Lorsque celle-ci est atteinte, un habitant doit demander l’autorisation à Tom Nook d’agrandir sa maison, ce qui permettra d’augmenter la limite maximum de celle-ci. 

Le projet inclus :

Service de gestion des villageois
Service de gestion des logements
Service de gestion des stocks
Service de gestion d’inventaires
Service de gestion des comptes
Service de gestion des prêts

Exigences fonctionnelles :

VILLAGEOIS 
Un villageois possède un logement
Un villageois peut upgrade son logement
Un villageois possède un compte bancaire
Un villageois peut consulter son solde
Un villageois peut effectuer un prêt (jusqu’à 3)
Un villageois peut acheter des objets de décorations 
Un villageois peut consulter la liste de ses objets

COMMERÇANTS 
Un commerçant peut vendre des objets de décorations
Un commerçant peut recharger son stock
Un commerçant peut consulter son stock

TOM NOOK
Tom Nook peut accorder un prêt
Tom Nook peut valider l’upgrade d’une maison
Tom Nook peut agrandir le village 
Tom Nook peut ajouter un nouveau villageois
Tom Nook peut expulser un villageois
Tom Nook peut consulter la liste des villageois

LOGEMENT
Un logement peut être une tente, un appartement ou une maison
Un logement possède un nombre maximum d’objet
Un logement possède un prix
Un logement ne peut pas être mis à niveau s’il ne contient pas le maximum d’objet

Règles métier :

Un villageois ne peut pas upgrade son logement si celui-ci ne possède pas le nombre d’objet maximum
Un villageois ne peut avoir qu’un seul logement
Le logement par défaut d’un habitant est une tente
Lorsque le villageois effectue plus de 3 prêts il est expulsé du village 
Un villageois ne peut plus acheter d’objets si son logement atteint le maximum d’objet autorisé 

![](2022-11-10-14-18-30.png)

![](2022-11-10-14-18-51.png)

![](2022-11-10-14-19-05.png)

![](2022-11-10-14-19-28.png)