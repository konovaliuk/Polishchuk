package ua.com.delivery.service;

import org.apache.log4j.Logger;
import ua.com.delivery.web.controller.utilController.MessageHelper;
import ua.com.delivery.web.controller.utilController.PageConfiguration;
import ua.com.delivery.persistence.dao.AbstractFactory;
import ua.com.delivery.persistence.dao.IAbstractFactory;
import ua.com.delivery.persistence.dao.daoimpl.UserImpl;
import ua.com.delivery.persistence.entity.User;

import javax.servlet.http.HttpServletRequest;

public class RegistrationService {
    private static final Logger LOGGER = Logger.getLogger(RegistrationService.class);
    private static RegistrationService INSTANCE;

    private IAbstractFactory factory;

    private RegistrationService() {
        factory = new AbstractFactory();
    }

    /**
     * Singleton
     *
     * @return INSTANCE
     */
    public static RegistrationService getInstance() {
        if (INSTANCE == null) {
            synchronized (RegistrationService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RegistrationService();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Method for registration
     *
     * @param request
     * @param username
     * @param password
     * @param firstName
     * @param secondName
     * @param email
     * @param address
     * @param city
     * @param phone
     * @return page
     */
    public String registration(HttpServletRequest request, String username, String password, String firstName,
                               String secondName, String email, String address, String city, String phone) {
        boolean usernameOk = Validation.getInstance().validUsername(username);
        boolean passwordOk = Validation.getInstance().validPassword(password);
        boolean emailOk = Validation.getInstance().validEmail(email);
        String page;
        if (LoginService.getInstance().existUsername(username) == null) {
            UserImpl userImpl = factory.createUserDao();
            User user = new User();
            if (usernameOk) {
                user.setUsername(username);
            } else {
                request.setAttribute("usernameBoolean", true);
                request.setAttribute("usernameException",
                        MessageHelper.getInstance().getMessageException(MessageHelper.USERNAME_EXCEPTION));
                return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.REGISTRATION_PAGE);
            }
            if (passwordOk){
                user.setPassword(password);
            } else {
                request.setAttribute("passwordBoolean", true);
                request.setAttribute("passwordException",
                        MessageHelper.getInstance().getMessageException(MessageHelper.PASSWORD_EXCEPTION));
                return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.REGISTRATION_PAGE);
            }
            user.setFirstName(firstName);
            user.setSecondName(secondName);
            if (emailOk && existEmail(email) == null){
                user.setEmail(email);
            } else {
                request.setAttribute("emailBoolean", true);
                request.setAttribute("emailException",
                        MessageHelper.getInstance().getMessageException(MessageHelper.EMAIL_EXCEPTION));
                return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.REGISTRATION_PAGE);
            }
            user.setAddress(address);
            user.setCity(city);
            user.setPhone(Integer.valueOf(phone));
            user.setAdmin(false);

            userImpl.createUser(user);

            if (user.getUserID() == null) {
                request.setAttribute("createUser",
                        MessageHelper.getInstance().getMessageException(MessageHelper.USER_CREATE));
                LOGGER.info("User was created: " + username);
                page = PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.REGISTRATION_PAGE);
            } else {
                page = PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.MAIN_PAGE);
            }
        } else {
            LOGGER.info("Was attempt to registration with existing data");
            request.setAttribute("existUsername",
                    MessageHelper.getInstance().getMessageException(
                            MessageHelper.EXIST_USERNAME));
            page = PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.REGISTRATION_PAGE);
        }
        return page;
    }

    private User existEmail(String email) {
        User user = factory.createUserDao().getUserByEmail(email);
        if (user != null) {
            LOGGER.info(email + ": is present in our DB");
        } else {
            LOGGER.info(email + ": isn't present in our DB");
        }
        return user;
    }
}
