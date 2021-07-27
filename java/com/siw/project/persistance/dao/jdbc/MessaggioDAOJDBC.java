package com.siw.project.persistance.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siw.project.model.Messaggio;
import com.siw.project.model.Utente;
import com.siw.project.persistance.DBSource;
import com.siw.project.persistance.dao.MessaggioDAO;

public class MessaggioDAOJDBC implements MessaggioDAO {
	DBSource dbSource;
	
	public MessaggioDAOJDBC(DBSource dbSource) {
		this.dbSource = dbSource;
	}

	@Override
	public void save(Messaggio messaggio) {
		Connection connection=null;
		try {
			connection = dbSource.getConnection();
			PreparedStatement statement = connection.prepareStatement("insert into messaggio(utente1, utente2, testo, data) values (?,?,?,?);");
			statement.setString(1, messaggio.getUtente1().getNome());
			statement.setString(2, messaggio.getUtente2().getNome());
			statement.setString(3, messaggio.getTesto());
			statement.setDate(4, new Date(messaggio.getData().getTime()));
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
	public Messaggio findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Messaggio> findByDest(Utente dest) {
		List<Messaggio> mexs = new ArrayList<Messaggio>();
		Connection conn = null;
		
		try {
			conn = dbSource.getConnection();
			PreparedStatement  st = conn.prepareStatement("select m.*,\r\n"
					+ "s.cognome as scognome, s.password as spassword, s.citta as scitta, s.indirizzo as sindirizzo, s.descrizione as sdescr, s.tel as stel,\r\n"
					+ "d.cognome as dcognome, d.password as dpassword, d.citta as dcitta, d.indirizzo as dindirizzo, d.descrizione as ddescr, d.tel as dtel\r\n"
					+ "from messaggio as m\r\n"
					+ "join utente as s on s.nome=m.utente1\r\n"
					+ "join utente as d on d.nome=m.utente2\r\n"
					+ "where m.utente2=?");
			st.setString(1, dest.getNome());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String testo = rs.getString("testo");
				Date data = rs.getDate("data");
				
				String uNome = rs.getString("utente1");
				String uCognome = rs.getString("scognome");
				String uPassword = rs.getString("spassword");
				String uCitta = rs.getString("scitta");
				String uIndr = rs.getString("sindirizzo");
				String uDesc = rs.getString("sdescr");
				String uTel = rs.getString("stel");
				Utente utente1 = new Utente(uNome, uCognome, uPassword, uCitta, uIndr, uDesc, uTel);
				
				uNome = rs.getString("utente2");
				uCognome = rs.getString("dcognome");
				uPassword = rs.getString("dpassword");
				uCitta = rs.getString("dcitta");
				uIndr = rs.getString("dindirizzo");
				uDesc = rs.getString("ddescr");
				uTel = rs.getString("dtel");
				Utente utente2 = new Utente(uNome, uCognome, uPassword, uCitta, uIndr, uDesc, uTel);
				
				mexs.add(new Messaggio(id, utente1, utente2, testo, data));	
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
		
		return mexs;
	}

}
