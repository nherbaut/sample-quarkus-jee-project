package top.nextnet.dao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import top.nextnet.exception.BankinAccountNotFoundException;
import top.nextnet.model.Password;

@ApplicationScoped
public class PasswordDAOimpl implements PasswordDAO{

    @PersistenceContext(name="mysql")
    EntityManager em;
    @Override
    @Transactional
    public Password findMatchingPassword(int idAccount) throws BankinAccountNotFoundException {
        try{
            Password password = (Password) (em.createQuery("Select a from Password a " +
                            " where a.idAccount=:idAccount")
                    .setParameter("idAccount", idAccount).getSingleResult());
            return password;
        }catch(NoResultException e){
            throw new BankinAccountNotFoundException();
        }
    }
}