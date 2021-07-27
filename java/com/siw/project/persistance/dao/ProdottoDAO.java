package com.siw.project.persistance.dao;

import java.util.List;

import com.siw.project.model.Categoria;
import com.siw.project.model.Prodotto;
import com.siw.project.model.Utente;

public interface ProdottoDAO {
	public void save(Prodotto prodotto);
	public Prodotto findById(int id);
	public List<Prodotto> findAll();       
	public void update(Prodotto prodotto);
	public void delete(Prodotto prodotto);
	public List<Prodotto> getPerCategory(Categoria categoria);
	public List<Prodotto> searchProduct(String sq);
	public List<Prodotto> getPerSeller(Utente user);
	public List<Prodotto> getSoldBySeller(Utente user);
	public List<Prodotto> getPerBuyer(Utente user);
}
