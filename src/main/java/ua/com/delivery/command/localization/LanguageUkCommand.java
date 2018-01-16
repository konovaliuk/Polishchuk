package ua.com.delivery.command.localization;

import ua.com.delivery.command.ICommand;
import ua.com.delivery.controller.utilController.PageConfiguration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;
import java.util.Locale;

public class LanguageUkCommand implements ICommand {
    public static final Locale UKRAINIAN = new Locale("uk", "UA");
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession(false).setAttribute("user", null);
        Config.set(request.getSession(false), Config.FMT_LOCALE, UKRAINIAN);
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.MAIN_PAGE);
    }
}
