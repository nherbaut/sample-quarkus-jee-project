package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Account;

import java.util.List;

public interface AccountDAO {

    List<Account> findAccountsByCustomerId(int customerId);

}
