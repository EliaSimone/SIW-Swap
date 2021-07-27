package com.siw.project.persistance.dao;

import java.util.List;
import com.siw.project.model.Utente;


public interface UtenteDAO {
	public void save(Utente utente);
	public Utente findByName(String name);
	public List<Utente> findAll();
	public void update(Utente utente);
	public void delete(Utente utente);
}
