package top.nextnet.dao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import top.nextnet.model.User;

@ApplicationScoped
public class UserDAOimpl implements UserDAO{


    @PersistenceContext(name = "mysql")
    EntityManager em;
    @Override
    @Transactional
    public User findMatchingUser(String email) {
        try {
            User c = (User) em.createQuery("Select c from User c where c.email=:email").setParameter("email", email).getSingleResult();
            return c;
        } catch (Exception e) {
            return null;
        }
    }
}
