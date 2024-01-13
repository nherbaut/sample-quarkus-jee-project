package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.model.Client;
import fr.pantheonsorbonne.ufr27.miage.model.Transaction;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ClientService {

    @PersistenceContext(name = "Client")
    EntityManager em;

    @PersistenceContext(name = "Transaction")
    EntityManager em2;

    @Transactional
    public Client client(Client clientRequest, double price) {
        Client client = em.find(Client.class, clientRequest.getIdClient());
        if(client!=null){
            Transaction t = new Transaction(clientRequest.getIdClient(), price );
            em2.persist(t);
        }else{
            em.persist(clientRequest);
            Transaction t = new Transaction(clientRequest.getIdClient(), price );
            em2.persist(t);
        }
        return clientRequest;
    }
}
