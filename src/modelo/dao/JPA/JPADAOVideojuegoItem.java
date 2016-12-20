package modelo.dao.JPA;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import modelo.Categoria;
import modelo.VideojuegoItem;
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
			List<Categoria> plataformas) {
		// TODO Auto-generated method stub
		return null;
	}

}
