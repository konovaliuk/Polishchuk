package ua.com.delivery.controller;

import org.apache.log4j.Logger;
import ua.com.delivery.command.*;
import ua.com.delivery.command.locale.SetLocaleEnCommand;
import ua.com.delivery.command.locale.SetLocaleUaCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ControllerHelper {
    private static final Logger LOGGER = Logger.getLogger(ControllerHelper.class);
    private Map<String, ICommand> commandMap = new HashMap<>();
//    private static final String BUNDLE_NAME = "command";
    private static final String PARAMETER = "command";
    private static ControllerHelper instance;

    private ControllerHelper(){
//        ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);
//        //заполнение таблицы командами
//        commandMap.put(bundle.getString("command.home"), new HomeCommand());
//        commandMap.put(bundle.getString("command.login"), new LoginCommand());
//        commandMap.put(bundle.getString("command.logout"), new LogoutCommand());
//        commandMap.put(bundle.getString("command.registration"), new RegistrationCommand());
//
//        commandMap.put(bundle.getString("command.en"), new LanguageEnCommand());
//        commandMap.put(bundle.getString("command.ukr"), new LanguageUkCommand());
        commandMap.put("missingCommand", new MissingCommand());

        commandMap.put("home", new HomeCommand());
        commandMap.put("login", new LoginCommand());
        commandMap.put("logout", new LogoutCommand());
        commandMap.put("registration", new RegistrationCommand());

        /* Locale commands */
        commandMap.put("localeUa", new SetLocaleUaCommand());
        commandMap.put("localeEn", new SetLocaleEnCommand());
    }

    public ICommand getCommand(HttpServletRequest request){
//        String commandString = request.getParameter(PARAMETER);
        //извлечение команды из запроса
        //получение объекта, соответствующего команде
        ICommand command = commandMap.get(request.getParameter(PARAMETER));
        if (command == null || request.getSession(false) == null){
            //якщо команди немає, то переходить на missing
            command = commandMap.get("missingCommand");
        }
        LOGGER.info("Was called command: " + command);
        return command;
    }

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