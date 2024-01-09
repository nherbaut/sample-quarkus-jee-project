package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.BankAccount;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

@ApplicationScoped

public class BankAccountDAOimpl implements BankAccountDAO {

    @Inject
    EntityManager em;

    @Override
    public List<BankAccount> findAccountsByCustomerId(int customerId) {
        TypedQuery<BankAccount> query = em.createQuery("SELECT a FROM BankAccount a WHERE a.idCustomer = :customerId", BankAccount.class);
        query.setParameter("customerId", customerId);
        return query.getResultList();
    }
}
