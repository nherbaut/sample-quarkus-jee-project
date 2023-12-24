## Objectifs du système à modéliser

Objectifs du système à modéliser
On propose de modéliser un système de compensation pour les retards des trains dans le système de réservation de billets de train.

Politique de Compensation pour les Retards dans le Système de Réservation de Tickets :

1. Éligibilité (G30) :
    - Le système offre une compensation en cas de retard minimal de 30 minutes.
    - Les retards éligibles incluent ceux dus à des grèves, des conditions météorologiques extrêmes et des actes de vandalisme.

2. Compensation (G30) :
    - Le lancement du processus de compensation (G30) est initié par une requête SNCF réseau - G30, qui notifie le retard et sa durée.
    - La demande de compensation par client nécessite une requête G30 - SNCF Connect pour vérifier l'exactitude de la réservation client, y compris le numéro de réservation.
    - Conditions de compensation :
    - Si le retard est de 30 à 59 minutes, la compensation est de 25%.
    - Si le retard est supérieur à 60 minutes, la compensation est de 50%.
    - Une condition de date de remboursement stipule que la demande doit être faite dans les 60 jours suivant la date du retard de train.

3. Vérification du Statut Client (G30 - Fidélité) :
    - Une requête G30 - Fidélité est effectuée pour vérifier le statut du client.
    - Si le statut est "grand voyageur", la compensation est sous forme de bon d'achat avec une validité limitée.
    - Si le statut n'est pas celui de "grand voyageur", le remboursement est effectué par chèque via une requête vers SNCF Bank (pourcentage de compensation + numéro de réservation).

4. Bon d'Achat (Fidélité) :
    - Lorsqu'une requête G30 est reçue, la compensation est généralement fournie sous forme de bon d'achat.
    - Le bon d'achat est nominatif et peut être utilisé pour l'achat de billets ultérieurs dans le système de réservation. Il a une validité limitée.

5. Processus de Réclamation :
    - Les voyageurs doivent fournir des informations spécifiques lors de la demande de compensation, notamment le numéro de réservation, le nom du voyageur, la date du voyage, etc.


## Interfaces

```
!!!! AJOUTER CETTE PARTIE !!!!
```
![](seqDiagram.png)

## Schéma relationnel

![](EER.png)

## Exigences fonctionnelles

* Les voyageurs doivent fournir des informations spécifiques lors de la demande de compensation, y compris le numéro de réservation, le nom du voyageur, la date du voyage, etc.
* G30 doit vérifier si  le train a un retard minimal de 30 min pour bénéficier le remboursement
* G30 doit proposer des compensations différentes selon le temps de retard.
* G30 doit fournir un remboursement différent selon le statut du voyageur.
* SNCF Banque doit envoyer un mail de confirmation au client/voyageur pour confirmer le remboursement.

## Exigences non fonctionnelles

* Les requêtes échangés entres systèmes doivent être fiables et sécurisées et donc utilisent le messaging
* La confirmation  du remboursement et son opération  doivent être fiable
