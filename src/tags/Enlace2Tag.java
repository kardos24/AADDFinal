package tags;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Enlace2Tag extends SimpleTagSupport {
	private String url;
	private String texto;

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		PageContext pageContext = (PageContext) getJspContext();
		JspFragment body = getJspBody();
		if (body != null) {
			out.println("<p>");
			body.invoke(null);
			out.println("</p>");
		}
		try {
			HttpServletResponse respuesta = (HttpServletResponse) pageContext
					.getResponse();
			pageContext.getOut().write(
					"<a href=\"" + respuesta.encodeURL(url) + "\">" + texto
							+ "</a>");
		} catch (java.io.IOException e) {
			throw new JspTagException(e.getMessage());
		}
	}
}
