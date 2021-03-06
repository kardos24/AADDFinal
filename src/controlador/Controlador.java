package controlador;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import modelo.Catalogo;
import modelo.Categoria;
import modelo.Usuario;
import modelo.VideojuegoItem;
import modelo.dao.CategoriaDAO;
import modelo.dao.DAOException;
import modelo.dao.DAOFactoria;
import modelo.dao.UsuarioDAO;
import modelo.dao.VideojuegoItemDAO;

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

	public List<Catalogo> recuperarCatalogosPorUsuario(String usuario) {
		UsuarioDAO usuarioDAO = factoria.getUsuarioDAO();
		Usuario usu;
		try {
			usu = usuarioDAO.findByUsuario(usuario);
			return usu.getCatalogos();
		} catch (DAOException e) {
			return new LinkedList<Catalogo>();
		}
		
//		
//		CatalogoDAO catalogoDAO = factoria.getCatalogoDAO();
//		List<Catalogo> lista = catalogoDAO.findByUsuario(usuario);
//		return lista;
	}

	public List<Usuario> recuperarUsuarios() {
		UsuarioDAO usuarioDao = factoria.getUsuarioDAO();
		try {
			return usuarioDao.findAll();
		} catch (DAOException e) {
			return new LinkedList<Usuario>();
		}
	}

	public Categoria registrarCategoria(String nombreCategoria) {
		CategoriaDAO categoriaDAO = factoria.getCategoriaDAO();
		try {
			return categoriaDAO.create(nombreCategoria);
		} catch (DAOException e) {
			return null;
		}
		
	}

	public List<Categoria> recuperarCategorias() {
		CategoriaDAO categoriaDao = factoria.getCategoriaDAO();
		try {
			return categoriaDao.findAll();
		} catch (DAOException e) {
			return new LinkedList<Categoria>();
		}
	}

	public VideojuegoItem registrarJuego(VideojuegoItem juego) {
		return registrarJuego(juego.getNombre(), juego.getGeneroPrincipal(), juego.getGeneroSecundario(), juego.getGeneroOtros(), juego.getDescripcion(), juego.getNota(), juego.getFechaLanzamiento(), juego.getUrlFoto(), juego.getUrlFicha(), juego.getPlataformas());		
	}

	public VideojuegoItem registrarJuego(String nombre, String genero1, String genero2, String genero3, String descripcion, String nota, Date fechaLanzamiento, String urlFoto, String urlFicha, List<Categoria> plataformas) {
		VideojuegoItemDAO videojuegoItemDAO = factoria.getVideojuegoItemDAO();
		try {
			return videojuegoItemDAO.create(nombre, genero1, genero2, genero3, descripcion, nota, fechaLanzamiento, urlFoto, urlFicha, plataformas);
		} catch (DAOException e) {
			return null;
		}
		
	}



}
