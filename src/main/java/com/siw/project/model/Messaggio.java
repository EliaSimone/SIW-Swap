package com.siw.project.model;

public class Messaggio {
	private int id;
	private String testo;
	private Utente utente1;
	private Utente utente2;

	public Messaggio() {}

	public Messaggio(int id, String testo, Utente utente1, Utente utente2) {
		this.id = id;
		this.testo = testo;
		this.utente1 = utente1;
		this.utente2 = utente2;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return testo;
	}

	public void setText(String testo) {
		this.testo = testo;
	}

	public Utente getUtente1() {
		return utente1;
	}

	public void setUtente1(Utente utente1) {
		this.utente1 = utente1;
	}

	public Utente getUtente2() {
		return utente2;
	}

	public void setUtente2(Utente utente2) {
		this.utente2 = utente2;
	}

}
