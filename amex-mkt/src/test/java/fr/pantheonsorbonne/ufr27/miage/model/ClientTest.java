package fr.pantheonsorbonne.ufr27.miage.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClientTest {

    private Client client;

    @BeforeEach
    public void setUp() {
        // Initialisation avant chaque test
        client = new Client(1, "M", 25, "Engineer");
    }

    @Test
    public void testGetIdClient() {
        assertEquals(1, client.getIdClient());
    }

    @Test
    public void testSetIdClient() {
        client.setIdClient(2);
        assertEquals(2, client.getIdClient());
    }

    @Test
    public void testGetGenre() {
        assertEquals("M", client.getGenre());
    }

    @Test
    public void testSetGenre() {
        client.setGenre("F");
        assertEquals("F", client.getGenre());
    }

    @Test
    public void testGetAge() {
        assertEquals(25, client.getAge());
    }

    @Test
    public void testSetAge() {
        client.setAge(30);
        assertEquals(30, client.getAge());
    }

    @Test
    public void testGetProfession() {
        assertEquals("Engineer", client.getProfession());
    }

    @Test
    public void testSetProfession() {
        client.setProfession("Doctor");
        assertEquals("Doctor", client.getProfession());
    }
}

