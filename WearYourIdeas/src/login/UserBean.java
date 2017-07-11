package login;

import java.io.IOException;

public class UserBean {

	private String username, password, nome, cognome, indirizzo, codfiscale, email;
	public boolean valido;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setMail(String mail) {
		this.email = mail;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public void setCodiceFiscale(String codfiscale) throws IOException {
		if (codfiscale.length() == 16) {
			this.codfiscale = codfiscale;
		} else
			throw new IOException();
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public String getUsername() {
		return username;
	}

	public String getMail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getCodfiscale() {
		return codfiscale;
	}

	public boolean isValid() {
		return valido;
	}

	public void setValido(boolean newvalido) {
		valido = newvalido;
	}
}
