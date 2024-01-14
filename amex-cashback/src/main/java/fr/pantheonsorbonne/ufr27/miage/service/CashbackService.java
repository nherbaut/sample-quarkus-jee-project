package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.CashbackDAOImpl;
import fr.pantheonsorbonne.ufr27.miage.model.Cashback;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CashbackService {

    @Inject
    CashbackDAOImpl cdi;

    @Transactional
    public Cashback cashback(Cashback c) {
        return cdi.CreateNewCashback(c.getIdClient(),c.getTaux(),c.getMontant());
    }
}
