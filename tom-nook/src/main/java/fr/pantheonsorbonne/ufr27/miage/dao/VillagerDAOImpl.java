package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Villager;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@ApplicationScoped
public class VillagerDAOImpl implements VillagerDAO{

    @PersistenceContext(name = "mysql")
    EntityManager em;

    @Override
    public Collection<Villager> listAllVillager() {
        return em.createQuery("SELECT v from Villager v").getResultList();
    }
}
