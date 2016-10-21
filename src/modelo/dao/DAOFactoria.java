package modelo.dao;

public abstract class DAOFactoria {
	// Metodos factoria
	public abstract UsuarioDAO getUsuarioDAO();
	public abstract CategoriaDAO getCategoriaDAO();
	public abstract CatalogoDAO getCatalogoDAO();

	// Declaracion como constantes de los tipos de factoria
	public final static int JDBC = 1;
	public final static int JPA = 2;
	public final static int MYSQL = 1;

	public static DAOFactoria getDAOFactoria(int tipo) throws DAOException {
		switch (tipo) {
		case JDBC: {
			try {
				return new JDBCDAOFactoria();
			} catch (Exception e) {
				throw new DAOException(e.getMessage());
			}
		}
		case JPA: {
			try {
				return new JPADAOFactoria();
			} catch (Exception e) {
				throw new DAOException(e.getMessage());
			}
		}
		default:
			return null;
		}
	}
}
