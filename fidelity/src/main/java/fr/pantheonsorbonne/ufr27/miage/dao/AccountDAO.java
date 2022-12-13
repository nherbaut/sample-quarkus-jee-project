package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Account;

import javax.security.auth.login.AccountNotFoundException;

public interface AccountDAO {

    Account findClientAccount(Integer client_id) throws AccountNotFoundException;

    Integer getTotalPoints(Integer client_id) throws AccountNotFoundException;

    void addPointsToAccount (Integer client_id) throws AccountNotFoundException;

    void useBonusPoints (Integer client_id) throws AccountNotFoundException;

}
