package modelo.dao.JPA;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import modelo.Categoria;
import modelo.Usuario;
import modelo.VideojuegoItem;
import modelo.dao.DAOException;
import modelo.dao.VideojuegoItemDAO;

public class JPADAOVideojuegoItem implements VideojuegoItemDAO {

	private EntityManager em;

	public JPADAOVideojuegoItem(EntityManagerFactory emf) {
		em = emf.createEntityManager();
	}

	@Override
	public VideojuegoItem create(String nombre, String genero1, String genero2,
			String genero3, String descripcion, String nota,
			Date fechaLanzamiento, String urlFoto, String urlFicha,
			List<Categoria> plataformas) throws DAOException {
		try {
			em.getTransaction().begin();
			VideojuegoItem juegoJPA = new VideojuegoItem(nombre, genero1,
					genero2, genero3, descripcion, nota, fechaLanzamiento,
					urlFoto, urlFicha);
			juegoJPA.setPlataformas(plataformas);
			em.persist(juegoJPA);
			em.getTransaction().commit();
			return juegoJPA;
		} catch (Exception ex) {
			throw new DAOException(ex.getMessage());
		}
	}

}
