package test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/vbn")
public class vbn extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie biscotto = new Cookie("cliente", "numero"); 
		biscotto.setMaxAge(90);
		response.addCookie(biscotto);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<title>Hello VBN </title>");
		out.println(request.getHeader("User-Agent")+"<hr>"+
		request.getParameter("nome")+"<hr>"+
		request.getContextPath()+"<hr>"+
		request.getQueryString()+"<hr>"+
		request.getPathTranslated()+"<hr>"
		);
		Cookie[] cookies = request.getCookies();
		if (cookies != null){
			for (int j=0;j<cookies.length;j++){
				Cookie c = cookies[j];
				out.println("un Cookie: "+c.getName()+c.getValue());
			}
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
