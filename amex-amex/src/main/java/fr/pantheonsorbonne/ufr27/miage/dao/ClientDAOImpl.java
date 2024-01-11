package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Client;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class ClientDAOImpl implements ClientDAO{

    @PersistenceContext
    EntityManager em;

    @Override
    public Client CreateNewClient(Integer idClient, String genre, Integer age, String profession) {
        Client c = new Client(idClient,genre,age,profession);
        em.persist(c);
        return c;
    }

    @Override
    public Client FindClient(Integer idClient) {
        return null; //ToDo
    }
}
