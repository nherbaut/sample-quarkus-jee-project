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
    public List<Transaction> findTransactionsByAccountId(int id_transaction) {
        TypedQuery<Transaction> query = em.createQuery(
                "SELECT t FROM Transaction t WHERE t.idTransaction = :id_transaction", Transaction.class);
        query.setParameter("id_transaction", id_transaction);
        return query.getResultList();    }
}
