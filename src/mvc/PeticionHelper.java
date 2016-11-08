package mvc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

public class PeticionHelper {

	private static final String ACCION_PROPIEDADES = "WEB-INF/eventos.properties";
	private HttpServletRequest request;
	private String dirAplicacion;

	public PeticionHelper(HttpServletRequest request, String dirAplicacion) {
		this.request = request;
		this.dirAplicacion = dirAplicacion;
	}

	public Accion getAccion1() {
		System.out.println("PeticionHelper.getAccion()");
		// Analiza la URI para determinar la acción a realizar
		String uri = request.getRequestURI();
		// Obtiene la cadena entre la última "/" y ".ctrl"
		int posIni = uri.lastIndexOf("/");
		int posFin = uri.lastIndexOf(".event");
		String evento = uri.substring(posIni + 1, posFin);
		// Recupera el nombre de la clase que representa la acción
		// del fichero de propiedades
		Accion acc = null;
		try {
			System.out.println(dirAplicacion + ACCION_PROPIEDADES);
			InputStream is = new FileInputStream(dirAplicacion
					+ ACCION_PROPIEDADES);
			Properties props = new Properties();
			props.load(is);
			String strClaseAccion = props.getProperty(evento);
			// Instacia el objeto Accion utilizando reflexión
			Class<?> claseAccion = Class.forName(strClaseAccion);
			acc = (Accion) claseAccion.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return acc;
	}

}
