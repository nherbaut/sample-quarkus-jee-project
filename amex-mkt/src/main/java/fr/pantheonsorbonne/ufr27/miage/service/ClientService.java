package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.model.Client;
import fr.pantheonsorbonne.ufr27.miage.model.ClientLuxe;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.Objects;

@ApplicationScoped
public class ClientService {

    @PersistenceContext(name = "Client")
    EntityManager em;

    @PersistenceContext(name = "ClientLuxe")
    EntityManager em2;

    @Transactional
    public boolean client(Client clientRequest) {
        Client client = em.find(Client.class, clientRequest.getIdClient());
        ClientLuxe clientLuxe = new ClientLuxe(clientRequest);
        ClientLuxe clientLuxe1 = em2.find(ClientLuxe.class, clientLuxe.getIdClient());
        if(client!=null || clientLuxe1!=null){
            return false;
        }else{
            if(Objects.equals(clientRequest.getProfession(), "medecin") || Objects.equals(clientRequest.getProfession(), "avocat") ){
                em2.persist(clientLuxe);
            }
            else{em.persist(clientRequest);}
        }
        return true;
    }
}
