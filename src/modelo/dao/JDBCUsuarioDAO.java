package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import modelo.Catalogo;
import modelo.Usuario;

public class JDBCUsuarioDAO implements UsuarioDAO {

	private DataSource ds;

	public JDBCUsuarioDAO(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public Usuario create(String nif, String nombre, String usuario,
			String clave, String email) throws DAOException {

		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ds.getConnection();
			stmt = con.prepareStatement("INSERT into USUARIO"
					+ "(nif,nombre,usuario,clave,email) "
					+ "values (?,?,?,?,?)");
			stmt.setString(1, nif);
			stmt.setString(2, nombre);
			stmt.setString(3, usuario);
			stmt.setString(4, clave);
			stmt.setString(5, email);

			stmt.executeUpdate();
			stmt.close();
			con.close();

			Usuario c = new Usuario(nif, nombre, usuario, clave, email);

			return c;
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}

	}

	@Override
	public Usuario addCatalogo(Usuario usuario, Catalogo catalogo)
			throws DAOException {

		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ds.getConnection();
			stmt = con
					.prepareStatement("UPDATE Catalogo SET usuario= ? WHERE nombre =  ?");
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, catalogo.getNombre());

			stmt.executeUpdate();
			stmt.close();
			con.close();

			usuario.getCatalogos().add(catalogo);

			return usuario;
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}

	}

	@Override
	public Usuario findByUsuario(String usuario) throws DAOException {

		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ds.getConnection();
			stmt = con
					.prepareStatement("SELECT nif,nombre,usuario,clave,email FROM Usuario WHERE usuario = ? ");
			stmt.setString(1, usuario);
			ResultSet rs = stmt.executeQuery();

			Usuario usu = null;
			if (rs.next()) {
				usu = new Usuario(rs.getString("nif"), rs.getString("nobmre"),
						rs.getString("usuario"), rs.getString("clave"),
						rs.getString("email"));
			}

			stmt.close();
			con.close();

			return usu;
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}

}
