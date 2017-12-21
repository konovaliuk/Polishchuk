package ua.com.delivery.controller;

import org.apache.log4j.Logger;
import ua.com.delivery.command.ICommand;
import ua.com.delivery.controller.utilController.MessageException;
import ua.com.delivery.controller.utilController.PageConfiguration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Controller extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(Controller.class.getName());
    private static final String ENCODING = "UTF-8";
    private static final String CONTENT_TYPE = "text/html;charset=utf-8";
    private static final String MESSAGE_ERROR_ATTRIBUTE = "messageError";
    private static final String PAGE_IS_NULL = "Page is NULL";

    //controllerHelper - обєкт в якому лежить список моїх можливих команд
    ControllerHelper controllerHelper = ControllerHelper.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String page;
        try {
            HttpSession session = request.getSession(false);
            if (session == null) {
                session = request.getSession(true);
            }
            ICommand command = controllerHelper.getCommand(request);
            page = command.execute(request, response);
        } catch (ServletException e) {
            LOGGER.info(e.getMessage());
            request.setAttribute(MESSAGE_ERROR_ATTRIBUTE,
                    MessageException.getInstance().getMessageException(MessageException.SERVLET_EXCEPTION));
            page = PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.ERROR_PAGE);
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
            request.setAttribute(MESSAGE_ERROR_ATTRIBUTE,
                    MessageException.getInstance().getMessageException(MessageException.IO_EXCEPTION));
            page = PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.ERROR_PAGE);
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
            request.setAttribute(MESSAGE_ERROR_ATTRIBUTE,
                    MessageException.getInstance().getMessageException(MessageException.EXCEPTION));
            page = PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.ERROR_PAGE);
        }
        if (page == null) {
            LOGGER.info(PAGE_IS_NULL);
            request.setAttribute(MESSAGE_ERROR_ATTRIBUTE,
                    MessageException.getInstance().getMessageException(MessageException.PAGE_IS_NULL));
            page = PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.ERROR_PAGE);
        }

        response.setCharacterEncoding(ENCODING);
        response.setContentType(CONTENT_TYPE);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(page);
        requestDispatcher.forward(request, response);
    }
}



   /* IAbstractFactory factory = new AbstractFactory();
    CargoPriceImpl cargoPrice = factory.createCargoDao();
//        cargoPrice.createCargoPrice(new CargoPrice(11L, 5,8));
//        cargoPrice.deleteCargoPriceByWeight(5);

        request.getRequestDispatcher("WEB-INF/pages/loginPage.jsp").forward(request,response);
       *//* Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies) {
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());
        }
        Cookie cookie = new Cookie("testCookie", "valuecookie");
        //время жизни куки 5с
//        cookie.setMaxAge(5);

        //тільки по цій урлі буде працювати кукі
//        cookie.setPath("/someLink");

         //кукі будуть видні якщо тільки https зєднання
        cookie.setSecure(true);
        response.addCookie(cookie);*//*
//            request.getRequestDispatcher("WEB-INF/pages/registration.jsp").forward(request,response);*/