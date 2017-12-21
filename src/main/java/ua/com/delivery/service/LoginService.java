package ua.com.delivery.service;

import org.apache.log4j.Logger;
import ua.com.delivery.persistence.dao.AbstractFactory;
import ua.com.delivery.persistence.dao.IAbstractFactory;
import ua.com.delivery.persistence.entity.User;

public class LoginService {
    private static final Logger LOGGER = Logger.getLogger(LoginService.class.getName());
    private static LoginService INSTANCE;
    private static final String USER = "UserDAO";

    private IAbstractFactory factory;

    private LoginService(){
        factory = new AbstractFactory();
    }

    public static LoginService getInstance(){
        if (INSTANCE == null){
            synchronized (LoginService.class){
                if (INSTANCE == null){
                    INSTANCE = new LoginService();
                }
            }
        }
        return INSTANCE;
    }

    public User existUsername(String username){
        User user = factory.createUserDao().getUserByUsername(username);
        LOGGER.info(username + ": is present in our DB");
        return user;
    }
}
