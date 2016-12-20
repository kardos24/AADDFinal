package modelo.dao.JPA;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import modelo.Catalogo;
import modelo.Categoria;
import modelo.dao.CategoriaDAO;
import modelo.dao.DAOException;

public class JPADAOCategoria implements CategoriaDAO {

	private EntityManager em;

	public JPADAOCategoria(EntityManagerFactory emf) {
		em = emf.createEntityManager();
	}

	@Override
	public Categoria create(String nombre) throws DAOException {
		try {
			em.getTransaction().begin();
			Categoria categoJPA = new Categoria(nombre);
			em.persist(categoJPA);
			em.getTransaction().commit();
			return categoJPA;
		} catch (Exception ex) {
			throw new DAOException(ex.getMessage());
		}
	}

	@Override
	public List<Categoria> findAll() throws DAOException {
		TypedQuery<Categoria> query = em.createQuery("SELECT a FROM Asistente a", Categoria.class);
		List<Categoria> resultList = new LinkedList<Categoria>();
		try {
			resultList = query.getResultList();
		} catch (Exception e) {
			throw new DAOException("Recuperar todas las entidades: " + e.getMessage());
		}
		return resultList;
	}

}
