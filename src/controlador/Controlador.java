package controlador;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import modelo.Catalogo;
import modelo.Categoria;
import modelo.Usuario;
import modelo.dao.CategoriaDAO;
import modelo.dao.DAOException;
import modelo.dao.DAOFactoria;
import modelo.dao.UsuarioDAO;

public class Controlador {

	private static Controlador unicaInstancia = null;
	private ControladorEJBRemote controlador;
	
	private Controlador() {
		try {
			controlador = (ControladorEJBRemote) new InitialContext().lookup("java:global/PracticaAADDFinal_EJB/ControladorEJB");
		} catch (NamingException e) {
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
		return controlador.login(usuario, clave);
	}

	public Usuario registrar(String nif, String nombre, String usuario,
			String clave, String email) {
		return controlador.registrar(nif, nombre, usuario, clave, email);
		
	}
	
	public void addCatalogo(Usuario usuario, Catalogo catalogo){

	
	}

	public List<Catalogo> recuperarCatalogosPorUsuario(String usuario) {
		return null;
		
//		
//		CatalogoDAO catalogoDAO = factoria.getCatalogoDAO();
//		List<Catalogo> lista = catalogoDAO.findByUsuario(usuario);
//		return lista;
	}

	public List<Usuario> recuperarUsuarios() {
		return null;
	}

	public Categoria registrarCategoria(String nombreCategoria) {
		return null;
	}

	public List<Categoria> recuperarCategorias() {
		return null;
	}



}
