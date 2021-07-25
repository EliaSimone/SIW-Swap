package com.siw.project.persistance;

import com.siw.project.persistance.dao.*;
import com.siw.project.persistance.dao.jdbc.*;

public class DBManager {
	private static DBManager instance = null;
	static DBSource dataSource;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			dataSource=new DBSource("jdbc:postgresql://localhost:5432/postgres","postgres","password");
		} 
		catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
			e.printStackTrace();
		}
	}
	
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}
	
	private DBManager() {
	}
	
	public DBSource getDataSource() {
		return dataSource;
	}
	
	public ProdottoDAO prodottoDAO() {
		return new ProdottoDAOJDBC(dataSource);
	}
	
	public UtenteDAO UtenteDAO() {
		return new UtenteDAOJDBC(dataSource);
	}
	
	/*public CategoriaDAO CategoriaDAO() {
		return new CategoriaDAOJDBC(dataSource);
	}*/

}

