package gc.dao.trainer.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gc.dao.jdbc.DBContext;
import gc.dao.trainer.TrainerDao;
import gc.entity.trainer.Trainer;

public class JdbcTrainerDao implements TrainerDao{

	@Override
	public int insert(Trainer trainer) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "INSERT INTO TRAINER(NAME, GYM_ID, PHONE) VALUE(?,?,?)";
		
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, trainer.getName());
			st.setInt(2, trainer.getGymId());
			st.setString(3, trainer.getPhone());
			
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
	public int update(Trainer trainer) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "UPDATE TRAINER SET NAME=?,PHONE=? WHERE ID=?";
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, trainer.getName());
			st.setString(2, trainer.getPhone());
			st.setInt(3, trainer.getId());
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
	public int delete(int id) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "DELETE FROM TRAINER WHERE ID=";
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
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
	public Trainer get(int id) {
		Trainer t = null;
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM TRAINER WHERE ID="+id;
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String name = rs.getString("name");
			    int gymId = rs.getInt("gym_id");
			    String gender = rs.getString("gender");
			    String phone = rs.getString("phone");
				
				t = new Trainer(
					id,
				    name,
				    gymId,
				    gender,
				    phone
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
	public List<Trainer> getList() {
		List<Trainer> list = new ArrayList<>();
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM TRAINER";
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
			    int gymId = rs.getInt("gym_id");
			    String gender = rs.getString("gender");
			    String phone = rs.getString("phone");
				
				Trainer t = new Trainer(
					id,
				    name,
				    gymId,
				    gender,
				    phone
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
