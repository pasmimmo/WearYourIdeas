package catalogo;

import java.sql.SQLException;
import java.util.LinkedList;
import javax.servlet.annotation.WebServlet;
import db.BeanProdotto;

@WebServlet("/PaginaMagliette")
public class PaginaMagliette extends PaginaProdottoModel {

	private static final long serialVersionUID = 1065470783705575028L;

	public void init() {
		try {
			LinkedList<BeanProdotto> lis = (LinkedList<BeanProdotto>) model.doRetrieveAll("");
			String[] idProdotti = new String[lis.size()];
			for (int i = 0; i < lis.size(); i++) {
				idProdotti[i] = String.valueOf(lis.get(i).getIdprod());
			}
			setProdotti(idProdotti);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setTitle("Selezione magliette");
	}
}
