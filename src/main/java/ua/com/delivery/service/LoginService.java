package ua.com.delivery.service;

import org.apache.log4j.Logger;
import ua.com.delivery.web.controller.utilController.MessageHelper;
import ua.com.delivery.web.controller.utilController.PageConfiguration;
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

    /**
     * Singleton
     *
     * @return INSTANCE
     */
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


    /**
     * Method checking user password
     *
     * @param request
     * @param user
     * @param password
     * @return page
     */
    public String checkUserPassword(HttpServletRequest request, User user, String password) {
        String page;
        if (checkPasswordForUsername(user, password)) {
            LOGGER.info("Password is ok for admin or user");
            page = checkIfAdmin(user, request);
        } else {
            LOGGER.info("Password is wrong for admin and user");
            page = redirectOnErrorPage(request);
        }
        return page;
    }

    /**
     * Method check user or admin
     *
     * @param request
     * @param user
     * @return page
     */
    private String checkIfAdmin(User user, HttpServletRequest request) {
        String page;
        if (user.getAdmin()) {
            LOGGER.info("Password is ok for admin");
            page = redirectOnAdminPage(user, request);
        } else {
            LOGGER.info("Password is ok for user");
            page = redirectOnUserPage(user, request);
        }
        return page;
    }

    /**
     * Method for redirect on admin Page
     *
     * @param request
     * @param user
     * @return page
     */
    private String redirectOnAdminPage(User user, HttpServletRequest request) {
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.ADMIN_PAGE);
    }

    /**
     * Method for redirect on user Page
     *
     * @param request
     * @param user
     * @return page
     */
    private String redirectOnUserPage(User user, HttpServletRequest request) {
        request.getSession().setAttribute("visibleOrder", true);
        request.getSession().setAttribute("visibleLogout", true);
        request.getSession().setAttribute("visibleUser", user.getUsername());
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.MAIN_PAGE);
    }

    /**
     * Method for redirect on error Page
     *
     * @param request
     * @return page
     */
    public String redirectOnErrorPage(HttpServletRequest request) {
        request.setAttribute("wrongPassword",
                MessageHelper.getInstance().getMessageException(MessageHelper.WRONG_PASSWORD));
        LOGGER.info("User wrote a wrong password");
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.LOGIN_PAGE);
    }

    /**
     * Method for check user and his password in database
     *
     * @param password
     * @param user
     * @return true/false
     */
    private boolean checkPasswordForUsername(User user, String password) {
        return user.getPassword().equals(password);
    }

    /**
     * Method for check is exist username in database
     *
     * @param username
     * @return user
     */
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
