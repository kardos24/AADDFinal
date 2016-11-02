package mvc;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;
import controlador.Controlador;

public class AccionRegistrarUsuario implements Accion {

	@Override
	public String ejecutar(HttpServletRequest request,
			HttpServletResponse response, ServletContext aplicacion) {

		String usuario = request.getParameter("usuario");
		String nombre = request.getParameter("nombre");
		String clave = request.getParameter("clave");
		String mail = request.getParameter("mail");
		String nif = request.getParameter("nif");

		Usuario usu = Controlador.getInstance().registrar(nif, nombre, usuario,
				clave, mail);

		if(usu == null) return "error.jsp";
		return "index.html";
	}

}
