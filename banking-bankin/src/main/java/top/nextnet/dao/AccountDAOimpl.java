package top.nextnet.dao;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import top.nextnet.model.Account;

import java.util.List;

@ApplicationScoped

public class AccountDAOimpl implements AccountDAO {

    @Inject
    EntityManager em;

    @Override
    public List<Account> findAccountsByCustomerId(int customerId) {
        TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a WHERE a.idUser = :customerId", Account.class);
        query.setParameter("customerId", customerId);
        return query.getResultList();
    }
}
