package top.nextnet.dao;

import top.nextnet.model.Token;

public interface TokenDAO {
    Token createNewToken(int idbank, int idaccount, String token);

}
