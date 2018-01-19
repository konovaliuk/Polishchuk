package ua.com.delivery.command;

import ua.com.delivery.controller.utilController.PageConfiguration;
import ua.com.delivery.persistence.entity.Direction;
import ua.com.delivery.service.DirectionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Direction> directionList = DirectionService.getInstance().searchFromToCity();
        request.getSession().setAttribute("cityFromTo", directionList);
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.ORDER_PAGE);
    }
}
