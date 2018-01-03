package ua.com.delivery.command;

import ua.com.delivery.controller.utilController.PageConfiguration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.LOGIN_PAGE);
    }
}
