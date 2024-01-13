package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Cashback;

public interface CashbackDAO {
    Cashback CreateNewCashback(Integer idClient, Integer idTransaction, float tauxCashback);

    Cashback FindCashback(Integer idCashback);
}
