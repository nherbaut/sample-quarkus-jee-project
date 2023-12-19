package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Cashback;
import fr.pantheonsorbonne.ufr27.miage.model.Client;
import fr.pantheonsorbonne.ufr27.miage.model.Transaction;

public interface CashbackDAO {
    Cashback CreateNewCashback(Client idClient, Transaction idTransaction, float tauxCashback);

    Cashback FindCashback(Integer idCashback);
}
