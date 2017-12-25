package ua.com.delivery.controller;

import ua.com.delivery.command.*;
import ua.com.delivery.command.locale.LanguageEnCommand;
import ua.com.delivery.command.locale.LanguageUkCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ControllerHelper {
    private Map<String, ICommand> commandMap = new HashMap<>();
    private static final String BUNDLE_NAME = "command";
    private static ControllerHelper instance;

    private ControllerHelper(){
        ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);
        commandMap.put(bundle.getString("command.login"), new LoginCommand());
        commandMap.put(bundle.getString("command.registration"), new RegistrationCommand());
        commandMap.put(bundle.getString("command.logout"), new LogoutCommand());

        commandMap.put(bundle.getString("command.languageEN"), new LanguageEnCommand());
        commandMap.put(bundle.getString("command.languageUK"), new LanguageUkCommand());
    }

    public static ControllerHelper getInstance(){
        if (instance == null){
            synchronized (ControllerHelper.class){
                if (instance == null){
                    instance = new ControllerHelper();
                }
            }
        }
        return instance;
    }

    public ICommand getCommand(HttpServletRequest request){
        String commandString = request.getParameter("command");
        ICommand command = commandMap.get(commandString);
        if (command == null){
            command = new MissingCommand();
        }
        return command;
    }

}
