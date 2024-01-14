package top.nextnet.dao;


import top.nextnet.model.Bank;

import java.util.List;

public interface BankDAO {
    Bank findMatchingBank(String name);
    List<Bank> getAllBanks();

}
