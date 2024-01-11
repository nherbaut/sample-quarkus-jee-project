package fr.pantheonsorbonne.ufr27.miage.service;

import com.google.common.hash.Hashing;
import fr.pantheonsorbonne.ufr27.miage.dao.AccountDAO;
import fr.pantheonsorbonne.ufr27.miage.dao.CustomerDAO;
import fr.pantheonsorbonne.ufr27.miage.exception.BankAccountNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.BankCustomerNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.CustomerNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Account;
import fr.pantheonsorbonne.ufr27.miage.model.Customer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import io.quarkus.elytron.security.common.BcryptUtil;


@ApplicationScoped
public class CompteServiceImpl implements CompteService{
    @Inject
    AccountDAO accountDAO;

    @Inject
    CustomerDAO customerDAO;

    @Override
    @Transactional
    public Account createAccount(String fName,String lName, String address, String email, String pwd){

        Customer customer = customerDAO.createNewCustomer(fName,lName,address,email);
        Account  account = accountDAO.createAccount(BcryptUtil.bcryptHash(pwd),0,customer.getIdCustomer());

        return account;
    }
    @Override
    @Transactional
    public boolean login(String email, String pwd){
        try{
            Customer customer = customerDAO.findMatchingCustomer(email);
            Account account = accountDAO.findMatchingAccount(customer.getIdCustomer());
            if(this.checkPassword(account.getPassword(),pwd)){
                return true;
            }
            return false;
        } catch (BankCustomerNotFoundException | BankAccountNotFoundException e ) {
            return false;
        }
    }
    public boolean checkPassword(String passwordHash, String password){
        return BcryptUtil.matches(password,passwordHash);
    }

}
