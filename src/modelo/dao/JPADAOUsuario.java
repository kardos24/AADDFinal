package modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import modelo.Usuario;

public class JPADAOUsuario implements UsuarioDAO {
	
	private EntityManager em;

	public JPADAOUsuario(EntityManagerFactory emf) {
		em = emf.createEntityManager();
	}

	@Override
	public Usuario create(String nif, String nombre, String usuario,
			String clave, String email) throws DAOException {
		em.getTransaction().begin();
		Usuario usuJPA = new Usuario(nif,nombre, usuario, clave, email);
		em.persist(usuJPA);
		em.getTransaction().commit();
		return usuJPA;
	}

	@Override
	public void update(Usuario usuario) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario findByUsuario(String usuario) throws DAOException {
		Usuario usuJPA = em.find(Usuario.class, usuario);
		return usuJPA;
	}

}
