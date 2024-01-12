package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.DemandeAuthorisation;
import fr.pantheonsorbonne.ufr27.miage.exception.BankAccountNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.BankCustomerNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Account;

public interface CompteService {
    Account createAccount(String fName,String lName, String adress, String email, String pwd);
    Account findAccount(int idCustomer);
    boolean login(String email, String pwd);
    void login(DemandeAuthorisation demandeAuthorisation) throws BankCustomerNotFoundException, BankAccountNotFoundException;
}
