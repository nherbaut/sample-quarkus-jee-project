package fr.pantheonsorbonne.ufr27.miage.service;
import fr.pantheonsorbonne.ufr27.miage.dao.TransactionDAOImpl;
import fr.pantheonsorbonne.ufr27.miage.model.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionServiceTest {

    @InjectMocks
    private TransactionService transactionService;

    @Mock
    private TransactionDAOImpl transactionDAO;

    @Mock
    @PersistenceContext(name = "Transaction")
    private EntityManager entityManager;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testTransaction() {
        Integer idClient = 1;
        Transaction expectedTransaction = new Transaction(idClient, 100.0);

        // Configure le comportement simulé du TransactionDAO
        when(transactionDAO.FindTransaction(idClient)).thenReturn(expectedTransaction);

        // Appel de la méthode de service
        Transaction result = transactionService.transaction(idClient);

        // Vérifie que la méthode FindTransaction de TransactionDAO a été appelée avec le bon argument
        verify(transactionDAO, times(1)).FindTransaction(idClient);

        // Vérifie que le résultat renvoyé par le service est le même objet que celui simulé par TransactionDAO
        assertSame(expectedTransaction, result);
    }

    @Test
    void testGetMontantTransaction() {
        Integer idTransaction = 101;
        Transaction transaction = new Transaction(1, 100.0);

        // Configure le comportement simulé de l'EntityManager
        when(entityManager.find(Transaction.class, idTransaction)).thenReturn(transaction);
        doNothing().when(entityManager).persist(transaction);

        // Appel de la méthode de service
        Transaction result = transactionService.getMontantTransaction(idTransaction);

        // Vérifie que la méthode find et persist de l'EntityManager ont été appelées avec les bons arguments
        verify(entityManager, times(1)).find(Transaction.class, idTransaction);
        verify(entityManager, times(1)).persist(transaction);

        // Vérifie que le résultat renvoyé par le service est le même objet que celui simulé par l'EntityManager
        assertSame(transaction, result);

        // Vérifie que le statut de la transaction a été mis à true
        assertTrue(result.isTransactionStatue());
    }
}
