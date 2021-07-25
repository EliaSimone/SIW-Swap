package com.siw.project.persistance.dao;

import java.util.List;

import com.siw.project.model.Prodotto;
import com.siw.project.model.Utente;

public interface ProdottoDAO {
	public void save(Prodotto prodotto);  // Create
	public Prodotto findById(int id);     // Retrieve
	public List<Prodotto> findAll();       
	public void update(Prodotto prodotto); //Update
	public void delete(Prodotto prodotto); //Delete	
	public List<Prodotto> searchProduct(String sq);
	public List<Prodotto> getPerSeller(Utente user);
	public List<Prodotto> getSoldBySeller(Utente user);
	public List<Prodotto> getPerBuyer(Utente user);
}
