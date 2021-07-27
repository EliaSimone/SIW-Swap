package com.siw.project.model;

import java.util.ArrayList;

public class Prodotto {
	private int identifier;
	private String nome;
	private String image;
	private double prezzo;
	private String descrizione;
	private Categoria categoria;
	private Utente venditore=null;
	private Utente compratore=null;
	//protected ArrayList<Utente> likes=null;

	public Prodotto() {}
	
	public Prodotto(int identifier, String nome, String image, double prezzo, String descrizione, Categoria categoria, Utente venditore, Utente compratore) {
		this.identifier = identifier;
		this.nome = nome;
		this.image = image;
		this.prezzo = prezzo;
		this.descrizione = descrizione;
		this.categoria = categoria;
		this.venditore = venditore;
		this.compratore = compratore;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getIdentifier() {
		return identifier;
	}
	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Utente getVenditore() {
		return venditore;
	}
	public void setVenditore(Utente venditore) {
		this.venditore = venditore;
	}
	public Utente getCompratore() {
		return compratore;
	}
	public void setCompratore(Utente compratore) {
		this.compratore = compratore;
	}
	public String getFprezzo() {
		return String.format("%.2f", prezzo);
	}

	/*public ArrayList<Utente> getLikes() {
		return likes;
	}

	public void setLikes(ArrayList<Utente> likes) {
		this.likes = likes;
	}*/
}
