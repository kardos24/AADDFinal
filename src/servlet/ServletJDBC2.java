package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ServletJDBC2
 */
@WebServlet("/ServletJDBC2")
public class ServletJDBC2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletJDBC2() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			InitialContext contexto = new InitialContext();
			DataSource ds = (DataSource) contexto
					.lookup("java:comp/env/jdbc/AADD");
			Connection con = ds.getConnection();
			if (con != null)
				System.out.println("CONEXIÓN ESTABLECIDA!!!!!!!");
			
			con.close();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
