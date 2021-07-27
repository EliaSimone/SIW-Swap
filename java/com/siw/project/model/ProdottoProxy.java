package com.siw.project.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.siw.project.persistance.DBManager;
import com.siw.project.persistance.DBSource;

public class ProdottoProxy extends Prodotto {
	DBSource dbSource;

	public ProdottoProxy() {
		super();
		dbSource=DBManager.getInstance().getDataSource();
	}
	
	public ProdottoProxy(int identifier, String nome, double prezzo, String descrizione, Categoria categoria, Utente venditore, Utente compratore) {
		super(identifier, nome, prezzo, descrizione, categoria, venditore, compratore);
		dbSource=DBManager.getInstance().getDataSource();
	}
	
	/*public ArrayList<Utente> getLikes() {
		if (likes==null) {
			Connection connection=null;
			try {
				connection = dbSource.getConnection();
				PreparedStatement statement = connection.prepareStatement("select * from utente where ");
				statement.setInt(1, getIdentifier());
				ResultSet rs = statement.executeQuery();
				likes=new ArrayList<Utente>();
				while (rs.next()) {
					String nome = rs.getString("nome");
					String password = rs.getString("password");
					String citta = rs.getString("citta");
					String indirizzo = rs.getString("indirizzo");
					String desc = rs.getString("descrizione");
					String tel = rs.getString("tel");
					
					likes.add(new Utente(nome, password, citta, indirizzo, desc, tel));
				}
				return likes;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}
			}
		}
		return likes;
	}*/

}
