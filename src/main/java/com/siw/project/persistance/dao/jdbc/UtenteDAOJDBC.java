package com.siw.project.persistance.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siw.project.model.Utente;
import com.siw.project.persistance.DBSource;
import com.siw.project.persistance.dao.UtenteDAO;

public class UtenteDAOJDBC implements UtenteDAO {
	DBSource dbSource;

	public UtenteDAOJDBC(DBSource dbSource) {
		this.dbSource = dbSource;
	}

	@Override
	public void save(Utente utente) {
		Connection connection=null;
		try {
			connection = dbSource.getConnection();
			PreparedStatement statement = connection.prepareStatement("insert into utente(nome, cognome, password, citta, indirizzo, descrizione, tel) values (?,?,?,?,?,?,?);");
			statement.setString(1, utente.getNome());
			statement.setString(2, utente.getCognome());
			statement.setString(3, utente.getPassword());
			statement.setString(4, utente.getCitta());
			statement.setString(5, utente.getIndirizzo());
			statement.setString(6, utente.getDescrizione());
			statement.setString(7, utente.getTel());
			statement.executeUpdate();
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

	@Override
	public Utente findByName(String name) {
		Utente u = null;
		Connection conn = null;
		try {
			conn = dbSource.getConnection();
			PreparedStatement  st = conn.prepareStatement("select * from utente where nome = ?;");
			st.setString(1, name);			
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String password = rs.getString("password");
				String citta = rs.getString("citta");
				String indirizzo = rs.getString("indirizzo");
				String desc = rs.getString("descrizione");
				String tel = rs.getString("tel");
				
				u = new Utente(nome, cognome, password, citta, indirizzo, desc, tel);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		return u;
	}

	@Override
	public List<Utente> findAll() {
		List<Utente> utenti = new ArrayList<Utente>();
		Connection conn = null;
		
		try {
			conn = dbSource.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from utente;");
			while (rs.next()) {
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				String password = rs.getString("password");
				String citta = rs.getString("citta");
				String indirizzo = rs.getString("indirizzo");
				String desc = rs.getString("descrizione");
				String tel = rs.getString("tel");
				
				utenti.add(new Utente(nome, cognome, password, citta, indirizzo, desc, tel));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		return utenti;
	}

	@Override
	public void update(Utente utente) {
		Connection connection = null;
		try {
			connection = dbSource.getConnection();
			String update = "update utente SET cognome = ?, password = ?, citta = ?, indirizzo = ?, descrizione = ?, tel = ? WHERE nome = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, utente.getCognome());
			statement.setString(2, utente.getPassword());
			statement.setString(3, utente.getCitta());
			statement.setString(4, utente.getIndirizzo());
			statement.setString(5, utente.getDescrizione());
			statement.setString(6, utente.getTel());
			statement.setString(7, utente.getNome());
			statement.executeUpdate();
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch(SQLException excep) {
					throw new RuntimeException(e.getMessage());
				}
			} 
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	@Override
	public void delete(Utente utente) {
		// TODO Auto-generated method stub

	}

}
