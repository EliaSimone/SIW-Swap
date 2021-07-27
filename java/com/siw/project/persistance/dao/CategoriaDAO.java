package com.siw.project.persistance.dao;

import com.siw.project.model.Categoria;

public interface CategoriaDAO {
	public Categoria findByName(String name);
}
