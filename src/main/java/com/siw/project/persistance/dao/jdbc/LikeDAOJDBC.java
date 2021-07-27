package com.siw.project.persistance.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.siw.project.model.Like;
import com.siw.project.model.Prodotto;
import com.siw.project.model.Utente;
import com.siw.project.persistance.DBSource;
import com.siw.project.persistance.dao.LikeDAO;

public class LikeDAOJDBC implements LikeDAO {
	DBSource dbSource;
	
	public LikeDAOJDBC(DBSource dbSource) {
		this.dbSource = dbSource;
	}

	@Override
	public void save(Like like) {
		Connection connection=null;
		try {
			connection = dbSource.getConnection();
			PreparedStatement statement = connection.prepareStatement("insert into plike(utente, prodotto, up) values (?,?,?);");
			statement.setString(1, like.getUtente().getNome());
			statement.setInt(2, like.getProdotto().getIdentifier());
			statement.setBoolean(3, like.isUp());
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
	public void update(Like like) {
		Connection connection=null;
		try {
			connection = dbSource.getConnection();
			PreparedStatement statement = connection.prepareStatement("update plike SET up = ? WHERE utente = ? and prodotto = ?");
			statement.setBoolean(1, like.isUp());
			statement.setString(2, like.getUtente().getNome());
			statement.setInt(3, like.getProdotto().getIdentifier());
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
	public void delete(Like like) {
		Connection conn = null;
		try {
			conn = dbSource.getConnection();
			PreparedStatement  st = conn.prepareStatement("delete from plike where prodotto=? and utente=?");
			st.setInt(1, like.getProdotto().getIdentifier());
			st.setString(2, like.getUtente().getNome());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	@Override
	public Like findByPrimaryKey(Prodotto prodotto, Utente utente) {
		Connection conn = null;
		Like like=null;
		try {
			conn = dbSource.getConnection();
			PreparedStatement  st = conn.prepareStatement("select * from plike where prodotto=? and utente=?");
			st.setInt(1, prodotto.getIdentifier());
			st.setString(2, utente.getNome());
			ResultSet rs = st.executeQuery();
			if (rs.next())
				like = new Like(rs.getBoolean("up"), utente, prodotto);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return like;
	}

	@Override
	public int countUp(Prodotto prodotto) {
		Connection conn = null;
		int n=0;
		try {
			conn = dbSource.getConnection();
			PreparedStatement  st = conn.prepareStatement("select count(*) as n from plike where prodotto=? and up=true");
			st.setInt(1, prodotto.getIdentifier());
			ResultSet rs = st.executeQuery();
			if (rs.next())
				n=rs.getInt("n");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return n;
	}

	@Override
	public int countDown(Prodotto prodotto) {
		Connection conn = null;
		int n=0;
		try {
			conn = dbSource.getConnection();
			PreparedStatement  st = conn.prepareStatement("select count(*) as n from plike where prodotto=? and up=false");
			st.setInt(1, prodotto.getIdentifier());
			ResultSet rs = st.executeQuery();
			if (rs.next())
				n=rs.getInt("n");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return n;
	}

}
