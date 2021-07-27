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
	
	public UtenteDAO utenteDAO() {
		return new UtenteDAOJDBC(dataSource);
	}
	
	public MessaggioDAO messaggioDAO() {
		return new MessaggioDAOJDBC(dataSource);
	}
	
	public CommentoDAO commentoDAO() {
		return new CommentoDAOJDBC(dataSource);
	}
	
	public LikeDAO likeDAO() {
		return new LikeDAOJDBC(dataSource);
	}
	
	/*public CategoriaDAO CategoriaDAO() {
		return new CategoriaDAOJDBC(dataSource);
	}*/

}

