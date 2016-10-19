package modelo.dao;

import modelo.Catalogo;
import modelo.Usuario;

public interface UsuarioDAO {
	Usuario create(String nif, String nombre, String usuario, String clave,	String email) throws DAOException;
	
	Usuario addCatalogo(Usuario usuario, Catalogo catalogo) throws DAOException;
	
	Usuario findByUsuario(String usuario) throws DAOException;
}
