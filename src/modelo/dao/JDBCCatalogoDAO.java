package modelo.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import modelo.Catalogo;
import modelo.Usuario;

public class JDBCCatalogoDAO implements CatalogoDAO {

	public JDBCCatalogoDAO(DataSource ds) {
	}

	@Override
	public Catalogo create(String nombre, Date fecha, String web, String url,
			Usuario usuario) {
		return null;
	}

	@Override
	public Catalogo findByNombre(String nombre) {
		return null;
	}

	@Override
	public List<Catalogo> findByUsuario(String usuario) {
		return null;
	}

}
