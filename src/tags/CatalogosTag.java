package tags;

import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import modelo.Catalogo;

public class CatalogosTag extends BodyTagSupport {

	private List<Catalogo> lista;
	private Iterator it;

	public void setLista(List<Catalogo> lista) {
		this.lista = lista;
	}

	public int doStartTag() throws JspTagException {
		it = lista.iterator();
		Catalogo c = (Catalogo) it.next();
		if (c == null)
			return SKIP_BODY;
		else {
			pageContext.setAttribute("nombre", c.getNombre());
			pageContext.setAttribute("web", c.getWeb());
			return EVAL_BODY_TAG;
		}
	}

	public int doAfterBody() throws JspTagException {
		BodyContent bodyContent = getBodyContent();
		if (bodyContent != null) {
			try {
				// Obtiene la evalución del cuerpo y
				// lo escribe por la salida
				bodyContent.getEnclosingWriter().print(bodyContent.getString());
				// Vacía el cuerpo para la siguiente iteración
				bodyContent.clearBody();
			} catch (Exception e) {
				throw new JspTagException(e.getMessage());
			}
		}
			// Comprobamos si seguimos iterando
		if (it.hasNext()) {
			Catalogo c = (Catalogo) it.next();
			pageContext.setAttribute("nombre", c.getNombre());
			pageContext.setAttribute("web", c.getWeb());
			return EVAL_BODY_TAG;
		} else
			return SKIP_BODY;
	}

}
