package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.dto.Genre;
import fr.pantheonsorbonne.ufr27.miage.model.Client;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class ClientDAOImpl implements ClientDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    public Client createClient(int idClient, Genre genre, int age, String profession) {
        Client client = new Client(idClient, genre, age, profession);
        em.persist(client);
        return client;
    }
}