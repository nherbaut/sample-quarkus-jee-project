package fr.pantheonsorbonne.ufr27.miage.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClientLuxeTest {

    private ClientLuxe clientLuxe;

    @BeforeEach
    public void setUp() {
        // Initialisation avant chaque test
        Client client = new Client(1, "M", 25, "Engineer");
        clientLuxe = new ClientLuxe(client);
    }

    @Test
    public void testGetIdClient() {
        assertEquals(1, clientLuxe.getIdClient());
    }

    @Test
    public void testSetIdClient() {
        clientLuxe.setIdClient(2);
        assertEquals(2, clientLuxe.getIdClient());
    }

    @Test
    public void testGetGenre() {
        assertEquals("M", clientLuxe.getGenre());
    }

    @Test
    public void testSetGenre() {
        clientLuxe.setGenre("F");
        assertEquals("F", clientLuxe.getGenre());
    }

    @Test
    public void testGetAge() {
        assertEquals(25, clientLuxe.getAge());
    }

    @Test
    public void testSetAge() {
        clientLuxe.setAge(30);
        assertEquals(30, clientLuxe.getAge());
    }

    @Test
    public void testGetProfession() {
        assertEquals("Engineer", clientLuxe.getProfession());
    }

    @Test
    public void testSetProfession() {
        clientLuxe.setProfession("Doctor");
        assertEquals("Doctor", clientLuxe.getProfession());
    }
}

