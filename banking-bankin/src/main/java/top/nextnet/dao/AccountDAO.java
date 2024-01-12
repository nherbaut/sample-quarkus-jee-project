package top.nextnet.dao;

import top.nextnet.exception.BankinAccountNotFoundException;
import top.nextnet.model.Account;

import java.util.List;

public interface AccountDAO {
    Account findMatchingAccount(int idUser) throws BankinAccountNotFoundException;
}
