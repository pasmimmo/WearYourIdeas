package catalogo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import db.BeanProdotto;
import db.ProductModel;
import db.ProductModelDM;
import db.ProductModelDS;

@WebServlet("/PaginaProdottoModel")

public abstract class PaginaProdottoModel extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -32975668330882915L;
	static boolean isDataSource = true;
	static ProductModel model;

	static {
		if (isDataSource) {
			model = new ProductModelDS();
		} else {
			model = new ProductModelDM();
		}
	}

	private BeanProdotto[] beans;
	@SuppressWarnings("unused")
	private String[] idProdotti;
	private String nomeProdotto;

	protected void setProdotti(String[] idProdotti) throws SQLException {
		this.idProdotti = idProdotti;
		beans = new BeanProdotto[idProdotti.length];
		for (int i = 0; i < beans.length; i++) {
			beans[i] = model.doRetrieveByKey(Integer.parseInt(idProdotti[i]));
		}
	}

	protected void setTitle(String title) {
		nomeProdotto = title;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (beans == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Missing Items.");
			return;
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html> \n" + "<html> \n" + "<head>\n " + "<title>" + nomeProdotto + "</title>");
		request.getRequestDispatcher("CSSimport.jsp").include(request, response);
		out.println("</head>" + "<body>");
		request.getRequestDispatcher("menu.jsp").include(request, response);
		out.println("<div class='container blog'>");
		BeanProdotto bean;
		out.println("<h1 class='blog' style='font-family: Pacifico, cursive; color:black'>Ecco la nostra selezione di prodotti:</h1><br>");
		for (int i = 0; i < beans.length; i++) {
			bean = beans[i];
			if (bean == null) {
				out.println("<h1 style='color:red'> non trovo gli Ids" + beans[i] + "</h1>");
			} else {
				out.print("<div class='row'>");
				String formURL = "PaginaOrdine";
				// Pass URLs that reference own site through encodeURL.
				formURL = response.encodeURL(formURL);
				out.print("<div class='col-md-3'>"
						// + "<img src='media/'"+bean.getImage+ "'
						// class='img-responsive'>"
						+ "<img src='media/img1.jpg'  class='img-responsive'></div>" + "<div class='col-md-9'>"
						+ "<form action='" + formURL + "'>" + "<input type='hidden' name='idprodotto' value='"
						+ bean.getIdprod() + "'>" + "<h1>" +(i+1)+") "+ bean.toString() + "</h1>" + "<p> Colore:\t\t\t"
						+ bean.getColore() + "<br> Prezzo\t\t\t" + "&euro; " + bean.getPrezzo() + "</p>" + "<p>"
						+ bean.getDescrizione() + "<br>"
						+ "<input type='submit' value='Aggiungi al carrello' class='btn btn-primary'></p>" + "</form>"
						+ "</div></div><hr>");
			}
		}
		out.println("</div>");
		request.getRequestDispatcher("footer.jsp").include(request, response);
		out.println("</body>" + "</html>");
	}
}
