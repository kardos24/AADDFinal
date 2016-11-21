package beans;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import modelo.Usuario;
import controlador.Controlador;

public class RegistroUsuarioBean {
	private String nif;
	private String nombre;
	private String usuario;
	private String clave;
	private String clave2;
	private String email;
	private Date fechaNacimiento;

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
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void validarMail(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String mail = (String) value;
		if(!mail.contains("@")){
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error validando mail", "El mail debe contener @"));
		}
	}
	
	public String registrar(){
		if(!clave.equals(clave2)) return "error_registro"; 
		Usuario usu = Controlador.getInstance().registrar(nif, nombre, usuario, clave, email);
		if(usu == null) return "error_registro";
		return "exito";
	}

}
