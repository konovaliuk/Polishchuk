package ua.com.delivery.web.controller;

import org.apache.log4j.Logger;
import ua.com.delivery.web.command.ICommand;
import ua.com.delivery.web.controller.utilController.MessageHelper;
import ua.com.delivery.web.controller.utilController.PageConfiguration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Controller extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(Controller.class.getName());
    private static final String ENCODING = "UTF-8";
    private static final String CONTENT_TYPE = "text/html;charset=utf-8";

    //controllerHelper - обєкт в якому лежить список моїх можливих команд
    private ControllerHelper controllerHelper = ControllerHelper.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Definition command which went from jsp
     * call the implemented  execute() method of the ICommand interface and pass parameters
     * the class-processor of a specific command
     *
     * @return page
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String page;
        try {
            ICommand command = controllerHelper.getCommand(request);
            page = command.execute(request, response);
        } catch (ServletException e) {
            request.setAttribute("servletException",
                    MessageHelper.getInstance().getMessageException(MessageHelper.SERVLET_EXCEPTION));
            //call jsp-page with error message
            LOGGER.error("Exception in controller (Servlet Exception)");
            page = PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.ERROR_PAGE);
        } catch (IOException e) {
            request.setAttribute("IOException",
                    MessageHelper.getInstance().getMessageException(MessageHelper.IO_EXCEPTION));
            LOGGER.error("Exception in controller (IOException)");
            page = PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.ERROR_PAGE);
        } catch (Exception e) {
            request.setAttribute("exception",
                    MessageHelper.getInstance().getMessageException(MessageHelper.EXCEPTION));
            LOGGER.error("Exception in controller");
            page = PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.ERROR_PAGE);
        }
        if (page == null) {
            request.setAttribute("nullPage",
                    MessageHelper.getInstance().getMessageException(MessageHelper.PAGE_IS_NULL));
            LOGGER.error("Problem in controller. Page is null");
            page = PageConfiguration.getInstance().getPageConfiguration(PageConfiguration.ERROR_PAGE);
        }

        response.setCharacterEncoding(ENCODING);
        response.setContentType(CONTENT_TYPE);
        //call page response on request
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(page);
        LOGGER.info("Forward to: " + page);
        requestDispatcher.forward(request, response);
    }
}


