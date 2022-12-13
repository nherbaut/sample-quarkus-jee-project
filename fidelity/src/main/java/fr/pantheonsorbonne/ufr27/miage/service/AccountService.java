package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.exception.AccountNotFoundException;



public interface AccountService {

    Integer getTotalPoints (Integer client_id) throws AccountNotFoundException, javax.security.auth.login.AccountNotFoundException;

    void addPointsToAccount (Integer client_id) throws AccountNotFoundException, javax.security.auth.login.AccountNotFoundException;

    void useBonusPoints (Integer client_id) throws AccountNotFoundException, javax.security.auth.login.AccountNotFoundException;


}
