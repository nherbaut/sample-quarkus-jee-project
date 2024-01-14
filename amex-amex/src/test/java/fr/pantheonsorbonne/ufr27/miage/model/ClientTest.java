package fr.pantheonsorbonne.ufr27.miage.model;
import fr.pantheonsorbonne.ufr27.miage.model.Client;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void testConstructor() {
        Client client = new Client(1, "M", 25, "Software Engineer");
        assertEquals(1, client.getIdClient());
        assertEquals("M", client.getGenre());
        assertEquals(25, client.getAge());
        assertEquals("Software Engineer", client.getProfession());
    }

    @Test
    void testGettersAndSetters() {
        Client client = new Client();

        client.setIdClient(2);
        assertEquals(2, client.getIdClient());

        client.setGenre("F");
        assertEquals("F", client.getGenre());

        client.setAge(30);
        assertEquals(30, client.getAge());

        client.setProfession("Teacher");
        assertEquals("Teacher", client.getProfession());

        client.setNum_carte(12345);
        assertEquals(12345, client.getNum_carte());
    }
}

