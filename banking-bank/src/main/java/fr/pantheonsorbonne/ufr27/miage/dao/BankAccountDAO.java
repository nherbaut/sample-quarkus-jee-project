package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.BankAccount;

import java.util.List;

public interface BankAccountDAO {

    List<BankAccount> findAccountsByCustomerId(int customerId);

}
