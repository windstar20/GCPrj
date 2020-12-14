package gc.dao.trainer.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gc.dao.jdbc.DBContext;
import gc.dao.trainer.TrainerContestDao;
import gc.dao.trainer.TrainerDao;
import gc.entity.trainer.Trainer;
import gc.entity.trainer.TrainerContest;

public class JdbcTrainerContestDao implements TrainerContestDao{

	@Override
	public int insert(TrainerContest trainerContest) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "INSERT INTO TRAINER_CONTEST(NAME, PHONE, DATE) VALUE(?,?,?)";
		
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, trainerContest.getName());
			st.setString(2, trainerContest.getContent());
			st.setDate(3, (Date) trainerContest.getDate());
			
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
	public int update(TrainerContest trainerContest) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "UPDATE TRAINER_CONTEST SET NAME=?,PHONE=?,DATE=? WHERE TRAINER_ID=?,NAME=?";
		
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, trainerContest.getName());
			st.setString(2, trainerContest.getContent());
			st.setDate(3, (Date) trainerContest.getDate());
			st.setInt(4, trainerContest.getTrainerId());
			st.setString(5, trainerContest.getName());
			
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
	public int delete(int trainerId, String name) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "DELETE FROM TRAINER_CONTEST WHERE TRAINER_ID=?,NAME=?";
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, trainerId);
			st.setString(2, name);
			
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
	public List<TrainerContest> getList(int trainerId) {
		List<TrainerContest> list = new ArrayList<>();
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM TRAINER_CONTEST WHERE TRAINER_ID="+trainerId;
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
			    String name = rs.getString("name");
			    String content = rs.getString("content");
			    Date date = rs.getDate("date");
			    
			    TrainerContest t = new TrainerContest(
		    		trainerId,
		    		name,
		    		content,
		    		date
				);
				
				list.add(t);
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
