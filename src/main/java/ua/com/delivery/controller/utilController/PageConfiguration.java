package ua.com.delivery.controller.utilController;

import java.util.ResourceBundle;

public class PageConfiguration {
    private static PageConfiguration INSTANCE;
    private static ResourceBundle resourceBundle;
    private static final String NAME_OF_BUNDLE = "pageConfiguration";

    public static final String ERROR_PAGE = "pageConfiguration.errorPage";
    public static final String LOGIN_PAGE = "pageConfiguration.loginPage";
    public static final String ADMIN_PAGE = "pageConfiguration.adminPage";
    public static final String DATE = "pageConfiguration.datePage";


    private PageConfiguration() {
        resourceBundle = ResourceBundle.getBundle(NAME_OF_BUNDLE);
    }

    public static PageConfiguration getInstance(){
        if (INSTANCE == null){
            synchronized (PageConfiguration.class){
                if (INSTANCE == null){
                    INSTANCE = new PageConfiguration();
                }
            }
        }
        return INSTANCE;
    }

    public String getPageConfiguration(String pageConfigurationMessage){
        return resourceBundle.getString(pageConfigurationMessage);
    }

}
