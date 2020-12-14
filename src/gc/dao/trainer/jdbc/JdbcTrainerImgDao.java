package gc.dao.trainer.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gc.dao.jdbc.DBContext;
import gc.dao.trainer.TrainerImgDao;
import gc.entity.trainer.Trainer;
import gc.entity.trainer.TrainerImg;

public class JdbcTrainerImgDao implements TrainerImgDao{

	@Override
	public int insert(TrainerImg trainerImg) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "INSERT INTO TRAINER_EVALUATION(TRAINER_ID, FILE_NAME) VALUE(?,?)";
		
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, trainerImg.getTrainerId());
			st.setString(2, trainerImg.getFileName());
			
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
	public int update(TrainerImg trainerImg) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "UPDATE TRAINER_EVALUATION SET FILE_NAME=? WHERE TRAINER_ID=?";
		
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, trainerImg.getFileName());
			st.setInt(2, trainerImg.getTrainerId());
			
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
	public int delete(int trainerId,String fileName) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "DELTE FROM TRAINER_EVALUATION WHERE TRAINER_ID=?,FILE_NAME=?";
		
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, trainerId);
			st.setString(2, fileName);
			
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
	public TrainerImg get(int trainerId,String fileName) {
		TrainerImg t = null;
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM TRAINER_IMG WHERE TRAINER_ID="+trainerId+",FILE_NAME="+fileName;
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				
				t = new TrainerImg(
						trainerId,
						fileName
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

	@Override
	public List<TrainerImg> getList(int trainerId) {
		List<TrainerImg> list = new ArrayList<>();
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM TRAINER_IMG WHERE TRAINER_ID="+trainerId;
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String fileName = rs.getString("file_name");
				
			    TrainerImg t = new TrainerImg(
			    		trainerId,
			    		fileName
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
