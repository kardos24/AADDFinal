package modelo.dao;

import javax.sql.DataSource;

import pool.ConnectionPool;

public class JDBCDAOFactoria extends DAOFactoria {

	private DataSource ds;

	public JDBCDAOFactoria() throws DAOException, ClassNotFoundException,
			java.sql.SQLException {
		ds = ConnectionPool.getInstance("jdbc:mysql://localhost:3306/aadd",
				"root", "");
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		return (UsuarioDAO) new JDBCUsuarioDAO(ds);
	}

	@Override
	public CategoriaDAO getCategoriaDAO() {
		return (CategoriaDAO) new JDBCCategoriaDAO(ds);
	}

	@Override
	public CatalogoDAO getCatalogoDAO() {
		return (CatalogoDAO) new JDBCCatalogoDAO(ds);
	}

}
