package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Account;
import fr.pantheonsorbonne.ufr27.miage.model.Vendor;
import fr.pantheonsorbonne.ufr27.miage.model.Venue;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Collection;
import java.util.List;

@ApplicationScoped

public class AccountDAOimpl implements AccountDAO{

    @Inject
    EntityManager em;

    @Override
    public List<Account> findAccountsByCustomerId(int customerId) {
        TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a WHERE a.idCustomer = :customerId", Account.class);
        query.setParameter("customerId", customerId);
        return query.getResultList();
    }
}
