package ua.com.delivery.service;

import org.apache.log4j.Logger;
import ua.com.delivery.persistence.dao.AbstractFactory;
import ua.com.delivery.persistence.dao.IAbstractFactory;
import ua.com.delivery.persistence.entity.User;

public class LoginService {
    private static final Logger LOGGER = Logger.getLogger(LoginService.class);
    private static LoginService INSTANCE;

    private IAbstractFactory factory;

    private LoginService() {
        factory = new AbstractFactory();
    }

    public static LoginService getInstance() {
        if (INSTANCE == null) {
            synchronized (LoginService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LoginService();
                }
            }
        }
        return INSTANCE;
    }

    public boolean checkPasswordForUsername(User user, String password) {
        return user.getPassword().equals(password);
    }

    public User existUsername(String username) {
        User user = factory.createUserDao().getUserByUsername(username);
        if (user != null) {
            LOGGER.info(username + ": is present in our DB");
        } else {
            LOGGER.info(username + ": isn't present in our DB");
        }
        return user;
    }

}
