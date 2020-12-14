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
import gc.dao.trainer.TrainerLicenseDao;
import gc.entity.trainer.Trainer;
import gc.entity.trainer.TrainerLicense;

public class JdbcTrainerLicenseDao implements TrainerLicenseDao{

	@Override
	public int insert(TrainerLicense trainerLicense) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "INSERT INTO TRAINER_LICENSE(TRAINER_ID, NAME, CONTENT, ORGAN) VALUE(?,?,?,?)";
		
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, trainerLicense.getTrainerId());
			st.setString(2, trainerLicense.getName());
			st.setString(3, trainerLicense.getContent());
			st.setString(4, trainerLicense.getOrgan());
			
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
	public int update(TrainerLicense trainerLicense) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "UPDATE TRAINER_LICENSE SET NAME=?, CONTENT=?, ORGAN=? WHERE TRAINER_ID=?";
		
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, trainerLicense.getName());
			st.setString(2, trainerLicense.getContent());
			st.setString(3, trainerLicense.getOrgan());
			st.setInt(4, trainerLicense.getTrainerId());
			
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
	public int delete(int trainerId,String name) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "DELETE FROM TRAINER_LICENSE WHERE TRAINER_ID=?,NAME=?";
		
		
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
	public TrainerLicense get(int trainerId,String name) {
		TrainerLicense t = null;
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM TRAINER WHERE TRAINER_ID="+trainerId+",NAME="+name;
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String content = rs.getString("content");
				String organ = rs.getString("organ");
				
				t = new TrainerLicense(
						trainerId,
						name,
						content,
						organ
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
	public List<TrainerLicense> getList(int trainerId) {
		List<TrainerLicense> list = new ArrayList<>();
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM TRAINER_LICENSE WHERE TRAINER_ID="+trainerId;
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				
				String name = rs.getString("name");
			    String content = rs.getString("content");
			    String organ = rs.getString("organ");
			    
			    TrainerLicense t = new TrainerLicense(
			    		trainerId,
			    		name,
			    		content,
			    		organ
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
