package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Cashback;
import fr.pantheonsorbonne.ufr27.miage.model.Client;
import fr.pantheonsorbonne.ufr27.miage.model.Transaction;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class CashbackDAOImpl implements CashbackDAO{

    @PersistenceContext
    EntityManager em;

    @Override
    public Cashback CreateNewCashback(Client idClient, Transaction idTransaction, float tauxCashback) {
        Cashback c = new Cashback(idClient,idTransaction,tauxCashback);
        em.persist(c);
        return c;
    }

    @Override
    public Cashback FindCashback(Integer idCashback) {
        return null;//ToDo
    }
}
