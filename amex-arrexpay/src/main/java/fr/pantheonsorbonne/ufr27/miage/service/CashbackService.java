package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.exception.CustomerNotFoundException;

public interface CashbackService {

    Double getCashbackAmount(int idClient) throws CustomerNotFoundException;
}