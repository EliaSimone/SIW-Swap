package com.siw.project.persistance.dao;

import com.siw.project.model.Messaggio;

public interface MessaggioDAO {
	public void save(Messaggio messaggio);
	public Messaggio findById(int id);
}
