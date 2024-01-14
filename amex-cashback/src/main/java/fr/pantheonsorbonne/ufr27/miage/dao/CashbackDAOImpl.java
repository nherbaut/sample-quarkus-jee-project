package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Cashback;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@ApplicationScoped
public class CashbackDAOImpl implements CashbackDAO{

    @PersistenceContext()
    EntityManager em;

    @Override
    public Cashback CreateNewCashback(Integer idClient, double taux, double montant) {
        Cashback c = new Cashback(idClient,taux, montant);
        em.persist(c);
        return c;
    }

    @Override
    public Cashback FindCashback(Integer idCashback) {
        return null;
    }
}
