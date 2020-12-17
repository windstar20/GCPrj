package gc.dao.gym.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gc.dao.gym.GymEvaluationDao;
import gc.dao.jdbc.DBContext;
import gc.entity.gym.GymEvaluation;


public class JdbcGymEvaluationDao implements GymEvaluationDao{
	
	@Override
	public int insert(GymEvaluation gymEvaluation) {
		
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "INSERT INTO GYM_EVALUATION(RESERVATION_NUMBER, SCORE, CONTENT) VALUES(?,?,?)";// 占쌔븝옙占쏙옙占�? 占십억옙占쏙옙占쏙옙
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, gymEvaluation.getReservationNumber());
			st.setInt(2, gymEvaluation.getScore());
			st.setString(3, gymEvaluation.getContent());
			// Result rs = st.executeQuery() // select 占쏙옙占썲에占쏙옙
			result = st.executeUpdate(); // insert, update, delete 占쏙옙占쏙옙占쏙옙 占쏙옙
			st.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public int update(GymEvaluation gymEvaluation) {
		
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "UPDATE GYM_EVALUATION SET CONTENT=?, SCORE=? WHERE RESERVATION_NUMBER=?";// 占쌔븝옙占쏙옙占�? 占십억옙占쏙옙占쏙옙
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, gymEvaluation.getReservationNumber());
			st.setInt(2, gymEvaluation.getScore());
			st.setString(3, gymEvaluation.getContent());
			result = st.executeUpdate(); // insert, update, delete 占쏙옙占쏙옙占쏙옙 占쏙옙
			st.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(int reservationNumber) {	
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "DELETE FROM GYM_EVALUATION WHERE RESERVATION_NUMBER=?";// 占쌔븝옙占쏙옙占�? 占십억옙占쏙옙占쏙옙
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, reservationNumber); 
			result = st.executeUpdate(); // insert, update, delete 占쏙옙占쏙옙占쏙옙 占쏙옙
			st.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public GymEvaluation get(int reservationNumber) {
		
		GymEvaluation g = null;
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM GYM_EVALUATION WHERE RESERVATION_NUMBER="+reservationNumber;// 占쌔븝옙占쏙옙占�? 占십억옙占쏙옙占쏙옙
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Date regdate = rs.getDate("regdate");
				int score = rs.getInt("score");
				String content = rs.getString("conetent");
				
				g = new GymEvaluation(
						reservationNumber,
						regdate,
						score,
						content							
						);			
			}
			
			rs.close();
			st.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return g;
		
	}
	@Override
	public List<GymEvaluation> getList() {
		
		List<GymEvaluation> list = new ArrayList<>();
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM GYM_EVALUATION";
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int reservationNumber = rs.getInt("reservation_number");
				Date regdate = rs.getDate("regdate");
				int score = rs.getInt("score");
				String content = rs.getString("conetent");
				
				GymEvaluation g = new GymEvaluation(
						reservationNumber,
						regdate,
						score,
						content							
						);
				
				list.add(g);
			}
			
			rs.close();
			st.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	



}
