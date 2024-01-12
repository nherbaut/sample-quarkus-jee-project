package top.nextnet.dao;

import top.nextnet.exception.BankinAccountNotFoundException;
import top.nextnet.model.Account;

public interface AccountDAO {
    Account findMatchingAccount(int idUser) throws BankinAccountNotFoundException;
}
