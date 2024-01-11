package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.model.Account;

public interface CompteService {
    Account createAccount(String fName,String lName, String adress, String email, String pwd);

    boolean login(String email, String pwd);
}
