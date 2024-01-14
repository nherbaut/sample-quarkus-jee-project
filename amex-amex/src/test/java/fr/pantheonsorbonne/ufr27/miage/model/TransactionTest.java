package fr.pantheonsorbonne.ufr27.miage.model;

import fr.pantheonsorbonne.ufr27.miage.model.Transaction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    void testConstructor() {
        Transaction transaction = new Transaction(1, 100.0);
        assertEquals(1, transaction.getIdClient());
        assertEquals(100.0, transaction.getMontantTransaction());
        assertFalse(transaction.isTransactionStatue());
    }

    @Test
    void testGettersAndSetters() {
        Transaction transaction = new Transaction();

        transaction.setIdClient(2);
        assertEquals(2, transaction.getIdClient());

        transaction.setIdTransaction(101);
        assertEquals(101, transaction.getIdTransaction());

        transaction.setMontantTransaction(200.0);
        assertEquals(200.0, transaction.getMontantTransaction());

        transaction.setTransactionStatue(true);
        assertTrue(transaction.isTransactionStatue());
    }
}

