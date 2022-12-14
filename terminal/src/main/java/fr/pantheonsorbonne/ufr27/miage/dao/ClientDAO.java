package fr.pantheonsorbonne.ufr27.miage.dao;

import fr.pantheonsorbonne.ufr27.miage.model.Client;

public interface ClientDAO {

    Client createNewClient (String clientFirstName, String clientLastName);

    public Client findClient(Integer clientId);
}