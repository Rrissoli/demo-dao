package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {
		Connection conn = DB.getConnection();
		// RECUPERAR E INSERIR DADOS
		
		// vamos fazer uma demonstração para recuperar dados
		// ResultSet
		// first() [move para a primeria posicão1 , se houver ]
		// beforeFirst() [move para posição 0]
		// next() [move para o próximo, retorna false se ja estiver no ultimo]
		// absolute(int) [move para a posição dada, lembrando que dados reais começam em 1]
		// fazendo consulta => 
//		Connection conn2 = null;
//		Statement st = null;
//		ResultSet rs =null;
//		try {
//			conn =DB.getConnection();
//			st = conn.createStatement();
//			rs = st.executeQuery("select * from department");
//			while (rs.next()) {
//				System.out.println(rs.getInt("Id")+ ", " + rs.getString("Name"));
//				
//				
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		finally {
//			DB.closeStatement(st);
//			DB.closeResultSet(rs);
//			DB.closeConnection();
//		}
		PreparedStatement st2 = null;
		try {
			conn = DB.getConnection();
			st2 = conn.prepareStatement(
					"INSERT INTO seller" 
					+ "(Name, Email,BirthDate, BaseSalary, DepartmentId)" 		
					+ "VALUES"
					+ "(?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS
					);
			st2.setString(1, "Carlinhos Maia");
			st2.setString(2, "carlo@yahoo.com");
			SimpleDateFormat smpDt = new SimpleDateFormat("dd/MM/yyyy");
			st2.setDate(3,	new Date(smpDt.parse("22/12/2012").getTime()));
			st2.setDouble(4, 4000);
			st2.setInt(5, 3);
			int rowsAffected = st2.executeUpdate();
			
			if (rowsAffected > 0) { 
				ResultSet rs = st2.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					
				}
			}else {
				System.out.println("No row affected");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ParseException e) {
			e.printStackTrace();
		}finally {
			DB.closeStatement(st2);
			DB.closeConnection();
		}
		
	}

}
