package gc.dao.gym.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gc.dao.gym.GymImageDao;
import gc.dao.jdbc.DBContext;
import gc.entity.gym.GymImage;


public class JdbcGymImageDao implements GymImageDao {
	
	@Override
	public int insert(GymImage gymImage) {
		
	int result = 0;
		
		String url = DBContext.URL;
		String sql = "INSERT INTO GYM_IMAGE(GYM_ID, FILE_NAME) VALUE(?,?)";
		
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, gymImage.getGymID());
			st.setString(2, gymImage.getFileName());
			
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
	public int update(GymImage gymImage) {
		
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "UPDATE GYM_IMAGE SET FILE_NAME=? WHERE GYM_ID=?";
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, gymImage.getFileName());
			st.setInt(2, gymImage.getGymID());
			
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
	public int delete(int gymId) {
		
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "DELTE FROM GYM_IMAGE WHERE GYM_ID=?";
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, gymId);

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
	public GymImage get(int gymId) {
		
		GymImage g = null;
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM GYM_IMAGE WHERE GYM_ID="+gymId;
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				
				String fileName = rs.getString("file_name");
				
				g = new GymImage(
						gymId, 
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
		return g;
		
	}

	@Override
	public List<GymImage> getList() {
		
		List<GymImage> list = new ArrayList<>();
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM GYM_IMAGE";
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				
				int gymId = rs.getInt("gym_id");
				String fileName = rs.getString("file_name");
				
				GymImage g = new GymImage(
						gymId, 
						fileName
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
