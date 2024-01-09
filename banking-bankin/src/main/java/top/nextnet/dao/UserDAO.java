package top.nextnet.dao;

import top.nextnet.model.User;

public interface UserDAO {
    User findMatchingUser(String email);
}
