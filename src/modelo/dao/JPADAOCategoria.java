package modelo.dao;

import javax.persistence.EntityManagerFactory;

import modelo.Categoria;

public class JPADAOCategoria implements CategoriaDAO {

	public JPADAOCategoria(EntityManagerFactory emf) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Categoria create(String nombre) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
