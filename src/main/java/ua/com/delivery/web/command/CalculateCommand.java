package ua.com.delivery.web.command;

import org.apache.log4j.Logger;
import ua.com.delivery.service.CalculateService;
import ua.com.delivery.web.controller.utilController.PageConfiguration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalculateCommand implements ICommand {
    private static final Logger LOGGER = Logger.getLogger(CalculateCommand.class);
    private static final String FROM_CITY = "from_city";
    private static final String TO_CITY = "to_city";
    private static final String WEIGHT = "weight";
    private static final String DECLARED_PRICE = "declaredPrice";

    /**
     * Method for calculate price of delivery
     *
     * @return page
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fromCity = request.getParameter(FROM_CITY);
        String toCity = request.getParameter(TO_CITY);
        int weight = Integer.parseInt(request.getParameter(WEIGHT));
        int declaredPrice = Integer.parseInt(request.getParameter(DECLARED_PRICE));

        CalculateService.getInstance().calculatePrice(request, fromCity, toCity, weight, declaredPrice);
        LOGGER.info("Was calculating price of delivery.");
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.CALCULATOR_PAGE);
    }
}
