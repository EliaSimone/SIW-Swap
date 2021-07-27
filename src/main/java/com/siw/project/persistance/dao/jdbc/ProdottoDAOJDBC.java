package com.siw.project.persistance.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siw.project.model.Categoria;
import com.siw.project.model.Prodotto;
import com.siw.project.model.Utente;
import com.siw.project.persistance.DBSource;
import com.siw.project.persistance.dao.ProdottoDAO;

public class ProdottoDAOJDBC implements ProdottoDAO {
	DBSource dbSource;
	
	public ProdottoDAOJDBC(DBSource dbSource) {
		this.dbSource = dbSource;
	}


	@Override
	public void save(Prodotto prodotto) {
		Connection connection=null;
		try {
			connection = dbSource.getConnection();
			PreparedStatement statement = connection.prepareStatement("insert into prodotto(nome, image, prezzo, descrizione, categoria, venditore, compratore) values (?,?,?,?,?,?,?);");
			statement.setString(1, prodotto.getNome());
			statement.setString(2, prodotto.getImage());
			statement.setDouble(3, prodotto.getPrezzo());
			statement.setString(4, prodotto.getDescrizione());
			statement.setString(5, prodotto.getCategoria().getNome());
			statement.setString(6, prodotto.getVenditore().getNome());
			if (prodotto.getCompratore()==null)
				statement.setString(7, null);
			else
				statement.setString(8, prodotto.getCompratore().getNome());
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
	public Prodotto findById(int id) {
		Prodotto p = null;
		Connection conn = null;
		try {
			conn = dbSource.getConnection();
			PreparedStatement  st = conn.prepareStatement("select p.*,\r\n"
					+ "vend.cognome as vendcognome, vend.password as vendpassword, vend.image as vendimage, vend.citta as vendcitta, vend.indirizzo as vendindirizzo, vend.descrizione as venddescr, vend.tel as vendtel,\r\n"
					+ "compr.cognome as comprcognome, compr.password as comprpassword, compr.image as comprimage, compr.citta as comprcitta, compr.indirizzo as comprindirizzo, compr.descrizione as comprdescr, compr.tel as comprtel\r\n"
					+ "from prodotto as p\r\n"
					+ "left join categoria as c on c.nome=p.categoria\r\n"
					+ "left join utente as compr on compr.nome=p.compratore\r\n"
					+ "left join utente as vend on vend.nome=p.venditore\r\n"
					+ "where p.identifier=?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				int _id = rs.getInt("identifier");
				String nome = rs.getString("nome");
				String image = rs.getString("image");
				double prezzo = rs.getDouble("prezzo");
				String desc = rs.getString("descrizione");
				
				Categoria catg = new Categoria(rs.getString("categoria"));
				
				String vNome = rs.getString("venditore");
				String vCognome = rs.getString("vendcognome");
				String vPassword = rs.getString("vendpassword");
				String vImage = rs.getString("vendimage");
				String vCitta = rs.getString("vendcitta");
				String vIndr = rs.getString("vendindirizzo");
				String vDesc = rs.getString("venddescr");
				String vTel = rs.getString("vendtel");
				Utente vend = new Utente(vNome, vCognome, vPassword, vImage, vCitta, vIndr, vDesc, vTel);
				
				Utente compr=null;
				if (rs.getString("compratore")!=null) {
					vNome = rs.getString("compratore");
					vCognome = rs.getString("comprcognome");
					vPassword = rs.getString("comprpassword");
					vImage = rs.getString("comprimage");
					vCitta = rs.getString("comprcitta");
					vIndr = rs.getString("comprindirizzo");
					vDesc = rs.getString("comprdescr");
					vTel = rs.getString("comprtel");
					compr = new Utente(vNome, vCognome, vPassword, vImage, vCitta, vIndr, vDesc, vTel);
				}
				
				p = new Prodotto(_id, nome, image, prezzo, desc, catg, vend, compr);
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
		
		return p;
	}

	@Override
	public List<Prodotto> findAll() {
		List<Prodotto> prodotti = new ArrayList<Prodotto>();
		Connection conn = null;
		
		try {
			conn = dbSource.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select p.*,\r\n"
					+ "vend.cognome as vendcognome, vend.password as vendpassword, vend.image as vendimage, vend.citta as vendcitta, vend.indirizzo as vendindirizzo, vend.descrizione as venddescr, vend.tel as vendtel\r\n"
					+ "from prodotto as p\r\n"
					+ "left join categoria as c on c.nome=p.categoria\r\n"
					+ "left join utente as vend on vend.nome=p.venditore\r\n"
					+ "where p.compratore is null");
			while (rs.next()) {
				int _id = rs.getInt("identifier");
				String nome = rs.getString("nome");
				String image = rs.getString("image");
				double prezzo = rs.getDouble("prezzo");
				String desc = rs.getString("descrizione");
				
				Categoria catg = new Categoria(rs.getString("categoria"));
				
				String vNome = rs.getString("venditore");
				String vCognome = rs.getString("vendcognome");
				String vPassword = rs.getString("vendpassword");
				String vImage = rs.getString("vendimage");
				String vCitta = rs.getString("vendcitta");
				String vIndr = rs.getString("vendindirizzo");
				String vDesc = rs.getString("venddescr");
				String vTel = rs.getString("vendtel");
				Utente vend = new Utente(vNome, vCognome, vPassword, vImage, vCitta, vIndr, vDesc, vTel);
				
				prodotti.add(new Prodotto(_id, nome, image, prezzo, desc, catg, vend, null));	
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
		
		return prodotti;
	}

	@Override
	public void update(Prodotto prodotto) {
		Connection connection = null;
		try {
			connection = dbSource.getConnection();
			PreparedStatement statement = connection.prepareStatement("update prodotto SET nome = ?, image = ?, prezzo = ?, descrizione = ?, categoria = ?, venditore = ?, compratore = ? WHERE identifier = ?");
			statement.setString(1, prodotto.getNome());
			statement.setString(2, prodotto.getImage());
			statement.setDouble(3, prodotto.getPrezzo());
			statement.setString(4, prodotto.getDescrizione());
			statement.setString(5, prodotto.getCategoria().getNome());
			statement.setString(6, prodotto.getVenditore().getNome());
			if (prodotto.getCompratore()==null)
				statement.setString(7, null);
			else
				statement.setString(7, prodotto.getCompratore().getNome());
			
			statement.setInt(8, prodotto.getIdentifier());

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
	public void delete(Prodotto prodotto) {
		Connection connection = null;
		try {
			connection = dbSource.getConnection();
			PreparedStatement statement = connection.prepareStatement("delete FROM prodotto WHERE identifier = ? ");
			statement.setInt(1, prodotto.getIdentifier());

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}		
	}
	
	@Override
	public List<Prodotto> getPerCategory(Categoria categoria) {
		List<Prodotto> prodotti = new ArrayList<Prodotto>();
		Connection conn = null;
		
		try {
			conn = dbSource.getConnection();
			PreparedStatement  st = conn.prepareStatement("select p.*,\r\n"
					+ "vend.cognome as vendcognome, vend.password as vendpassword, vend.image as vendimage, vend.citta as vendcitta, vend.indirizzo as vendindirizzo, vend.descrizione as venddescr, vend.tel as vendtel\r\n"
					+ "from prodotto as p\r\n"
					+ "left join categoria as c on c.nome=p.categoria\r\n"
					+ "left join utente as vend on vend.nome=p.venditore\r\n"
					+ "where p.categoria = ? and p.compratore is null");
			st.setString(1, categoria.getNome());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int _id = rs.getInt("identifier");
				String nome = rs.getString("nome");
				String image = rs.getString("image");
				double prezzo = rs.getDouble("prezzo");
				String desc = rs.getString("descrizione");
				
				Categoria catg = new Categoria(rs.getString("categoria"));
				
				String vNome = rs.getString("venditore");
				String vCognome = rs.getString("vendcognome");
				String vPassword = rs.getString("vendpassword");
				String vImage = rs.getString("vendimage");
				String vCitta = rs.getString("vendcitta");
				String vIndr = rs.getString("vendindirizzo");
				String vDesc = rs.getString("venddescr");
				String vTel = rs.getString("vendtel");
				Utente vend = new Utente(vNome, vCognome, vPassword, vImage, vCitta, vIndr, vDesc, vTel);
				
				prodotti.add(new Prodotto(_id, nome, image, prezzo, desc, catg, vend, null));	
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
		
		return prodotti;
	}
	
	@Override
	public List<Prodotto> searchProduct(String sq) {
		List<Prodotto> prodotti = new ArrayList<Prodotto>();
		Connection conn = null;
		
		try {
			conn = dbSource.getConnection();
			PreparedStatement  st = conn.prepareStatement("select p.*,\r\n"
					+ "vend.cognome as vendcognome, vend.password as vendpassword, vend.image as vendimage, vend.citta as vendcitta, vend.indirizzo as vendindirizzo, vend.descrizione as venddescr, vend.tel as vendtel\r\n"
					+ "from prodotto as p\r\n"
					+ "left join categoria as c on c.nome=p.categoria\r\n"
					+ "left join utente as vend on vend.nome=p.venditore\r\n"
					+ "where p.compratore is null and (lower(p.nome) like ? or lower(p.descrizione) like ?);");
			st.setString(1, "%"+sq.toLowerCase()+"%");
			st.setString(2, "%"+sq.toLowerCase()+"%");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int _id = rs.getInt("identifier");
				String nome = rs.getString("nome");
				String image = rs.getString("image");
				double prezzo = rs.getDouble("prezzo");
				String desc = rs.getString("descrizione");
				
				Categoria catg = new Categoria(rs.getString("categoria"));
				
				String vNome = rs.getString("venditore");
				String vCognome = rs.getString("vendcognome");
				String vPassword = rs.getString("vendpassword");
				String vImage = rs.getString("vendimage");
				String vCitta = rs.getString("vendcitta");
				String vIndr = rs.getString("vendindirizzo");
				String vDesc = rs.getString("venddescr");
				String vTel = rs.getString("vendtel");
				Utente vend = new Utente(vNome, vCognome, vPassword, vImage, vCitta, vIndr, vDesc, vTel);
				
				prodotti.add(new Prodotto(_id, nome, image, prezzo, desc, catg, vend, null));
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
		
		return prodotti;
	}
	
	@Override
	public List<Prodotto> getPerSeller(Utente user) {
		List<Prodotto> prodotti = new ArrayList<Prodotto>();
		Connection conn = null;
		
		try {
			conn = dbSource.getConnection();
			PreparedStatement  st = conn.prepareStatement("select p.*\r\n"
					+ "from prodotto as p\r\n"
					+ "left join categoria as c on c.nome=p.categoria\r\n"
					+ "where p.venditore = ? and p.compratore is null");
			st.setString(1, user.getNome());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int _id = rs.getInt("identifier");
				String nome = rs.getString("nome");
				String image = rs.getString("image");
				double prezzo = rs.getDouble("prezzo");
				String desc = rs.getString("descrizione");
				
				Categoria catg = new Categoria(rs.getString("categoria"));
				
				prodotti.add(new Prodotto(_id, nome, image, prezzo, desc, catg, user, null));	
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
		
		return prodotti;
	}
	
	@Override
	public List<Prodotto> getSoldBySeller(Utente user) {
		List<Prodotto> prodotti = new ArrayList<Prodotto>();
		Connection conn = null;
		
		try {
			conn = dbSource.getConnection();
			PreparedStatement  st = conn.prepareStatement("select p.*,\r\n"
					+ "compr.cognome as comprcognome, compr.password as comprpassword, compr.image as comprimage, compr.citta as comprcitta, compr.indirizzo as comprindirizzo, compr.descrizione as comprdescr, compr.tel as comprtel\r\n"
					+ "from prodotto as p\r\n"
					+ "left join categoria as c on c.nome=p.categoria\r\n"
					+ "left join utente as compr on compr.nome=p.compratore\r\n"
					+ "where p.venditore = ? and p.compratore is not null");
			st.setString(1, user.getNome());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int _id = rs.getInt("identifier");
				String nome = rs.getString("nome");
				String image = rs.getString("image");
				double prezzo = rs.getDouble("prezzo");
				String desc = rs.getString("descrizione");
				
				Categoria catg = new Categoria(rs.getString("categoria"));
				
				String vNome = rs.getString("compratore");
				String vCognome = rs.getString("comprcognome");
				String vPassword = rs.getString("comprpassword");
				String vImage = rs.getString("comprimage");
				String vCitta = rs.getString("comprcitta");
				String vIndr = rs.getString("comprindirizzo");
				String vDesc = rs.getString("comprdescr");
				String vTel = rs.getString("comprtel");
				Utente compr = new Utente(vNome, vCognome, vPassword, vImage, vCitta, vIndr, vDesc, vTel);
				
				prodotti.add(new Prodotto(_id, nome, image, prezzo, desc, catg, user, compr));	
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
		
		return prodotti;
	}
	
	@Override
	public List<Prodotto> getPerBuyer(Utente user) {
		List<Prodotto> prodotti = new ArrayList<Prodotto>();
		Connection conn = null;
		
		try {
			conn = dbSource.getConnection();
			PreparedStatement  st = conn.prepareStatement("select p.*,\r\n"
					+ "vend.cognome as vendcognome, vend.password as vendpassword, vend.image as vimage, vend.citta as vendcitta, vend.indirizzo as vendindirizzo, vend.descrizione as venddescr, vend.tel as vendtel\r\n"
					+ "from prodotto as p\r\n"
					+ "left join categoria as c on c.nome=p.categoria\r\n"
					+ "left join utente as vend on vend.nome=p.venditore\r\n"
					+ "where p.compratore = ?");
			st.setString(1, user.getNome());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int _id = rs.getInt("identifier");
				String nome = rs.getString("nome");
				String image = rs.getString("image");
				double prezzo = rs.getDouble("prezzo");
				String desc = rs.getString("descrizione");
				
				Categoria catg = new Categoria(rs.getString("categoria"));
				
				String vNome = rs.getString("venditore");
				String vCognome = rs.getString("vendcognome");
				String vPassword = rs.getString("vendpassword");
				String vImage = rs.getString("vimage");
				String vCitta = rs.getString("vendcitta");
				String vIndr = rs.getString("vendindirizzo");
				String vDesc = rs.getString("venddescr");
				String vTel = rs.getString("vendtel");
				Utente vend = new Utente(vNome, vCognome, vPassword, vImage, vCitta, vIndr, vDesc, vTel);
				
				prodotti.add(new Prodotto(_id, nome, image, prezzo, desc, catg, vend, user));	
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
		
		return prodotti;
	}

}
