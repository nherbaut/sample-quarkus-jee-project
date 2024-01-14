package fr.pantheonsorbonne.ufr27.miage.model;

import fr.pantheonsorbonne.ufr27.miage.model.Cashback;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CashbackTest {

    @Test
    void testConstructor() {
        Cashback cashback = new Cashback(1, 101, 0.1f);
        assertEquals(1, cashback.getIdClient());
        assertEquals(101, cashback.getIdTransaction());
        assertEquals(0.1f, cashback.getTauxCashback());
    }

    @Test
    void testGettersAndSetters() {
        Cashback cashback = new Cashback();

        cashback.setIdClient(2);
        assertEquals(2, cashback.getIdClient());

        cashback.setIdTransaction(202);
        assertEquals(202, cashback.getIdTransaction());

        cashback.setTauxCashback(0.05f);
        assertEquals(0.05f, cashback.getTauxCashback());

        cashback.setIdCashback(1);
        assertEquals(1, cashback.getIdCashback());
    }
}

