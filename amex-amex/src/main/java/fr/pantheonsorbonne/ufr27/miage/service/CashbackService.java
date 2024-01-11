package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.model.Cashback;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CashbackService {

    @PersistenceContext(name = "Cashback")
    EntityManager em;

    @Transactional
    public Cashback cashback(Cashback c) {
        em.persist(c);
        return c;
    }
}
