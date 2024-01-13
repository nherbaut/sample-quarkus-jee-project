package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Transaction;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import fr.pantheonsorbonne.ufr27.miage.model.Client;
import jakarta.persistence.Query;

import java.util.List;

@ApplicationScoped
public class TransactionDAOImpl implements TransactionDAO{

    @PersistenceContext
    EntityManager em;

    @Override
    public Transaction CreateNewTransaction(Integer idClient, double montantTransaction) {
        Transaction t = new Transaction(idClient, montantTransaction);
        em.persist(t);
        return t;
    }

    @Override
    public Transaction FindTransaction(Integer idClient) {
        String jpql = "SELECT t FROM Transaction t WHERE t.idClient = :clientId AND t.transactionStatue = false";

        Query query = em.createQuery(jpql);
        query.setParameter("clientId", idClient);
        query.setMaxResults(1);

        List<Transaction> resultList = query.getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }
}
