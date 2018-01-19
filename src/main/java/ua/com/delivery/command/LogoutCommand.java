package ua.com.delivery.command;

import org.apache.log4j.Logger;
import ua.com.delivery.controller.utilController.PageConfiguration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutCommand implements ICommand {
    private static final Logger LOGGER = Logger.getLogger(LogoutCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        LOGGER.info("Was destroyed session: " + session.getId());
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.MAIN_PAGE);
    }
}
