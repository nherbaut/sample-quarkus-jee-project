package top.nextnet.service;

import top.nextnet.model.User;

import java.util.List;

public interface UserService {
    User getUserByEmail(String email);

}
