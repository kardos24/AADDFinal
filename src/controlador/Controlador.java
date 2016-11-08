package controlador;

import java.util.Objects;

import modelo.Catalogo;
import modelo.Usuario;
import modelo.dao.DAOException;
import modelo.dao.DAOFactoria;
import modelo.dao.UsuarioDAO;

public class Controlador {

	private static Controlador unicaInstancia = null;
	private DAOFactoria factoria;

	private Controlador() {
		try {
			factoria = DAOFactoria.getDAOFactoria(DAOFactoria.JPA);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	public static Controlador getInstance() {
		if (unicaInstancia == null) {
			unicaInstancia = new Controlador();
		}
		return unicaInstancia;
	}

	public boolean login(String usuario, String clave) {
		UsuarioDAO usuarioDAO;
		try {
			usuarioDAO = factoria.getUsuarioDAO();
			Usuario usu = usuarioDAO.findByUsuario(usuario);
			if (usu == null)
				return false;
			return Objects.equals(usu.getClave(), clave);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Usuario registrar(String nif, String nombre, String usuario,
			String clave, String email) {
		UsuarioDAO usuarioDAO;
		try {
			usuarioDAO = factoria.getUsuarioDAO();
			return usuarioDAO.create(nif, nombre, usuario, clave, email);
		} catch (DAOException e) {
			return null;
		}
		
	}
	
	public void addCatalogo(Usuario usuario, Catalogo catalogo){

		usuario.getCatalogos().add(catalogo);
		try {
			factoria.getUsuarioDAO().update(usuario);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

}
