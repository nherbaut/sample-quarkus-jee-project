package top.nextnet.service;

import fr.pantheonsorbonne.ufr27.miage.dao.CustomerDAO;
import fr.pantheonsorbonne.ufr27.miage.dto.TokenSend;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import top.nextnet.dao.AccountDAO;
import top.nextnet.dao.BankDAO;
import top.nextnet.dao.TokenDAO;
import top.nextnet.dao.UserDAO;
import top.nextnet.exception.BankinAccountNotFoundException;
import top.nextnet.model.Account;
import top.nextnet.model.Bank;
import top.nextnet.model.Token;
import top.nextnet.model.User;
@ApplicationScoped
public class TokenServiceImpl implements TokenService {

    @Inject
    TokenDAO tokenDAO;
    @Inject
    BankDAO bankDAO;
    @Inject
    UserDAO userDAO;

    @Inject
    AccountDAO accountDAO;

    @Override
    @Transactional
    public Token saveToken(TokenSend tokenSend){
        try {

            Bank bank = bankDAO.findMatchingBank(tokenSend.getIdBank());
            User user = userDAO.findMatchingUser(tokenSend.getMail());
            Account account = accountDAO.findMatchingAccount(user.getIdUser());
            Token token = tokenDAO.createNewToken(bank.getIdBank(), account.getIdAccount(), tokenSend.getToken());

            return token;

        } catch (Exception e) {
            return null;
        } catch (BankinAccountNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Token getTokenForUser(TokenSend tokenSend) {

        Token token = tokenDAO.findTokenByUser(tokenSend.getMail());

        return token;
    }


}
