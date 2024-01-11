package fr.pantheonsorbonne.ufr27.miage.camel;

import fr.pantheonsorbonne.ufr27.miage.model.Client;
import fr.pantheonsorbonne.ufr27.miage.model.Transaction;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import fr.pantheonsorbonne.ufr27.miage.service.TransactionService;
import org.apache.camel.Exchange;

@ApplicationScoped
public class TransactionGateway {

    @Inject
    TransactionService transactionService;

    public Transaction transaction(Exchange e){//Integer idClient) {
        Integer idClient =(Integer) e.getProperty("idClient");
        return transactionService.transaction(idClient);
    }

    public Transaction getMontantTransaction(Integer idTransaction){
        return transactionService.getMontantTransaction(idTransaction);
    }
}
