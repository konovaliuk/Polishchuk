package ua.com.delivery.command.utilCommand;

import java.util.Locale;
import java.util.ResourceBundle;

public class UtilForCommand {

//    private static final String ERROR = "error";
    public static final String ERROR_MESSAGE = "errorMessage";
    public static final String USER = "user";
    public static final String USERS = "users";
//    static final String USERNAME = "username";


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
}
