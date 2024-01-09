package top.nextnet.dao;

import top.nextnet.model.Account;

import java.util.List;

public interface AccountDAO {
    List<Account> findAccountsByCustomerId(int customerId);
}
