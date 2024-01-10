package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.model.Client;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ClientService {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public Client client(Client clientRequest) {
        //SI IL Y A DEJA LE CLIENT, CREER LA TRANSACTION, SINON FAIRE LE CLIENT + TRANSACTION
        em.persist(clientRequest);
        System.out.println("Passage");
        return clientRequest;
    }
}
