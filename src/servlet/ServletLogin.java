package servlet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controlador.Controlador;

@WebServlet(urlPatterns = { "/ServletLogin", "/index.html" }, initParams = { @WebInitParam(name = "admin", value = "admin", description = "Valor de usuario antes de tener persistencia") })
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String claveAdmin;

	public ServletLogin() {
		super();
	}

	// public void init(ServletConfig config){
	// super.init(config);
	// claveAdmin = config.getInitParameter("admin");
	// }

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// Obtenemos la ruta física el fichero del formulario
		String pathFichero = getServletConfig().getServletContext()
				.getRealPath("login.html");
		// Tenemos el formulario vacío en el fichero "login.htm"
		BufferedReader br = new BufferedReader(new FileReader(pathFichero));
		String linea;
		while ((linea = br.readLine()) != null)
			out.println(linea);
		br.close();

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");

		HttpSession sesion = request.getSession();
		Integer numIntentos = (Integer) sesion.getAttribute("numeroIntentos");

		if (Objects.nonNull(numIntentos)) {
			numIntentos++;
		} else {
			numIntentos = 1;
		}
		sesion.setAttribute("numeroIntentos", numIntentos);
		if (numIntentos > 3) {
			response.sendError(500, "Número de intentos superado");
			return;
		}

		@SuppressWarnings("unchecked")
		Map<String, Date> usuarios = (Map<String, Date>) getServletConfig()
				.getServletContext().getAttribute("usuario");
		if (usuarios == null) {
			usuarios = new HashMap<String, Date>();
			getServletConfig().getServletContext().setAttribute("usuario",
					usuarios);
		}
		if (usuarios.get(usuario) != null) {
			response.sendError(500, "USUARIO YA LOGUEADO EN OTRA SESIÓN : "
					+ usuarios.get(usuario));
			return;
		}

		boolean error = true;
		// String claveUsuario = getServletConfig().getInitParameter(usuario);
		// if(claveUsuario != null && Objects.equals(clave,claveUsuario)) {
		if (!Controlador.getInstance().login(usuario, clave)) {
			sesion.setAttribute("numeroIntentos", new Integer(0));
			sesion.setAttribute("usuario_actual", usuario);
			error = false;
		}

		if (!error) {
			usuarios.put(usuario, new Date());

			RequestDispatcher rd = request.getRequestDispatcher("ServletMain");
			request.setAttribute("usuario_actual", usuario);
			rd.forward(request, response);
			// PrintWriter out = response.getWriter();
			// out.println("Autentificación correcta");
		} else {
			response.sendRedirect("error.html");
		}
	}

}
