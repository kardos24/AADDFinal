package modelo.dao;

import java.util.Date;
import java.util.List;

import modelo.Categoria;
import modelo.VideojuegoItem;

public interface VideojuegoItemDAO {

	VideojuegoItem create(String nombre, String genero1, String genero2,
			String genero3, String descripcion, String nota,
			Date fechaLanzamiento, String urlFoto, String urlFicha,
			List<Categoria> plataformas) throws DAOException;

}
