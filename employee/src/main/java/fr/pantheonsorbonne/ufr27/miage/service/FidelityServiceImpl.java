package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.camel.FidelityGateway;
import fr.pantheonsorbonne.ufr27.miage.dto.ClientDTO;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FidelityServiceImpl implements FidelityService{

    @Inject
    FidelityGateway fidelityGateway;

    ClientDTO client;

    @Override
    public void askConnection(Integer clientId){
        fidelityGateway.askConnection(clientId);
    }

    @Override
    public void receiveClient(ClientDTO client) {
        this.client = client;
    }

    @Override
    public ClientDTO connection(Integer clientId) {
        askConnection(clientId);
        while (client == null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        return this.client;
    }

}
