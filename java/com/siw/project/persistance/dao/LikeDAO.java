package com.siw.project.persistance.dao;

import java.util.List;

import com.siw.project.model.Like;
import com.siw.project.model.Prodotto;
import com.siw.project.model.Utente;

public interface LikeDAO {
	public void save(Like like);
	public void update(Like like);
	public void delete(Like like);
	public Like findByPrimaryKey(Prodotto prodotto, Utente utente);
	public int countUp(Prodotto prodotto);
	public int countDown(Prodotto prodotto);
}
