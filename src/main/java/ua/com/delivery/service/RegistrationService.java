package ua.com.delivery.service;

import org.apache.log4j.Logger;
import ua.com.delivery.controller.utilController.MessageHelper;
import ua.com.delivery.controller.utilController.PageConfiguration;
import ua.com.delivery.persistence.dao.AbstractFactory;
import ua.com.delivery.persistence.dao.IAbstractFactory;
import ua.com.delivery.persistence.dao.daoimpl.UserImpl;
import ua.com.delivery.persistence.entity.User;

import javax.servlet.http.HttpServletRequest;

public class RegistrationService {
    private static final Logger LOGGER = Logger.getLogger(RegistrationService.class);
    private static RegistrationService  INSTANCE;

    private IAbstractFactory factory;

    private RegistrationService() {
        factory = new AbstractFactory();
    }

    public static RegistrationService getInstance(){
        if (INSTANCE == null){
            synchronized (RegistrationService.class) {
                if (INSTANCE == null){
                    INSTANCE = new RegistrationService();
                }
            }
        }
        return INSTANCE;
    }

    public String registration(HttpServletRequest request, String username, String password, String firstName,
                               String secondName, String email, String address, String city, String phone){
        String page;
        if (LoginService.getInstance().existUsername(username) == null) {
            UserImpl userImpl = factory.createUserDao();
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setFirstName(firstName);
            user.setSecondName(secondName);
            user.setEmail(email);
            user.setAddress(address);
            user.setCity(city);
            user.setPhone(Integer.valueOf(phone));
            user.setAdmin(false);

            userImpl.createUser(user);
            if (user.getUserID() == null) {
                request.setAttribute("createUser",
                        MessageHelper.getInstance().getMessageException(MessageHelper.USER_CREATE));
                page = PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.REGISTRATION_PAGE);
            } else {
                page = PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.MAIN_PAGE);
            }
        } else {
            LOGGER.info("Was attempt to registration with exist username");
            request.setAttribute("existUsername",
                    MessageHelper.getInstance().getMessageException(MessageHelper.EXIST_USERNAME));
            page = PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.REGISTRATION_PAGE);
        }
        return page;
    }
}
