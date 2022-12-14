package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.exception.ClientNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.PasswordIncorrectException;
import fr.pantheonsorbonne.ufr27.miage.model.Account;
import fr.pantheonsorbonne.ufr27.miage.model.SecretPassword;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.InputMismatchException;

@ApplicationScoped
public class SecretPasswordImpl implements SecretPasswordDAO{

    @PersistenceContext(name = "mysql")
    EntityManager em;


    @Override
    @Transactional
    public SecretPassword findSecretPassword(Integer password) throws PasswordIncorrectException {
        try{
            return (SecretPassword) em.createQuery("select s from SecretPassword s where s.secretPassword = :password").setParameter("password", password).getSingleResult();
        }catch (InputMismatchException e){
            throw new PasswordIncorrectException(password);
        }
    }
}
