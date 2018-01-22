package ua.com.delivery.web.controller.utilController;

import java.util.ResourceBundle;

public class MessageHelper {
    private static MessageHelper INSTANCE;
    private static ResourceBundle resourceBundle;


    public static final String IO_EXCEPTION = "messageHelper.io";
    public static final String EXCEPTION = "messageHelper.exception";
    public static final String USER_CREATE = "messageHelper.userCreate";
    public static final String PAGE_IS_NULL = "messageHelper.pageIsNull";
    public static final String SERVLET_EXCEPTION = "messageHelper.servlet";
    public static final String WRONG_USERNAME = "messageHelper.wrongUsername";
    public static final String WRONG_PASSWORD = "messageHelper.wrongPassword";
    public static final String EXIST_USERNAME = "messageHelper.existUsername";


    private MessageHelper() {
        //сукупність ресурсів
        resourceBundle = ResourceBundle.getBundle("language");
    }

    public static MessageHelper getInstance() {
        if (INSTANCE == null) {
            synchronized (MessageHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MessageHelper();
                }
            }
        }
        return INSTANCE;
    }

    public String getMessageException(String messageException) {
        return resourceBundle.getString(messageException);
    }
}
