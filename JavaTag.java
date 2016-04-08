package testpack;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class JavaTag extends SimpleTagSupport {
	private String name;

	public void setName(String name) {
		try {
			this.name = name;
		} catch (NumberFormatException nfe) {
			this.name = "";
		}
	}

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		
		JspWriter out = getJspContext().getOut();
		out.println("<p>"+name+"</p>");
	}
}