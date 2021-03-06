package ua.com.delivery.service;

import org.apache.log4j.Logger;

public class Validation {
    private static final Logger LOGGER = Logger.getLogger(Validation.class);
    private static Validation INSTANCE;
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    private static final String USERNAME_PATTERN = "^[a-zA-Z]{3,15}$";
    private static final String PHONE_PATTERN = "^\\+?([0-9]{3})\\)?[-. ]?([0-9]{4})[-. ]?([0-9]{5})$";

    /**
     * Singleton
     *
     * @return INSTANCE
     */
    public static Validation getInstance() {
        if (INSTANCE == null) {
            synchronized (Validation.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Validation();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Validate password with regular expression
     *
     * @param password for validation
     * @return true valid password, false invalid password
     */
    public boolean validPassword(String password) {
        boolean validationPassword;
        if (validationPassword = password.matches(PASSWORD_PATTERN)) {
            LOGGER.info("Password successful passed the validation");
        } else {
            LOGGER.info("Password wasn't passed the validation");
        }
        return validationPassword;
    }

    /**
     * Validate email with regular expression
     *
     * @param email for validation
     * @return true valid email, false invalid email
     */
    public boolean validEmail(String email) {
        boolean validationEmail;
        if (validationEmail = email.matches(EMAIL_PATTERN)) {
            LOGGER.info("Email successful passed the validation");
        } else {
            LOGGER.info("Email wasn't passed the validation");
        }
        return validationEmail;
    }

    /**
     * Validate username with regular expression
     *
     * @param username username for validation
     * @return true valid username, false invalid username
     */
    public boolean validUsername(String username) {
        boolean validationUsername;
        if (validationUsername = username.matches(USERNAME_PATTERN)) {
            LOGGER.info("Username successful passed the validation");
        } else {
            LOGGER.info("Username wasn't passed the validation");
        }
        return validationUsername;
    }

    /**
     * Validate Phone with regular expression
     *
     * @param phone for validation
     * @return true valid Phone, false invalid Phone
     */
    public boolean validPhone(String phone) {
        boolean validationPhone;
        if (validationPhone = phone.matches(PHONE_PATTERN)) {
            LOGGER.info("Phone successful passed the validation");
        } else {
            LOGGER.info("Phone wasn't passed the validation");
        }
        return validationPhone;
    }
}
