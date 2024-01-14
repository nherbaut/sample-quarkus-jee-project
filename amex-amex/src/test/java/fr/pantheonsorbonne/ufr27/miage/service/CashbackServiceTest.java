package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.model.Cashback;
import fr.pantheonsorbonne.ufr27.miage.service.CashbackService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CashbackServiceTest {

    @InjectMocks
    private CashbackService cashbackService;

    @Mock
    @PersistenceContext(name = "Cashback")
    private EntityManager entityManager;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCashback() {
        Cashback cashback = new Cashback(1, 101, 15);
        doNothing().when(entityManager).persist(cashback);
        Cashback result = cashbackService.cashback(cashback);
        verify(entityManager, times(1)).persist(cashback);
        assertSame(cashback, result);
    }
}

