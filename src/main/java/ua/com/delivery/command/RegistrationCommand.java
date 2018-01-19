package ua.com.delivery.command;

import org.apache.log4j.Logger;
import ua.com.delivery.controller.utilController.MessageHelper;
import ua.com.delivery.controller.utilController.PageConfiguration;
import ua.com.delivery.persistence.dao.AbstractFactory;
import ua.com.delivery.persistence.dao.daoimpl.UserImpl;
import ua.com.delivery.persistence.entity.User;
import ua.com.delivery.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationCommand implements ICommand{
    private static final Logger LOGGER = Logger.getLogger(RegistrationCommand.class);
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String FIRST_NAME = "firstName";
    private static final String SECOND_NAME = "secondName";
    private static final String EMAIL = "email";
    private static final String ADDRESS = "address";
    private static final String CITY = "city";
    private static final String PHONE = "phone";


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
            String username = request.getParameter(USERNAME);
            String password = request.getParameter(PASSWORD);
            String firstName = request.getParameter(FIRST_NAME);
            String secondName = request.getParameter(SECOND_NAME);
            String email = request.getParameter(EMAIL);
            String address = request.getParameter(ADDRESS);
            String city = request.getParameter(CITY);
            String phone = request.getParameter(PHONE);

            if (LoginService.getInstance().existUsername(username) == null) {
                UserImpl userImpl = new AbstractFactory().createUserDao();
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
                LOGGER.info("Was attempt to registr with exist username");
                request.setAttribute("existUsername",
                        MessageHelper.getInstance().getMessageException(MessageHelper.EXIST_USERNAME));
                page = PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.REGISTRATION_PAGE);
            }
//        }
        return page;
    }
}
