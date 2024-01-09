package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.dto.Client;

public interface AmexService {
    void sendInformationPayment(Client client, float price);
}
