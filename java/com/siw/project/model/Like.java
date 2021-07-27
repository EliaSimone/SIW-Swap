package com.siw.project.model;

public class Like {
	private boolean up;
	private Utente utente;
	private Prodotto prodotto;

	public Like() {}

	public Like(boolean up, Utente utente, Prodotto prodotto) {
		this.up = up;
		this.utente = utente;
		this.prodotto = prodotto;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

}
