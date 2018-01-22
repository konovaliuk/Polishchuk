package ua.com.delivery.web.command;

import org.apache.log4j.Logger;
import ua.com.delivery.web.controller.utilController.MessageHelper;
import ua.com.delivery.persistence.entity.User;
import ua.com.delivery.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements ICommand {
    private static final Logger LOGGER = Logger.getLogger(LoginCommand.class);
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";


    /**
     * Method for forward on login page
     * he helps to sign in
     *
     * @param request
     * @param response
     * @return page
     */
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
}
