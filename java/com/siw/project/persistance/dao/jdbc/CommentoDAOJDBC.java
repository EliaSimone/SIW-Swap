package com.siw.project.persistance.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.siw.project.model.Commento;
import com.siw.project.model.Prodotto;
import com.siw.project.model.Utente;
import com.siw.project.persistance.DBSource;
import com.siw.project.persistance.dao.CommentoDAO;

public class CommentoDAOJDBC implements CommentoDAO {
	DBSource dbSource;
	
	public CommentoDAOJDBC(DBSource dbSource) {
		this.dbSource = dbSource;
	}

	@Override
	public void save(Commento commento) {
		Connection connection=null;
		try {
			connection = dbSource.getConnection();
			PreparedStatement statement = connection.prepareStatement("insert into commento(testo, prodotto, utente) values (?,?,?);");
			statement.setString(1, commento.getTesto());
			statement.setInt(2, commento.getProdotto().getIdentifier());
			statement.setString(3, commento.getUtente().getNome());
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
	public Commento findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commento> findByProduct(Prodotto prodotto) {
		List<Commento> commenti = new ArrayList<Commento>();
		Connection conn = null;
		
		try {
			conn = dbSource.getConnection();
			PreparedStatement  st = conn.prepareStatement("select c.*,\r\n"
					+ "u.cognome as ucognome, u.password as upassword, u.citta as ucitta, u.indirizzo as uindirizzo, u.descrizione as udescr, u.tel as utel,\r\n"
					+ "p.nome as pnome, p.prezzo as pprezzo\r\n"
					+ "from commento as c\r\n"
					+ "join utente as u on c.utente=u.nome\r\n"
					+ "join prodotto as p on c.prodotto=p.identifier\r\n"
					+ "where p.identifier=?");
			st.setInt(1, prodotto.getIdentifier());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String testo = rs.getString("testo");
				
				String uNome = rs.getString("utente");
				String uCognome = rs.getString("ucognome");
				String uPassword = rs.getString("upassword");
				String uCitta = rs.getString("ucitta");
				String uIndr = rs.getString("uindirizzo");
				String uDesc = rs.getString("udescr");
				String uTel = rs.getString("utel");
				Utente utente = new Utente(uNome, uCognome, uPassword, uCitta, uIndr, uDesc, uTel);			
				
				commenti.add(new Commento(id, testo, utente, prodotto));	
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
		
		return commenti;
	}

}
