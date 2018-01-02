package ua.com.delivery.controller;

import org.apache.log4j.Logger;
import ua.com.delivery.command.*;
import ua.com.delivery.command.locale.LanguageEnCommand;
import ua.com.delivery.command.locale.LanguageUkCommand;

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

    private ControllerHelper(){
        ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);
//        //заполнение таблицы командами
        commandMap.put(bundle.getString("command.home"), new HomeCommand());
        commandMap.put(bundle.getString("command.login"), new LoginCommand());
        commandMap.put(bundle.getString("command.logout"), new LogoutCommand());
        commandMap.put(bundle.getString("command.registration"), new RegistrationCommand());
//
        /* Locale commands */
        commandMap.put(bundle.getString("command.localeEn"), new LanguageEnCommand());
        commandMap.put(bundle.getString("command.localeUa"), new LanguageUkCommand());

        commandMap.put("command.missingCommand", new MissingCommand());

    }

    public ICommand getCommand(HttpServletRequest request){
        //извлечение команды из запроса
        //получение объекта, соответствующего команде
        ICommand command = commandMap.get(request.getParameter(PARAMETER));
        if (command == null ){
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