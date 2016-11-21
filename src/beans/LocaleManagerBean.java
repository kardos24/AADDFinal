package beans;

import java.util.Locale;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputFormat;
import javax.faces.context.FacesContext;

import com.sun.org.apache.xerces.internal.util.HTTPInputSource;

public class LocaleManagerBean {
	private Locale locale;
	private String language;
	private HtmlOutputFormat htmlOutputText;

	public LocaleManagerBean() {
		locale = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestLocale();
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
		locale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}

	public HtmlOutputFormat getHtmlOutputText() {
		return htmlOutputText;
	}

	public void setHtmlOutputText(HtmlOutputFormat htmlOutputText) {
		this.htmlOutputText = htmlOutputText;
	}
	

}
