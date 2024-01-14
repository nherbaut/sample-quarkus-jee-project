package fr.pantheonsorbonne.ufr27.miage.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CashbackTest {

    private Cashback cashback;

    @BeforeEach
    public void setUp() {
        cashback = new Cashback(1, 5.0, 100.0);
    }

    @Test
    public void testGetIdClient() {
        assertEquals(1, cashback.getIdClient());
    }

    @Test
    public void testSetIdClient() {
        cashback.setIdClient(2);
        assertEquals(2, cashback.getIdClient());
    }

    @Test
    public void testGetIdCashback() {
        assertNull(cashback.getIdCashback());
    }

    @Test
    public void testSetIdCashback() {
        cashback.setIdCashback(100);
        assertEquals(100, cashback.getIdCashback());
    }

    @Test
    public void testGetTaux() {
        assertEquals(5.0, cashback.getTaux(), 0.01);
    }

    @Test
    public void testSetTaux() {
        cashback.setTaux(10.0);
        assertEquals(10.0, cashback.getTaux(), 0.01);
    }

    @Test
    public void testGetMontantCashback() {
        assertEquals(5.0, cashback.getMontantCashback(), 0.01);
    }

    @Test
    public void testSetMontantCashback() {
        cashback.setMontantCashback(10.0);
        assertEquals(10.0, cashback.getMontantCashback(), 0.01);
    }

    @Test
    public void testGetMontant() {
        assertEquals(100.0, cashback.getMontant(), 0.01);
    }

    @Test
    public void testSetMontant() {
        cashback.setMontant(200.0);
        assertEquals(200.0, cashback.getMontant(), 0.01);
    }
}

