package top.nextnet.dao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import top.nextnet.model.Bank;
import top.nextnet.model.User;

@ApplicationScoped

public class BankDAOimpl {

    @PersistenceContext(name = "mysql")
    EntityManager em;
    public Bank findMatchingBank(String name) {
        try {
            Bank c = (Bank) em.createQuery("Select c from Bank c where c.name=:name").setParameter("name", name).getSingleResult();
            return c;
        } catch (Exception e) {
            return null;
        }
    }
}
