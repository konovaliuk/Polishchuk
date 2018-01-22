package ua.com.delivery.web.command;

import org.apache.log4j.Logger;
import ua.com.delivery.service.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationCommand implements ICommand {
    private static final Logger LOGGER = Logger.getLogger(RegistrationCommand.class);
    private static final String CITY = "city";
    private static final String EMAIL = "email";
    private static final String PHONE = "phone";
    private static final String ADDRESS = "address";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String FIRST_NAME = "firstName";
    private static final String SECOND_NAME = "secondName";


    /**
     * Method for registration (button submit)
     *
     * @param request
     * @param response
     * @return page
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter(USERNAME);
        String password = request.getParameter(PASSWORD);
        String firstName = request.getParameter(FIRST_NAME);
        String secondName = request.getParameter(SECOND_NAME);
        String email = request.getParameter(EMAIL);
        String address = request.getParameter(ADDRESS);
        String city = request.getParameter(CITY);
        String phone = request.getParameter(PHONE);
        LOGGER.info("Was successful registration on page");
        return RegistrationService.getInstance().registration(request, username, password, firstName, secondName,
                email, address, city, phone);
    }
}
