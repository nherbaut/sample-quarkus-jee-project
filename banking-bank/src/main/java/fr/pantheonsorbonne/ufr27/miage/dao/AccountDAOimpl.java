package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Account;
import fr.pantheonsorbonne.ufr27.miage.model.Vendor;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped

public class AccountDAOimpl implements AccountDAO{

    @Inject
    EntityManager em;
    @Override
    public Account findMatchingAccount(int idCustomer) {

        return em.find(Account.class, idCustomer);

    }
}
