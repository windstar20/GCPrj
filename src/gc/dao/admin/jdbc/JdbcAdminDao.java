package gc.dao.admin.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gc.dao.admin.AdminDao;
import gc.dao.jdbc.DBContext;
import gc.entity.admin.Admin;

public class JdbcAdminDao implements AdminDao {

	@Override
	public int insert(Admin admin) {
		int result = 0;

		String url = DBContext.URL;
		String sql = "INSERT INTO ADMIN(ID, NICNAME, PWD) VALUES(?,?,?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, admin.getId());
			st.setString(2, admin.getNicname());
			st.setString(3, admin.getPwd());

//				ResutlSet rs = st.executeQuery(); // sselect 문장?���?
			st.executeUpdate(); // insert, update, delete 문장?�� ?��

//				rs.close();
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
	public int update(Admin admin) {
		int result = 0;

		String url =  DBContext.URL;
		String sql = "UPDATE ADMIN SET NICNAME=?, PWD=? WHERE ID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, admin.getNicname());
			st.setString(2, admin.getPwd());
			st.setInt(3, admin.getId());
			
//			ResutlSet rs = st.executeQuery(); // sselect 문장?���?
			st.executeUpdate(); // insert, update, delete 문장?�� ?��
			
			
//			rs.close();
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
		String sql = "DELETE ADMIN WHERE ID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
//			ResutlSet rs = st.executeQuery(); // sselect 문장?���?
			st.executeUpdate(); // insert, update, delete 문장?�� ?��
			
			
//			rs.close();
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
	public Admin get(int id) {
		Admin a = null;

		String url = DBContext.URL;
		String sql = "SELECT * FROM ADMIN WHERE ID=" + id;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				String nicname = rs.getString("nicname");
				String pwd = rs.getString("pwd");

				a = new Admin(id, nicname, pwd);

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
		return a;
	}

	@Override
	public List<Admin> getList() {
		List<Admin> list = new ArrayList<>(); // ArrayList

		String url = DBContext.URL;
		String sql = "SELECT * FROM ADMIN";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String nicname = rs.getString("nicname");
				String pwd = rs.getString("pwd");

				Admin a = new Admin(id, nicname, pwd);

				list.add(a);
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
