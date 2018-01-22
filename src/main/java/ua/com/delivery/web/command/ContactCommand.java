package ua.com.delivery.web.command;

import org.apache.log4j.Logger;
import ua.com.delivery.web.controller.utilController.PageConfiguration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContactCommand implements ICommand {
    private static final Logger LOGGER = Logger.getLogger(ContactCommand.class);

    /**
     * Method for forward on contact page
     *
     * @return page
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Was forward to contact page.");
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.CONTACT_PAGE);
    }
}
