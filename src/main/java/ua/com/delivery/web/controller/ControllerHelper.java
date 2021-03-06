package ua.com.delivery.web.controller;

import org.apache.log4j.Logger;
import ua.com.delivery.web.command.*;
import ua.com.delivery.web.command.localization.LanguageEnCommand;
import ua.com.delivery.web.command.localization.LanguageUkCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ControllerHelper {
    private static final Logger LOGGER = Logger.getLogger(ControllerHelper.class);
    private Map<String, ICommand> commandMap = new HashMap<>();
    private static final String BUNDLE_NAME = "command";
    private static final String PARAMETER = "command";
    private static ControllerHelper instance;

    /**
     * Constructor in which filling the table with commands
     */
    private ControllerHelper() {
        ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);
        commandMap.put(bundle.getString("command.home"), new HomeCommand());
        commandMap.put(bundle.getString("command.order"), new OrderCommand());
        commandMap.put(bundle.getString("command.login"), new LoginCommand());
        commandMap.put(bundle.getString("command.logout"), new LogoutCommand());
        commandMap.put(bundle.getString("command.signIn"), new SignInCommand());
        commandMap.put(bundle.getString("command.payment"), new PaymentCommand());
        commandMap.put(bundle.getString("command.contact"), new ContactCommand());
        commandMap.put(bundle.getString("command.localeEn"), new LanguageEnCommand());
        commandMap.put(bundle.getString("command.localeUa"), new LanguageUkCommand());
        commandMap.put(bundle.getString("command.calculate"), new CalculateCommand());
        commandMap.put(bundle.getString("command.condition"), new ConditionCommand());
        commandMap.put(bundle.getString("command.forRegist"), new ForRegistrCommand());
        commandMap.put(bundle.getString("command.pagination"), new PaginationCommand());
        commandMap.put(bundle.getString("command.calculator"), new CalculatorCommand());
        commandMap.put(bundle.getString("command.missingCommand"), new MissingCommand());
        commandMap.put(bundle.getString("command.registration"), new RegistrationCommand());
        commandMap.put(bundle.getString("command.createOrderTo"), new CreateOrderToCommand());
        commandMap.put(bundle.getString("command.createOrderFrom"), new CreateOrderFromCommand());
    }

    /**
     * Method for getting command
     * extracting a command from a request
     * receiving an object corresponding the command
     * if command is missing = missingCommand
     *
     * @param request
     * @return page
     */
    public ICommand getCommand(HttpServletRequest request) {
        String parameter = request.getParameter("command");
        ICommand command = commandMap.get(parameter);
        if (command == null) {
            command = commandMap.get("missingCommand");
        }
        LOGGER.info("Was called command: " + command);
        return command;
    }

    /**
     * Singleton
     *
     * @return INSTANCE
     */
    public static ControllerHelper getInstance() {
        if (instance == null) {
            synchronized (ControllerHelper.class) {
                if (instance == null) {
                    instance = new ControllerHelper();
                }
            }
        }
        return instance;
    }

}