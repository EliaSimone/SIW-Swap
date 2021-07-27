package com.siw.project.model;

public class Utente {
	private String nome;
	private String cognome;
	private String password;
	private String image;
	private String citta;
	private String indirizzo;
	private String descrizione;
	private String tel;
	
	public Utente() {}
	
	public Utente(String nome, String cognome, String password, String image, String citta, String indirizzo, String descrizione, String tel) {
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.image = image;
		this.citta = citta;
		this.indirizzo = indirizzo;
		this.descrizione = descrizione;
		this.tel = tel;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

}
