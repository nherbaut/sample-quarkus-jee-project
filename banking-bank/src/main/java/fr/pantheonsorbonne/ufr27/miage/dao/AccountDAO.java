package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Account;

public interface AccountDAO {
    Account findMatchingAccount(int idCustomer) ;
}
