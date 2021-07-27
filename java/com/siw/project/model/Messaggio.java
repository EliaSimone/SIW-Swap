package com.siw.project.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Messaggio {
	private int id;
	private Utente utente1;
	private Utente utente2;
	private String testo;
	private Date data;

	public Messaggio() {}

	public Messaggio(int id, Utente utente1, Utente utente2, String testo, Date data) {
		this.id = id;
		this.utente1 = utente1;
		this.utente2 = utente2;
		this.testo = testo;
		this.data=data;
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public int getDataAnno() {
		Calendar c = new GregorianCalendar();
		c.setTime(data);
		return c.get(Calendar.YEAR);
	}
	
	public int getDataMese() {
		Calendar c = new GregorianCalendar();
		c.setTime(data);
		return c.get(Calendar.MONTH)+1;
	}
	
	public String getDataMeseNome() {
		Calendar c = new GregorianCalendar();
		c.setTime(data);
		String mesi[] = {"Gennaio",
				"Febbraio",
				"Marzo",
				"Aprile",
				"Maggio",
				"Giugno",
				"Luglio",
				"Agosto",
				"Settembre",
				"Ottobre",
				"Novembre",
				"Dicembre"};
		return mesi[c.get(Calendar.MONTH)];
	}
	
	public int getDataGiorno() {
		Calendar c = new GregorianCalendar();
		c.setTime(data);
		return c.get(Calendar.DATE);
	}

}
