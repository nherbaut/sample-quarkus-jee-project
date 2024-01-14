package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.exception.CustomerNotFoundException;

public interface CashBackDAO {
    Double findCashback(int idClient) throws CustomerNotFoundException;
}