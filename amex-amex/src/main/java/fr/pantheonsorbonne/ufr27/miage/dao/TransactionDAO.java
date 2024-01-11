package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Client;
import fr.pantheonsorbonne.ufr27.miage.model.Transaction;

public interface TransactionDAO {

    Transaction CreateNewTransaction(Integer idClient, double montantTransaction);

    Transaction FindTransaction(Integer idClient);
}
