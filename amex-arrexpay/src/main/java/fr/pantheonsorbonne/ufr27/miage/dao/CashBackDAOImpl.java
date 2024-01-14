package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.exception.CustomerNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.model.CashBack;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@ApplicationScoped
public class CashBackDAOImpl implements CashBackDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    public Double findCashback(int idClient) throws CustomerNotFoundException {
        //check if client exist
        if (! em.createQuery("Select c from CashBack c where c.idClient=:idClient", CashBack.class).setParameter("idClient", idClient).getResultList().isEmpty()) {
            return em.createQuery("Select sum(c.tauxCashback) from CashBack c where c.idClient=:idClient", Double.class).setParameter("idClient", idClient).getSingleResult();
        }
        else {
            throw new CustomerNotFoundException(idClient);
        }
    }
}