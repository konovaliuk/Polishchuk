package ua.com.delivery.command;

import org.apache.log4j.Logger;
import ua.com.delivery.controller.utilController.MessageHelper;
import ua.com.delivery.persistence.entity.User;
import ua.com.delivery.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements ICommand {
    private static final Logger LOGGER = Logger.getLogger(LoginCommand.class);
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        //извлечение из запроса логина и пароля
        String username = request.getParameter(USERNAME);
        String password = request.getParameter(PASSWORD);

        User user = LoginService.getInstance().existUsername(username);
        if (user == null) {
            page = LoginService.getInstance().redirectOnErrorPage(request);
            request.setAttribute("wrongUsername",
                    MessageHelper.getInstance().getMessageException(MessageHelper.WRONG_USERNAME));
            LOGGER.info("Was trying to sign in with wrong username");
        } else {
            page = LoginService.getInstance().checkUserPassword(request, user, password);
        }
        return page;
    }

//    private String checkUserPassword(HttpServletRequest request, User user, String password) {
//        String page;
//        if (LoginService.getInstance().checkPasswordForUsername(user, password)) {
//            page = checkIfAdmin(user, request);
//        } else {
//
//            page = redirectOnErrorPage(request);
//        }
//        return page;
//
//    }

//    private String checkIfAdmin(User user, HttpServletRequest request) {
//        String page;
//        if (user.getAdmin()) {
//            page = redirectOnAdminPage(user, request);
//        } else {
//            page = redirectOnUserPage(user, request);
//        }
//        return page;
//    }

//    private String redirectOnAdminPage(User user, HttpServletRequest request) {
//        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.ADMIN_PAGE);
//    }

//    private String redirectOnUserPage(User user, HttpServletRequest request) {
//        request.getSession().setAttribute("visibleOrder", true);
//        request.getSession().setAttribute("visibleLogout", true);
//        request.getSession().setAttribute("visibleUser", user.getUsername());
//        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.MAIN_PAGE);
//    }
//
//
//    private String redirectOnErrorPage(HttpServletRequest request) {
////        перенапралвення на логін пейдж, якщоне правильно ввів логін
//        request.setAttribute("wrongPassword",
//                MessageHelper.getInstance().getMessageException(MessageHelper.WRONG_PASSWORD));
//        LOGGER.info("User wrote a wrong password");
//        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.LOGIN_PAGE);
//    }

}
