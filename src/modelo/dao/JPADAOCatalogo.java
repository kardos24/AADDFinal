package modelo.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import modelo.Catalogo;
import modelo.Usuario;

public class JPADAOCatalogo implements CatalogoDAO {

	public JPADAOCatalogo(EntityManagerFactory emf) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Catalogo create(String nombre, Date fecha, String web, String url,
			Usuario usuario) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Catalogo findByNombre(String nombre) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Catalogo> findByUsuario(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
