package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.model.Client;
import fr.pantheonsorbonne.ufr27.miage.service.ClientService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ClientGateway {

    @Inject
    ClientService clientService;

    public Client client(Client clientRequest, double price) {

        return clientService.client(clientRequest, price);
    }


}
