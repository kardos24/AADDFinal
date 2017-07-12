package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import controlador.Controlador;

@ManagedBean(name = "beanLogin2")
@SessionScoped
public class BeanLogin2  implements Serializable {
	
	private static final long serialVersionUID = 40L;
	
	private String usuario;
	private String clave;

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getClave() {
		return clave;
	}

	public String login() {
		try {
			if (Controlador.getInstance().login(usuario, clave)) {
				Controlador.getInstance().setUsuarioActivo(usuario);
				return "faceletsWelcome";
			} else {
				setClave(new String());
				return "faceletsLogin";
			}
		} catch (Exception e) {
			setClave(new String());
			return "faceletsLogin";
		}
	}
	
	public String logout(){
		Controlador.getInstance().logout();
		return "faceletsLogin";
	}
	
	public String goHome(){
		return "faceletsWelcome";
	}
	
	public String goRegistro(){
		return "faceletsRegistro";
	}
}