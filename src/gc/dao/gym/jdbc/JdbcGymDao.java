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

import gc.dao.gym.GymDao;
import gc.dao.jdbc.DBContext;
import gc.entity.gym.Gym;

public class JdbcGymDao implements GymDao {

	@Override
	public List<Gym> getList() {
		
		List<Gym> list = new ArrayList<>();
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "SELECT * FROM GYM";
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String pwd = rs.getNString("pwd");
				String name = rs.getString("name");
				String gymName = rs.getString("gym_Name");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				String phone = rs.getString("phone");
				String licenseNumber = rs.getString("licens_Number");
				String adress = rs.getString("adress");
				Date regdate = rs.getDate("regdate");
				
				Gym g = new Gym(
						id,
						pwd,
						name,
						gymName,
						email,
						telephone,
						phone,
						licenseNumber,
						adress,
						regdate
						);
						
				list.add(g);
			}
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public Gym get(int id) {
		
		Gym g = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "SELECT * FROM GYM WHERE ID="+id;
		
		Connection con;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String pwd = rs.getNString("pwd");
				String name = rs.getString("name");
				String gymName = rs.getString("gym_Name");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				String phone = rs.getString("phone");
				String licenseNumber = rs.getString("licens_Number");
				String adress = rs.getString("adress");
				Date regdate = rs.getDate("regdate");
				
				g = new Gym(
						id,
						pwd,
						name,
						gymName,
						email,
						telephone,
						phone,
						licenseNumber,
						adress,
						regdate
						);
			
				}
				rs.close();
				st.close();
				con.close();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return g;
	}
	@Override
	public int insert(Gym gym) {
		
		int result = 0;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "INSERT INTO GYM(NAME, GYM_NAME) VALUES(?,?)";// �غ����? �ʾ�����
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, gym.getName());
			st.setString(2, gym.getGym_name());
			// Result rs = st.executeQuery() // select ���忡��
			result = st.executeUpdate(); // insert, update, delete ������ ��
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
	public int update(Gym gym) {
		
		int result = 0;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "UPDATE GYM SET NAME=?, GYM_NAME=? WHERE ID=?";// �غ����? �ʾ�����
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);//DBContext.UID PWD
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, gym.getName());
			st.setString(2, gym.getGym_name());
			st.setInt(3, gym.getId());
			// Result rs = st.executeQuery() // select ���忡��
			result = st.executeUpdate(); // insert, update, delete ������ ��
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
		
		String driver = "oracle.jdbc.driver.OracleDriver";	
		String url = DBContext.URL;
		String sql = "DELETE FROM GYM WHERE ID=?";// �غ����? �ʾ�����
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			// Result rs = st.executeQuery() // select ���忡��
			result = st.executeUpdate(); // insert, update, delete ������ ��
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
	public int deleteAll(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}



}
