package com.siw.project.model;

public class Commento {
	private int id;
	private String testo;
	private Utente utente;
	private Prodotto prodotto;

	public Commento() {}

	public Commento(int id, String testo, Utente utente, Prodotto prodotto) {
		this.id = id;
		this.testo = testo;
		this.utente = utente;
		this.prodotto = prodotto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
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
