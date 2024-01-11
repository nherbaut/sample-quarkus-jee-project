package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.exception.BankAccountNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Account;
import jakarta.persistence.EntityManager;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AccountDAOImpl implements AccountDAO{
    @PersistenceContext(name="mysql")
    EntityManager em;

    @Override
    @Transactional
    public Account findMatchingAccount(int idCustomer) throws BankAccountNotFoundException {
        try{
            Account account = (Account) (em.createQuery("Select a from Account a " +
                                                        " where a.idCustomer=:idCustomer")
                    .setParameter("idCustomer", idCustomer).getSingleResult());
            return account;
        }catch(NoResultException e){
            throw new BankAccountNotFoundException();
        }
    }
    @Override
    @Transactional
    public Account createAccount(String pwd, float solde, int idCustomer){
        Account account = new Account(pwd,solde,idCustomer);
        em.persist(account);
        return account;
    }
}
