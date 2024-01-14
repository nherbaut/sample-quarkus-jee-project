package top.nextnet.dao;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import top.nextnet.model.Bank;

import java.util.Collections;
import java.util.List;

@ApplicationScoped

public class BankDAOimpl implements BankDAO{

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

    public List<Bank> getAllBanks() {
        try {
            return em.createQuery("select b from Bank b", Bank.class).getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
