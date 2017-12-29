package ua.com.delivery.command.utilCommand;

import java.util.Locale;
import java.util.ResourceBundle;

public class UtilForCommand {

//    private static final String ERROR = "error";
    public static final String ERROR_MESSAGE = "errorMessage";
    private static final String BUNDLE_NAME = "language";
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);

    public static final Locale ENGLISH = Locale.ENGLISH;
    public static final Locale UKRAINIAN = new Locale("uk", "UA");

    public static void setLocale(Locale locale){
        resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
    }

    public static void setDefaultLocale() {
        setLocale(Locale.getDefault());
    }
//    public static String error(HttpServletRequest request, String message, String redirectPage){
//        request.setAttribute(ERROR, UtilForCommand.getProperty(message));
//        return PageConfiguration.getInstance().getPageConfiguration(redirectPage);
//    }
//
//    private static String getProperty(String message){
//        return (String) resourceBundle.getObject(message);
//    }
}