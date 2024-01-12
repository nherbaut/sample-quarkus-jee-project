package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.CustomerDAO;
import fr.pantheonsorbonne.ufr27.miage.exception.BankCustomerNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Customer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CustomerServiceImpl implements CustomerService{
    @Inject
    CustomerDAO customerDAO;
    public Customer findCustomer(String email){
        try{
            Customer c = customerDAO.findMatchingCustomer(email);
            return c;
        }catch(BankCustomerNotFoundException e){
            return null;
        }
    }
}
