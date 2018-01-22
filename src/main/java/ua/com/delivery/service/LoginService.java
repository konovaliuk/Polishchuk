package ua.com.delivery.service;

import org.apache.log4j.Logger;
import ua.com.delivery.controller.utilController.MessageHelper;
import ua.com.delivery.controller.utilController.PageConfiguration;
import ua.com.delivery.persistence.dao.AbstractFactory;
import ua.com.delivery.persistence.dao.IAbstractFactory;
import ua.com.delivery.persistence.entity.User;

import javax.servlet.http.HttpServletRequest;

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


    public String checkUserPassword(HttpServletRequest request, User user, String password) {
        String page;
        if (checkPasswordForUsername(user, password)) {
            page = checkIfAdmin(user, request);
        } else {

            page = redirectOnErrorPage(request);
        }
        return page;
    }

    private String checkIfAdmin(User user, HttpServletRequest request) {
        String page;
        if (user.getAdmin()) {
            page = redirectOnAdminPage(user, request);
        } else {
            page = redirectOnUserPage(user, request);
        }
        return page;
    }

    private String redirectOnAdminPage(User user, HttpServletRequest request) {
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.ADMIN_PAGE);
    }

    private String redirectOnUserPage(User user, HttpServletRequest request) {
        request.getSession().setAttribute("visibleOrder", true);
        request.getSession().setAttribute("visibleLogout", true);
        request.getSession().setAttribute("visibleUser", user.getUsername());
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.MAIN_PAGE);
    }


    public String redirectOnErrorPage(HttpServletRequest request) {
//        перенапралвення на логін пейдж, якщоне правильно ввів логін
        request.setAttribute("wrongPassword",
                MessageHelper.getInstance().getMessageException(MessageHelper.WRONG_PASSWORD));
        LOGGER.info("User wrote a wrong password");
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.LOGIN_PAGE);
    }

    private boolean checkPasswordForUsername(User user, String password) {
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
