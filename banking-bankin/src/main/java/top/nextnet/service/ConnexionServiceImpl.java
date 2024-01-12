package top.nextnet.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import top.nextnet.dao.AccountDAO;
import top.nextnet.dao.UserDAO;
import top.nextnet.exception.BankinAccountNotFoundException;
import io.quarkus.elytron.security.common.BcryptUtil;
import top.nextnet.model.Account;
import top.nextnet.model.User;
import top.nextnet.service.ConnexionService;


@ApplicationScoped

public class ConnexionServiceImpl implements ConnexionService {

    @Inject
    AccountDAO accountDAO;

    @Inject
    UserDAO userDAO;

    @Override
    @Transactional
    public boolean login(String email, String pwd){
        try{
            User user = userDAO.findMatchingUser(email);
            Account account = accountDAO.findMatchingAccount(user.getIdUser());
            if(this.checkPassword(account.getPassword(),pwd)){
                return true;
            }
            return false;
        } catch (BankinAccountNotFoundException e) {
            return false;
        }
    }
    public boolean checkPassword(String passwordHash, String password){
        return BcryptUtil.matches(password,passwordHash);
    }
}
