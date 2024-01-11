package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.exception.BankCustomerNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.CustomerNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Account;
import fr.pantheonsorbonne.ufr27.miage.model.Customer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CustomerDAOImpl implements CustomerDAO {

    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Override
    @Transactional
    public Customer findMatchingCustomer(String email) throws BankCustomerNotFoundException {
        try {
            Customer c = (Customer) em.createQuery("Select c from Customer c where c.email=:email ")
                    .setParameter("email", email).getSingleResult();
            return c;
        } catch (NoResultException e) {
            throw new BankCustomerNotFoundException();
        }
    }

    @Override
    @Transactional
    public Customer createNewCustomer(String fname, String lname,String adress,String email) {
        Customer c = new Customer(fname,lname,adress,email);
        em.persist(c);
        return c;
    }
}
