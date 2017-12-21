package ua.com.delivery.service;

import org.apache.log4j.Logger;
import ua.com.delivery.persistence.dao.AbstractFactory;
import ua.com.delivery.persistence.dao.IAbstractFactory;
import ua.com.delivery.persistence.entity.User;

import java.util.ArrayList;
import java.util.List;

public class AdministratorService {
    private static final Logger LOGGER = Logger.getLogger(AdministratorService.class);
    private static AdministratorService INSTANCE;

    private IAbstractFactory factory;

    private AdministratorService() {
        factory = new AbstractFactory();
    }

    public static AdministratorService getInstance() {
        if (INSTANCE == null) {
            synchronized (AdministratorService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AdministratorService();
                }
            }
        }
        return INSTANCE;
    }

    public List<User> getAdminsAndUsers() {
        List<User> userList = factory.createUserDao().getListUsers();
        if (userList == null) {
            LOGGER.info("Your users list is empty");
        }
        LOGGER.info("Successful operating with getting list of admins and users.");
        return userList;
    }

    public List<User> getOnlyUsers() {
        List<User> userList = factory.createUserDao().getListUsers();
        List<User> onlyUsersList = new ArrayList<>();
        if (userList == null) {
            LOGGER.info("Your users list is empty");
        } else {
            for (User user : userList) {
                if (!user.getAdmin()) {
                    onlyUsersList.add(user);
                }
            }
        }
        return onlyUsersList;
    }

    public User updateUser(User user){
        User updatedUser = factory.createUserDao().updateUser(user);
        if (updatedUser == null){
            LOGGER.info("Nothing to update");
        }
        LOGGER.info("User " + user.getUsername() + " was updated");
        return updatedUser;
    }

    public void deleteUser(User user){
        factory.createUserDao().deleteUserByUsername(user.getUsername());
        LOGGER.info("User with username " + user.getUsername() + " was successful deleted.");

    }
}
