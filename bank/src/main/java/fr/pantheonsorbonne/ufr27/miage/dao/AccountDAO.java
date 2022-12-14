package fr.pantheonsorbonne.ufr27.miage.dao;


import fr.pantheonsorbonne.ufr27.miage.exception.ClientNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Account;

public interface AccountDAO {

    Account findClientAccount(Integer clientId) throws ClientNotFoundException;

    int updateClientAccountSold(Integer clientId, Float newSold) throws ClientNotFoundException;
}