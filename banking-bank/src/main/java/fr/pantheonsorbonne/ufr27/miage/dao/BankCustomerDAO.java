package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.exception.BankCustomerNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.BankCustomer;

public interface BankCustomerDAO {

    BankCustomer findMatchingBankCustomer(String email) throws BankCustomerNotFoundException;

}
