package ua.com.delivery.controller.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.ResourceBundle;

public class TagForName extends TagSupport {
    private ResourceBundle bundle = ResourceBundle.getBundle("tagResources");
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().write("hello " +  name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
