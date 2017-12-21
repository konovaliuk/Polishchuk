package ua.com.delivery.controller.utilController;

import java.util.ResourceBundle;

public class MessageException {
    private static MessageException INSTANCE;
    private static ResourceBundle resourceBundle;
    private static final String NAME_OF_BUNDLE = "messageException";

    public static final String PAGE_IS_NULL = "messageException.pageIsNull";
    public static final String SERVLET_EXCEPTION = "messageException.servlet";
    public static final String IO_EXCEPTION = "messageException.io";
    public static final String EXCEPTION = "messageException.exception";

    private MessageException() {
        //сукупність ресурсів
        resourceBundle = ResourceBundle.getBundle(NAME_OF_BUNDLE);
    }
    public static MessageException getInstance(){
        if (INSTANCE == null){
            synchronized (MessageException.class){
                if (INSTANCE == null){
                    INSTANCE = new MessageException();
                }
            }
        }
        return INSTANCE;
    }

    public String getMessageException(String messageException){
        return resourceBundle.getString(messageException);
    }
}
