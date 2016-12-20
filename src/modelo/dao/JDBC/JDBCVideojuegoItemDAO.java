package modelo.dao.JDBC;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import modelo.Categoria;
import modelo.VideojuegoItem;
import modelo.dao.VideojuegoItemDAO;

public class JDBCVideojuegoItemDAO implements VideojuegoItemDAO {

	private DataSource ds;

	public JDBCVideojuegoItemDAO(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public VideojuegoItem create(String nombre, String genero1, String genero2,
			String genero3, String descripcion, String nota,
			Date fechaLanzamiento, String urlFoto, String urlFicha,
			List<Categoria> plataformas) {
		// TODO Auto-generated method stub
		return null;
	}

}
