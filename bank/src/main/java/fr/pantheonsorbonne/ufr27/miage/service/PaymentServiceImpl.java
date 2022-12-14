package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.camel.PaymentGateway;
import fr.pantheonsorbonne.ufr27.miage.dao.AccountDAO;
import fr.pantheonsorbonne.ufr27.miage.dao.SecretPasswordDAO;
import fr.pantheonsorbonne.ufr27.miage.dto.AccountDTO;
import fr.pantheonsorbonne.ufr27.miage.exception.ClientNotFoundException;
import fr.pantheonsorbonne.ufr27.miage.exception.PasswordIncorrectException;
import fr.pantheonsorbonne.ufr27.miage.exception.SoldUnsifficientException;
import fr.pantheonsorbonne.ufr27.miage.model.Account;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PaymentServiceImpl implements PaymentService{

    @Inject
    AccountDAO accountDAO;

    @Inject
    SecretPasswordDAO secretPasswordDAO;

    @Inject
    PaymentGateway paymentGateway;

    String url = "http://localhost:8082/payment";
    Float totalPrice;

    private AccountDTO convertAccountToAccountDTO(Integer accountId) throws ClientNotFoundException {
        Account a = accountDAO.findClientAccount(accountId);
        return new AccountDTO(a.getId(),a.getCustomerName(),a.getMaxDecouvert(),a.getPlafond(),a.getSolde());
    }

    @Override
    public String sendRedirectURL(Float totalPrice) {
        stockTotalPrice(totalPrice);
        return this.url;
    }

    private Float stockTotalPrice(Float totalPrice){
        this.totalPrice = totalPrice;
        return totalPrice;
    }

    @Override
    public boolean cardPayment(Integer clientId, Integer password) throws ClientNotFoundException, PasswordIncorrectException, SoldUnsifficientException {
        Account a = accountDAO.findClientAccount(clientId);
        secretPasswordDAO.findSecretPassword(password);
        AccountDTO accountDTO = convertAccountToAccountDTO(a.getId());
        Float updatedSold = accountDTO.getSolde() - totalPrice;
        if(accountDTO.getSolde()<this.totalPrice){
            throw new SoldUnsifficientException();
        }
        accountDAO.updateClientAccountSold(clientId,updatedSold);
        this.sendPaidPrice(this.totalPrice);
        return true;
    }

    @Override
    public void sendPaidPrice(Float sendPrice) {
        this.paymentGateway.sendPaidPrice(sendPrice);
    }

}
