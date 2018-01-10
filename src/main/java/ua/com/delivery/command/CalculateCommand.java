package ua.com.delivery.command;

import ua.com.delivery.controller.utilController.PageConfiguration;
import ua.com.delivery.service.DirectionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalculateCommand implements ICommand {
    private static final String FROM_CITY = "from_city";
    private static final String TO_CITY = "to_city";
    private static final String WEIGHT = "weight";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fromCity = request.getParameter(FROM_CITY);
        String toCity = request.getParameter(TO_CITY);
        int weight = Integer.parseInt(request.getParameter(WEIGHT));

        Integer price = DirectionService.getInstance().priceForCity(fromCity, toCity, weight);
        request.setAttribute("priceFromToCity", price);
        request.setAttribute("w", weight);
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.CALCULATOR_PAGE);
    }
}
