package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Client;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class ClientDAOImpl implements ClientDAO{

    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Override
    @Transactional
    public Client createNewClient(String clientFirstName, String clientLastName) {
        Client client = new Client(clientFirstName, clientLastName);
        em.persist(client);
        return client;
    }

    @Override
    @Transactional
    public Client findClient(Integer clientId){
        return (Client) em.createQuery("Select c from Client c where c.id = :clientId ").setParameter("clientId", clientId).getSingleResult();
    }
}
