package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.model.Client;
import fr.pantheonsorbonne.ufr27.miage.model.ClientLuxe;
import fr.pantheonsorbonne.ufr27.miage.service.ClientService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    @Mock
    @PersistenceContext(name = "Client")
    private EntityManager em;

    @Mock
    @PersistenceContext(name = "ClientLuxe")
    private EntityManager em2;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testClientSuccess() {
        // Création d'un objet Client pour le test
        Client clientRequest = new Client(1, "M", 25, "Engineer");

        // Configuration du comportement de l'EntityManager
        when(em.find(Client.class, clientRequest.getIdClient())).thenReturn(null);
        when(em2.find(ClientLuxe.class, clientRequest.getIdClient())).thenReturn(null);

        // Appel à la méthode client du service
        boolean result = clientService.client(clientRequest);

        // Vérifications
        assertTrue(result);
        verify(em, times(1)).persist(clientRequest);
        verify(em2, never()).persist(any());
    }

    @Test
    void testClientFailureDuplicateClient() {
        // Création d'un objet Client pour le test
        Client clientRequest = new Client(1, "M", 25, "Engineer");

        // Configuration du comportement de l'EntityManager pour simuler un client déjà existant
        when(em.find(Client.class, clientRequest.getIdClient())).thenReturn(new Client());

        // Appel à la méthode client du service
        boolean result = clientService.client(clientRequest);

        // Vérifications
        assertFalse(result);
        verify(em, never()).persist(any());
        verify(em2, never()).persist(any());
    }

    @Test
    void testClientFailureDuplicateClientLuxe() {
        // Création d'un objet Client pour le test
        Client clientRequest = new Client(1, "M", 25, "Engineer");

        // Configuration du comportement de l'EntityManager2 pour simuler un client luxe déjà existant
        when(em2.find(ClientLuxe.class, clientRequest.getIdClient())).thenReturn(new ClientLuxe());

        // Appel à la méthode client du service
        boolean result = clientService.client(clientRequest);

        // Vérifications
        assertFalse(result);
        verify(em, never()).persist(any());
        verify(em2, never()).persist(any());
    }

    @Test
    void testClientLuxeSuccess() {
        // Création d'un objet Client pour le test avec une profession éligible au client luxe
        Client clientRequest = new Client(1, "M", 25, "medecin");

        // Configuration du comportement de l'EntityManager2
        when(em2.find(ClientLuxe.class, clientRequest.getIdClient())).thenReturn(null);

        // Appel à la méthode client du service
        boolean result = clientService.client(clientRequest);

        // Vérifications
        assertTrue(result);
        verify(em2, times(1)).persist(any());
        verify(em, never()).persist(any());
    }
}
