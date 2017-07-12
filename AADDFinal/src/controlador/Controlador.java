package controlador;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.primefaces.model.UploadedFile;

import modelo.Catalogo;
import modelo.Categoria;
import modelo.Usuario;
import modelo.VideojuegoItem;
import utils.ProgramaImportacionDatos;

public class Controlador {

	private static Controlador unicaInstancia = null;
	private ControladorEJBRemote controlador;
	
	private Controlador() {
		try {
			controlador = (ControladorEJBRemote) new InitialContext().lookup("java:global/EJBTest/ControladorEJB");
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

	public Usuario registrarUsuario(String nif, String nombre, String usuario,
			String clave, String email) {
		return controlador.registrar(nif, nombre, usuario, clave, email);
		
	}
	
	public void addCatalogo(Usuario usuario, Catalogo catalogo){
		controlador.addCatalogo(usuario, catalogo);
	
	}

	public List<Catalogo> recuperarCatalogosPorUsuario(String usuario) {
		return controlador.recuperarCatalogosPorUsuario(usuario);
	}

	public List<Usuario> recuperarUsuarios() {
		return controlador.recuperarUsuarios();
	}

	public List<Catalogo> recuperarCatalogosUsuarioActivo(){
		return controlador.recuperarCatalogosUsuarioActivo();
	}
	
	public Categoria registrarCategoria(String nombreCategoria) {
		return controlador.registrarCategoria(nombreCategoria);
	}

	public List<Categoria> getCategorias() {
		return controlador.getCategorias();
	}

	public void registrarJuego(VideojuegoItem juego) {
		List<String> plataformas = juego.getPlataformas().stream().map(Categoria::getNombre).collect(Collectors.toList());
		controlador.registrarJuego(juego.getNombre(), juego.getGeneroPrincipal(), juego.getGeneroSecundario(), juego.getGeneroOtros(),
				juego.getDescripcion(), juego.getNota(), juego.getFechaLanzamiento(), juego.getUrlFoto(), juego.getUrlFicha(), plataformas);
		
	}

	public void registrarCatalogo(String nombreCatalogo, String[] selectedCategorys) {
		controlador.registrarCatalogo(nombreCatalogo, selectedCategorys);
		
	}

	public void loadFile(UploadedFile file) {
		try {
			System.out.println("iniciado load file");
			ProgramaImportacionDatos.loadFile(file.getInputstream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void logout() {
		controlador.logout();		
	}

	public void establecerCategoriasCatalogo(String[] selectedCategorys) {
		controlador.establecerCategoriasCatalogo(selectedCategorys);
		
	}

	public void setCatalogoActivo(String nombreCat) {
		controlador.setCatalogoActivo(nombreCat);
		
	}

	public void eliminarCatalogo(String nombreCat) {
		controlador.eliminarCatalogo(nombreCat);
		
	}

	public void setUsuarioActivo(String usuario) {
		controlador.setUsuarioActivo(usuario);
	}

	public Usuario getUsuarioActivo() {
		return controlador.getUsuarioActivo();
	}

	public Catalogo getCatalogo(String nombreCatalogo) {
		return controlador.getCatalogo(nombreCatalogo);
	}

	public void setJuegoActivo(String idJuego) {
		controlador.setJuegoActivo(idJuego);
	}

	public VideojuegoItem getJuego(String idJuego) {
		return controlador.getJuego(idJuego);
	}

	public void eliminarJuego(String idJuego) {
		controlador.eliminarJuego(idJuego);
	}



}
