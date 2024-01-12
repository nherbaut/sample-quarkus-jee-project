package top.nextnet.dao;

import top.nextnet.exception.BankinAccountNotFoundException;
import top.nextnet.model.Password;

public interface PasswordDAO {
    Password findMatchingPassword(int idAccount) throws BankinAccountNotFoundException;;
}
