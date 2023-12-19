package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Transaction;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import fr.pantheonsorbonne.ufr27.miage.model.Client;

@ApplicationScoped
public class TransactionDAOImpl implements TransactionDAO{

    @PersistenceContext
    EntityManager em;

    @Override
    public Transaction CreateNewTransaction(Client idClient, float montantTransaction) {
        Transaction t = new Transaction(idClient, montantTransaction);
        em.persist(t);
        return t;
    }

    @Override
    public Transaction FindTransaction(Integer idTransaction) {
        return null;//ToDo
    }
}
