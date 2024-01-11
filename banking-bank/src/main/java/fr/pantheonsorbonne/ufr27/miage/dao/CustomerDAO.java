package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.exception.BankCustomerNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.CustomerNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Account;
import fr.pantheonsorbonne.ufr27.miage.model.Customer;

public interface CustomerDAO {
    Customer findMatchingCustomer(String email) throws BankCustomerNotFoundException;

    Customer createNewCustomer(String fname, String lname,String adress,String email);
}
