package login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addUser
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			System.out.println("servlet start");
			UserBean bean = new UserBean();
			bean.setNome(request.getParameter("nome"));
			bean.setCognome(request.getParameter("cognome"));
			bean.setIndirizzo(request.getParameter("indirizzo"));
			bean.setMail(request.getParameter("mail"));
			bean.setCodiceFiscale(request.getParameter("codf"));
			bean.setUsername(request.getParameter("usname"));
			bean.setPassword(request.getParameter("psw"));
			UserDAO.addUtente(bean);
			response.sendRedirect("login.jsp"); // logged-in page
		} catch (SQLException e) {
			response.sendRedirect("error.jsp"); // logged-in page
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
