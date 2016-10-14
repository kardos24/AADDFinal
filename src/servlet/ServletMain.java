package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletMain")
public class ServletMain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletMain() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html> "
				+ "<html>"
				+ "<head> <link rel=\"stylesheet\" type=\"text/css\" href=\"css/aadd.css\"> </head>"
				+ "<body>"
				+ "	<h1>Practica Final Aplicaciones Distribuidas 16/17</h1>" 
				+ "	<h4><p>Bienvenido Usuario: "
				+ request.getAttribute("usuario_actual") + "</p></h4>"
				+ "</body>" + "</html>");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
