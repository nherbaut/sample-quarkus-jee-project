package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Account;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.security.auth.login.AccountNotFoundException;
import javax.transaction.Transactional;

@ApplicationScoped
public class AccountDAOImpl implements AccountDAO{


    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Override
    @Transactional
    public Account findClientAccount(Integer clientId) throws AccountNotFoundException {
        try {
            return (Account) em.createQuery("SELECT a from Account a where a.id =: clientId").setParameter("clientId", clientId).getSingleResult();
        } catch (NoResultException e) {
            throw new AccountNotFoundException();
        }
    }

    @Override
    public Integer getTotalPoints(Integer client_id) throws AccountNotFoundException {
        Account account = this.findClientAccount(client_id);
        return account.getTotalPoints();
    }

    @Override
    public void addPointsToAccount(Integer client_id) throws AccountNotFoundException {

        try {
            Account a = findClientAccount(client_id);
            if (a.getTotalPoints() < 300) {
                a.setTotalPoints(a.getTotalPoints());
            }
            //Integer pricePayed = avoir le montant total payé
            //get total Point du compte si le total est inferieur à 300 alors on rajoute sinon on ne fait rien
            //convertion : 1euro -> 10 points
            //et c'est tout
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void useBonusPoints(Integer client_id) throws AccountNotFoundException {
        try {
            Account a = findClientAccount(client_id);
            Integer accountPoints = a.getTotalPoints();
            if (accountPoints == 300) {
                a.setTotalPoints(0);
            } else {
                System.out.println("Maximum points not reached yet ! ");
            }
        } catch (Exception e) {
            throw new AccountNotFoundException();
        }
    }


}
