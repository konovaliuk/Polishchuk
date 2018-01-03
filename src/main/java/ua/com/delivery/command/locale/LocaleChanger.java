package ua.com.delivery.command.locale;

import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Locale;

public class LocaleChanger implements Serializable {
    private Locale currentLocale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    public LocaleChanger(){

    }

    public void changeLocale(String localeCode){
        currentLocale = new Locale(localeCode);
    }

    public Locale getCurrentLocale(){
        return currentLocale;
    }
}
