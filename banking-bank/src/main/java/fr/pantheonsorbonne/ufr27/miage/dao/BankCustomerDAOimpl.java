package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.exception.BankCustomerNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.CustomerNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.BankCustomer;
import fr.pantheonsorbonne.ufr27.miage.model.Customer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped

public class BankCustomerDAOimpl implements BankCustomerDAO{

    @PersistenceContext(name = "mysql")
    EntityManager em;
    @Override
    public BankCustomer findMatchingBankCustomer(String email) throws BankCustomerNotFoundException {
        try {
            BankCustomer c = (BankCustomer) em.createQuery("Select c from BankCustomer c where c.email=:email").setParameter("email", email).getSingleResult();
            return c;
        } catch (NoResultException e) {
            throw new BankCustomerNotFoundException();
        }
    }
}
