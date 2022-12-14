package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.ClientDTO;

public interface FidelityService {

    ClientDTO connection(Integer clientId);

    public void receiveClient(ClientDTO client);

    public void askConnection(Integer clientId);

}
