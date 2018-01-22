package ua.com.delivery.web.command;

import org.apache.log4j.Logger;
import ua.com.delivery.web.controller.utilController.PageConfiguration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ForRegistrCommand implements ICommand {
    private static final Logger LOGGER = Logger.getLogger(ForRegistrCommand.class);

    /**
     * Method for forward on registration page
     *
     * @param request
     * @param response
     * @return page
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.REGISTRATION_PAGE);
    }
}
