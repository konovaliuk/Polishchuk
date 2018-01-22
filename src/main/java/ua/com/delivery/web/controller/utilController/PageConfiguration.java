package ua.com.delivery.web.controller.utilController;

import java.util.ResourceBundle;

public class PageConfiguration {
    private static PageConfiguration INSTANCE;
    private static ResourceBundle resourceBundle;
    private static final String NAME_OF_BUNDLE = "pageConfiguration";

    public static final String MAIN_PAGE = "pageConfiguration.mainPage";
    public static final String ERROR_PAGE = "pageConfiguration.errorPage";
    public static final String LOGIN_PAGE = "pageConfiguration.loginPage";
    public static final String ORDER_PAGE = "pageConfiguration.orderPage";
    public static final String ADMIN_PAGE = "pageConfiguration.adminPage";
    public static final String CONTACT_PAGE = "pageConfiguration.contactPage";
    public static final String PAYMENT_PAGE = "pageConfiguration.paymentPage";
    public static final String CONDITION_PAGE = "pageConfiguration.conditionPage";
    public static final String CALCULATOR_PAGE = "pageConfiguration.calculatorPage";
    public static final String REGISTRATION_PAGE = "pageConfiguration.registrationPage";

    private PageConfiguration() {
        resourceBundle = ResourceBundle.getBundle(NAME_OF_BUNDLE);
    }

    public static PageConfiguration getInstance() {
        if (INSTANCE == null) {
            synchronized (PageConfiguration.class) {
                if (INSTANCE == null) {
                    INSTANCE = new PageConfiguration();
                }
            }
        }
        return INSTANCE;
    }

    public String getPageConfiguration(String pageConfigurationMessage) {
        return resourceBundle.getString(pageConfigurationMessage);
    }
}