package com.siw.project.persistance.dao;

import java.util.List;

import com.siw.project.model.Commento;
import com.siw.project.model.Prodotto;

public interface CommentoDAO {
	public void save(Commento commento);
	public Commento findById(int id);
	public List<Commento> findByProduct(Prodotto prodotto);
}
