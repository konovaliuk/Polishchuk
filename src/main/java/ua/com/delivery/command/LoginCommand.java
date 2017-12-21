package ua.com.delivery.command;

import ua.com.delivery.persistence.entity.User;
import ua.com.delivery.service.LoginService;

import javax.security.auth.login.Configuration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ua.com.delivery.command.UtilForCommand.ERROR_MESSAGE;

public class LoginCommand implements ICommand{
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        //trim - delete all space at the start/end of the string
        String username = request.getParameter(USERNAME).trim();
        String password = request.getParameter(PASSWORD).trim();

        User user = LoginService.getInstance(). existUsername(username);

        if (user == null){
            page = redirectOnErrorPage(request);
        }
        return null;
    }

    private String redirectOnErrorPage(HttpServletRequest request){
        request.setAttribute(ERROR_MESSAGE, true);
    }
}
