package fr.pantheonsorbonne.ufr27.miage.dao;


import fr.pantheonsorbonne.ufr27.miage.model.Transaction;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

@ApplicationScoped

public class TransactionDAOimpl implements TransactionDAO{

    @Inject
    private EntityManager em;


    @Override
    public Transaction findTransactionsByAccountId(int id_transaction) {
        try {
            Transaction c = (Transaction) em.createQuery("Select c from Transaction c where c.idTransaction=:id_transaction").setParameter("id_transaction", id_transaction).getSingleResult();
            return c;
        } catch (Exception e) {
            return null;
        }
    }
}
