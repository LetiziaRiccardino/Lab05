package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.model.Anagramma;


public class AnagrammaDAO {
	
	
	List<Anagramma> parole = new LinkedList<Anagramma>();
	
	
	
	public List<Anagramma> dizionario() {
		
		String sql = "SELECT nome FROM parola"; //SELECT nome

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				parole.add(new Anagramma( rs.getString("nome")));
			}
			
		conn.close();
		st.close();
		return parole;
		
		
		
		} catch (SQLException e) {
		// e.printStackTrace();
		throw new RuntimeException("Errore Db", e);
		}
		
		
		
	}
	
	public boolean isCorrect(String anagramma) {
		String sql = "SELECT nome FROM parola WHERE nome=?";
		boolean result;

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, anagramma);
			
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				result=true;
			}else {
				result=false;
			}
			
		conn.close();
		st.close();
		return result;
		
		
		
		} catch (SQLException e) {
		// e.printStackTrace();
		throw new RuntimeException("Errore Db", e);
		}
	}
}
