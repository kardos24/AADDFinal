package modelo.dao;

import modelo.Catalogo;
import modelo.Usuario;

public interface UsuarioDAO {
	Usuario create(String nif, String nombre, String usuario, String clave,	String email) throws DAOException;
	
	void update(Usuario usuario) throws DAOException;
	
	Usuario findByUsuario(String usuario) throws DAOException;
}
