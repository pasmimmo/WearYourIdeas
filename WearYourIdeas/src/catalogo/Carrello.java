package catalogo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import db.BeanProdotto;
import db.ProductModel;
import db.ProductModelDM;
import db.ProductModelDS;

public class Carrello {
	// ProductModelDS usa il DataSource
	// ProductModelDM usa il DriverManager
	static boolean isDataSource = true;
	private Vector<OggettoCarrello> carrello;
	static ProductModel model;
	static {
		if (isDataSource) {
			model = new ProductModelDS();
		} else {
			model = new ProductModelDM();
		}
	}

	public Carrello() {
		carrello = new Vector<OggettoCarrello>();
	}

	public void addProdotto(int idProdotto) throws SQLException {
		addProdotto(cercaSQL(idProdotto));
	}

	public void addProdotto(BeanProdotto prodotto) {
		addProdotto(new OggettoCarrello(prodotto));
	}

	public void addProdotto(OggettoCarrello oggetto) {
		OggettoCarrello tmp = getOggettoCarrello(oggetto.getProdotto().getIdprod());
		if (tmp != null) {
			carrello.remove(tmp);
			tmp.incrementQta();
			carrello.addElement(tmp);
		} else
			carrello.addElement(oggetto);
	}

	public void removeProdotto(OggettoCarrello oggetto) {
		carrello.remove(oggetto);
	}

	public void svuotaCarrello() {
		carrello.clear();
	}

	public ArrayList<OggettoCarrello> getAllElementi() {
		ArrayList<OggettoCarrello> list=new ArrayList<OggettoCarrello>();
		for(int i=0;i<carrello.size();i++)
		{
			list.add(carrello.get(i));
		}
		return list;
	}

	public int size() {
		return carrello.size();
	}

	private BeanProdotto cercaSQL(int idprodotto) throws SQLException {
		return model.doRetrieveByKey(idprodotto);
	}

	public OggettoCarrello getOggettoCarrello(int idprodotto) {
		for (int i = 0; i < carrello.size(); i++) {
			if (carrello.get(i).getProdotto().getIdprod() == idprodotto)
				return carrello.get(i);
		}
		return null;
	}
}