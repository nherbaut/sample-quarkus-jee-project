package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Client;
public interface ClientDAO{
    Client CreateNewClient(Integer idClient, String genre, Integer age, String profession);

    Client FindClient(Integer idClient);
}

