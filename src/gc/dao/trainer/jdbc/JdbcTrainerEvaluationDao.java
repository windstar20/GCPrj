package gc.dao.trainer.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import gc.dao.jdbc.DBContext;
import gc.dao.trainer.TrainerEvaluationDao;
import gc.entity.trainer.Trainer;
import gc.entity.trainer.TrainerEvaluation;

public class JdbcTrainerEvaluationDao implements TrainerEvaluationDao{

	@Override
	public int insert(TrainerEvaluation trainerEvaluation) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "INSERT INTO TRAINER_EVALUATION(CONTENT, SCORE) VALUE(?,?)";
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, trainerEvaluation.getContent());
			st.setInt(2, trainerEvaluation.getScore());
			
			result = st.executeUpdate();
			
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
	public int update(TrainerEvaluation trainerEvaluation) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "UPDATE TRAINER_EVALUATION SET CONTENT=?, SCORE=? WHERE RESERVATION_NUMBER=?";
		
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, trainerEvaluation.getContent());
			st.setInt(2, trainerEvaluation.getScore());
			st.setInt(3, trainerEvaluation.getReservationNumber());
			
			result = st.executeUpdate();
			
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
		String sql = "DELETE FROM TRAINER_EVALUATION WHERE RESERVATION_NUMBER=?";
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, reservationNumber);
			
			result = st.executeUpdate();
			
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
	public TrainerEvaluation get(int reservationNumber) {
		TrainerEvaluation t = null;
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM TRAINER_EVALUATION WHERE RESERVATION_NUMBER="+reservationNumber;
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
			    Date regdate = rs.getDate("regdate");
			    String content = rs.getString("content");
			    int score = rs.getInt("score");
					
				t = new TrainerEvaluation(
						reservationNumber,
						regdate,
						content,
						score
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
		return t;
	}


}
