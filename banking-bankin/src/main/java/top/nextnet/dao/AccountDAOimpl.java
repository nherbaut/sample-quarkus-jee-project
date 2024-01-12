package top.nextnet.dao;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import top.nextnet.exception.BankinAccountNotFoundException;
import top.nextnet.model.Account;

@ApplicationScoped
public class AccountDAOimpl implements AccountDAO {

    @PersistenceContext(name="mysql")
    EntityManager em;


    @Override
    @Transactional
    public Account findMatchingAccount(int idUser) throws BankinAccountNotFoundException {
        try{
            Account account = (Account) (em.createQuery("Select a from Account a " +
                            " where a.idUser=:idUser")
                    .setParameter("idUser", idUser).getSingleResult());
            return account;
        }catch(NoResultException e){
            throw new BankinAccountNotFoundException();
        }
    }
}
    /*
    @Override
    public List<Account> findAccountsByCustomerId(int customerId) {
        TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a WHERE a.idUser = :customerId", Account.class);
        query.setParameter("customerId", customerId);
        return query.getResultList();
    }
}
    */