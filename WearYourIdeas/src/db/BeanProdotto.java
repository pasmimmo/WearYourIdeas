package db;

public class BeanProdotto {

	int idprod, quantita;
	String tipo, nome, descrizione, colore, taglia;
	float prezzo;

	public BeanProdotto() {
		idprod = -1;
		tipo = nome = descrizione = colore = taglia = "";
		quantita = 0;
	}

	public int getIdprod() {
		return idprod;
	}

	public void setIdprod(int idprod) {
		this.idprod = idprod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public String getTaglia() {
		return taglia;
	}

	public void setTaglia(String taglia) {
		this.taglia = taglia;
	}

	@Override
	public String toString() {
		String toString;
		toString=(tipo+" "+nome+" "+colore);
		return toString;
		//return nome + " (" + idprod + "), " + prezzo + " " + quantita + ". " + descrizione;
	}

}
