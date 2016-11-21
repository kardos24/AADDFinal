package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.event.ActionEvent;

import controlador.Controlador;
import modelo.Usuario;

@ManagedBean(name="listarUsuariosBean")
@SessionScoped
public class listarUsuariosBean {

	private List<Usuario> usuarios;
	private String usuarioSeleccionado;

	public List<Usuario> getUsuarios() {
		usuarios = Controlador.getInstance().recuperarUsuarios();
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public String getUsuarioSeleccionado() {
		
		return usuarioSeleccionado;
	}

	public void setUsuarioSeleccionado(String usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}

	public void seleccionarUsuarios(ActionEvent evento){
		HtmlCommandButton bottom = (HtmlCommandButton) evento.getComponent();
		UIParameter parametro = (UIParameter) bottom.findComponent("id_usuario");
		usuarioSeleccionado = (String) parametro.getValue();
	}

}
