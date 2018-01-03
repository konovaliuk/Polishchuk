package ua.com.delivery.command;

import ua.com.delivery.controller.utilController.PageConfiguration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MissingCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        /*в случае прямого обращения к контроллеру переадресация на страницу ввода логина*/

        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.ERROR_PAGE);
    }
}
