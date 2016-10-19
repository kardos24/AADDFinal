package modelo.dao;

import java.util.Date;

import javax.sql.DataSource;

import modelo.Catalogo;
import modelo.Usuario;

public class JDBCCatalogoDAO implements CatalogoDAO {

	public JDBCCatalogoDAO(DataSource ds) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Catalogo create(String nombre, Date fecha, String web, String url,
			Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Catalogo findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
