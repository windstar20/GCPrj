package gc.dao.trainer.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import gc.dao.jdbc.DBContext;
import gc.dao.trainer.TrainerCommentDao;
import gc.entity.trainer.Trainer;
import gc.entity.trainer.TrainerComment;

public class JdbcTrainerCommentDao implements TrainerCommentDao{

	@Override
	public int insert(TrainerComment trainerComment) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "INSERT INTO TRAINER_COMMENT(RESERVATION_NUMBER, TRAINER_ID, CONTENT) VALUE(?,?,?)";
		
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, trainerComment.getReservationNumber());
			st.setInt(2,trainerComment.getTrainerId());
			st.setString(3, trainerComment.getContent());
			
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
	public int update(TrainerComment trainerComment) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "UPDATE TRAINER_COMMENT SET CONTENT=? WHERE RESERVATION_NUMBER=?, TRAINER_ID=?";
		
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, trainerComment.getContent());
			st.setInt(2, trainerComment.getReservationNumber());
			st.setInt(3,trainerComment.getTrainerId());
			
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
	public int delete(int reservationNumber, int trainerId) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "DELETE FROM TRAINER_COMMENT WHERE RESERVATION_NUMBER=?, TRAINER_ID=?";
		
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, reservationNumber);
			st.setInt(2, trainerId);
			
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
	public TrainerComment get(int reservationNumber, int trainerId) {
		TrainerComment t = null;
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM TRAINER_COMMET WHERE RESERVATION_NUMBER="+reservationNumber+" TRAINER_ID="+trainerId;
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				
				t = new TrainerComment(
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
