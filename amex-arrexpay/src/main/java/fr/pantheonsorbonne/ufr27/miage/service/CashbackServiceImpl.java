package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dao.CashBackDAO;
import fr.pantheonsorbonne.ufr27.miage.exception.CustomerNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CashbackServiceImpl implements CashbackService {

    @Inject
    CashBackDAO cashBackDAO;
    @Override
    public Double getCashbackAmount(int idClient) throws CustomerNotFoundException {
       return cashBackDAO.findCashback(idClient);
    }
}