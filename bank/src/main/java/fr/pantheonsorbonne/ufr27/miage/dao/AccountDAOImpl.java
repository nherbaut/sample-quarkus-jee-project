package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.exception.ClientNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.Account;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class AccountDAOImpl implements AccountDAO{

    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Override
    @Transactional
    public Account findClientAccount(Integer clientId) throws ClientNotFoundException {
        try {
            return (Account) em.createQuery("Select a from Account a where a.id = :clientId ").setParameter("clientId", clientId).getSingleResult();
        }catch (NoResultException e){
            throw new ClientNotFoundException(clientId);
        }
    }

    @Override
    @Transactional
    public int updateClientAccountSold(Integer clientId, Float newSold) throws  ClientNotFoundException{
        try {
            return em.createQuery("UPDATE Account a SET a.solde = :newSold WHERE a.id = :clientId").setParameter("clientId", clientId).setParameter("newSold", newSold).executeUpdate();
        }catch (NoResultException e){
            throw new ClientNotFoundException(clientId);
        }
    }

}
