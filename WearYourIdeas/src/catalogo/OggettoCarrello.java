package catalogo;

import db.BeanProdotto;

public class OggettoCarrello {
	private BeanProdotto prodotto = new BeanProdotto();
	private int qta;

	public OggettoCarrello(BeanProdotto prodotto) {
		this.prodotto = prodotto;
		qta = 1;
	}

	public OggettoCarrello(BeanProdotto prodotto, int qta) {
		this.prodotto = prodotto;
		this.qta = qta;
	}

	public void incrementQta() {
		qta++;
	}

	public BeanProdotto getProdotto() {
		return prodotto;
	}

	public int getQta() {
		return qta;
	}

	public void removeQta(int num) throws Exception {
		if (this.qta >= num) {
			for (int i = 0; i < num; i++) {
				qta--;
			}
		} else
			throw new Exception();
	}

	public void removeQta() throws Exception {
		if (this.qta > 0)
			qta--;
		throw new Exception();
	}

	public void incrementQta(int qta) {
		for (int i = 0; i < qta; i++)
			incrementQta();
	}
}
