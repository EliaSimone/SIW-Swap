package com.siw.project.persistance.dao;

import java.util.List;

import com.siw.project.model.Messaggio;
import com.siw.project.model.Utente;

public interface MessaggioDAO {
	public void save(Messaggio messaggio);
	public Messaggio findById(int id);
	public List<Messaggio> findByDest(Utente dest);
}
