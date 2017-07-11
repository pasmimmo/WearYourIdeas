package catalogo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PaginaOrdine")

public class PaginaOrdine extends HttpServlet {

	private static final long serialVersionUID = 4271620089835437973L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Carrello carrello;
		synchronized (session) {
			carrello = (Carrello) session.getAttribute("carrello");
			// New visitors get a fresh shopping cart.
			// Previous visitors keep using their existing cart.
			if (carrello == null) {
				carrello = new Carrello();
				session.setAttribute("carrello", carrello);
			}
			// controlla i getParameter
			String idProdotto = request.getParameter("idprodotto");
			if (idProdotto != null) {
				String qtaProdotto = request.getParameter("numItems");
				if (qtaProdotto == null) {
					// If request specified an ID but no number,
					// then customers came here via an "Add Item to Cart"
					// button on a catalog page.
					try {
						carrello.addProdotto(Integer.parseInt(idProdotto));
					} catch (NumberFormatException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					// If request specified an ID and number, then
					// customers came here via an "Update Order" button
					// after changing the number of items in order.
					// Note that specifying a number of 0 results
					// in item being deleted from cart.
					for (int i = 0; i < Integer.parseInt(qtaProdotto); i++) {
						try {
							carrello.addProdotto(Integer.parseInt(idProdotto));
						} catch (NumberFormatException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
		// Whether or not the customer changed the order, show
		// order status.
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Status of Your Order";
		out.println("<!DOCTYPE HTML>"
				  + "<html>" 
				  + "<head>" 
				  + "<title>"+title+"</title>");
		request.getRequestDispatcher("CSSimport.jsp").include(request, response);
		out.println("</head>"
				+ "<body>");
		request.getRequestDispatcher("menu.jsp").include(request, response);
		out.println("<div class='container'><div class='row blog'><h1 style='text-align:center'>Prodotti nel tuo carrello:</h1>");
		synchronized (session) {
			ArrayList<OggettoCarrello> list = carrello.getAllElementi();
			if (list.size() == 0) {
				out.println("<h1>Carrello Vuoto</h1>");
			} else {
				out.println("<div class='table-bordered'>"
						+ "<TABLE class='table' style='text-align:center'>"
						+ "<TR>"
						+ "<TH>Codice Prodotto"
						+ "<TH>Nome"
						+ "<TH>Costo Unitario"
						+ "<TH>Q.ta"
						+ "<TH>Totale");
				for (int i = 0; i < list.size(); i++) {
					OggettoCarrello cartObj = list.get(i);
					out.println("<TR>"
							+ "<TD>#PC000"+ cartObj.getProdotto().getIdprod()
							+ "<TD>"+ cartObj.getProdotto().toString() 
							+ "<TD>" + cartObj.getProdotto().getPrezzo()
							+ "<TD><form>"
							+ "<input type='hidden' name='itemID' value='"+cartObj.getProdotto().getIdprod()+"'>"
							+ "<input type='text' name='numItems' size='3' value='"+cartObj.getQta()+"'>" 
							+ "\t  <button type='button' class='btn btn-primary'><span class='glyphicon glyphicon-refresh' onclick='location.href=\"PaginaOrdine\"' alt='refres'></span></button>"
							+ "</form>"
							+ "<TD>&euro; \t"+(cartObj.getQta()*cartObj.getProdotto().getPrezzo()));
				}
				String checkoutURL = response.encodeURL("Checkout.jsp");
				// "Proceed to Checkout" button below table
				out.println("</table></div>"
						+ "<form action='"+checkoutURL+"'>"
						//+ "<input type='submit' value='Concludi Ordine' class='btn btn-info' style='margin:0 50% 0'>"
						+ "</form>"
						+ "<div class='btn-group'style='margin-left:40%; margin-top:1%'>"
						+ "<button type='button' class='btn btn-success' onclick='location.href=\"Checkout.jsp\"'><span class='glyphicon glyphicon-ok'></span>Concludi Ordine</button>"
						+ "<button type='button' class='btn btn-warning' onclick='location.href=\"sessionDelete.jsp\"'><span class='glyphicon glyphicon-remove'></span> Annulla tutto</button></div>");
			}
			out.println("</div></div></body>");
		}
		request.getRequestDispatcher("footer.jsp").include(request, response);
	}
}
