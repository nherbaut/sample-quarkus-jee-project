package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.exception.BankAccountNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.BankCustomerNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Account;

public interface AccountDAO {
    Account findMatchingAccount(int idCustomer) throws BankAccountNotFoundException;

    Account createAccount(String pwd, float solde, int idCustomer);
}
