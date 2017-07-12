package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;
import javax.validation.constraints.Size;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.sun.istack.NotNull;

import controlador.Controlador;
import modelo.Usuario;

@ManagedBean(name = "BeanListarUsuarios")
@SessionScoped
public class BeanListarUsuarios implements Serializable {

	private static final long serialVersionUID = 10L;

	private String usuarioSeleccionado;
	private Usuario usuario;

	private String nif;
	private String nombre;
	private String login;
	private String clave;
	private String clave2;
	private String email;

	@PostConstruct
	public void init() {
		usuario = Controlador.getInstance().getUsuarioActivo();
		if (usuario != null) {
			usuarioSeleccionado = usuario.getNombre();
			nif = usuario.getNif();
			nombre = usuario.getNombre();
			login = usuario.getUsuario();
			clave = clave2 = usuario.getClave();
			email = usuario.getEmail();
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}

	public void setUsuarioSeleccionado(String usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getClave2() {
		return clave2;
	}

	public void setClave2(String clave2) {
		this.clave2 = clave2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void loadFile2(FileUploadEvent event) {
		Controlador.getInstance().loadFile(event.getFile());
	}

	public void validarMail(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String mail = (String) value;
		if(!mail.contains("@")){
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error validando mail", "El mail debe contener @"));
		}
	}

	public String vistaUsuario() {
		return "faceletsUsuario";
	}

}
