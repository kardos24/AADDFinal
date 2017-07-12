package beans;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import modelo.Usuario;
import controlador.Controlador;

@ManagedBean(name = "BeanRegistrar2")
@SessionScoped
public class BeanRegistrar2 implements Serializable {
	
	private static final long serialVersionUID = 50L;
	
	private String nif;
	@NotNull
	@Size(min = 6, max = 25)
	private String nombre;
	@NotNull
	@Size(min = 4, max = 10)
	private String usuario;
	private String clave;
	private String clave2;
	private String email;

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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave2() {
		return clave2;
	}

	public void setClave2(String clave2) {
		this.clave2 = clave2;
	}

	public void validarMail(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String mail = (String) value;
		if(!mail.contains("@")){
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error validando mail", "El mail debe contener @"));
		}
	}
	
	public String registrar(){
		if(!clave.equals(clave2)) return "faceletsRegistro"; 
		Usuario usu = Controlador.getInstance().registrarUsuario(nif, nombre, usuario, clave, email);
		if(usu == null) return "faceletsRegistro";
		return "faceletsWelcome";
	}
	
	public String goLogin(){
		return "faceletsLogin";
	}

}
