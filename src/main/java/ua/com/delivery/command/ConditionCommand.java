package ua.com.delivery.command;

import ua.com.delivery.controller.utilController.PageConfiguration;
import ua.com.delivery.service.DirectionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ConditionCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer countRecord = DirectionService.getInstance().countDirectionRecords();
        request.getSession().setAttribute("countRecord", countRecord);
//        String url = request.getParameter("command");
//        System.out.println(url);
//        System.out.println("-----------");
//        String newPag = PageConfiguration.getInstance().createPathForLang(url);
//        System.out.println(PageConfiguration.getInstance().createPathForLang(url));
        return PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.CONDITION_PAGE);
//        return newPag;
    }
}
