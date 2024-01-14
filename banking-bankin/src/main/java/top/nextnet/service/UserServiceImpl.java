package top.nextnet.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import top.nextnet.dao.UserDAO;
import top.nextnet.model.User;

@ApplicationScoped

public class UserServiceImpl implements UserService {

    @Inject
    UserDAO userDAO;

    @Override
    @Transactional
    public User getUserByEmail(String email) {
        try {
            return userDAO.findMatchingUser(email);
        } catch (Exception e) {
            return null;
        }
    }
}
