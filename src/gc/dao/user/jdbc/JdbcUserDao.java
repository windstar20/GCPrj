package gc.dao.user.jdbc;

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
import gc.dao.user.UserDao;
import gc.entity.user.User;

public class JdbcUserDao implements UserDao {

	@Override
	public int insert(User user) {
		int result = 0;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "INSERT INTO USER_MEMBER(ID,NICNAME,PWD,NAME,GENDER,AGE,PHONE,EMAIL,ADDRESS,RECOMMEND_NAME)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)"; 
		
		try {   
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, user.getId());
			st.setString(2, user.getNicname());
			st.setString(3, user.getPwd());
			st.setString(4, user.getName());
			st.setString(5, user.getGender());
			st.setInt(6, user.getAge());
			st.setString(7, user.getPhone());
			st.setString(8, user.getEmail());
			st.setString(9, user.getAddress());
			st.setString(10, user.getRecommendName());
			
			result = st.executeUpdate();  
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public int update(User user) {
		int result = 0;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "UPDATE USER_MEMBER SET WHERE ID=?,NICNAME=?,PWD=?,PHONE=?,EMAIL=?,ADDRESS=?"
				+ " VALUES(?,?,?,?,?,?)";
				
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, user.getId());
			st.setString(2, user.getNicname());
			st.setString(3, user.getPwd());
			st.setString(4, user.getPhone());
			st.setString(5, user.getEmail());
			st.setString(6, user.getAddress());
			
			result = st.executeUpdate();
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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
		String sql = "DELETE USER_MEMBER WHERE ID=?";
				
				
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);			
			
			result = st.executeUpdate();
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

	

	@Override
	public User get(int id) {
		User u = null;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "SELECT * FROM USER_MEMBER WHERE ID="+id; 
	
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			
			if(rs.next()){
				
				 id = rs.getInt("id");
			     String nicname = rs.getString("nicname");
			     String pwd = "1";
			     String name = rs.getString("name");
			     String gender = rs.getString("gender");
			     int age = rs.getInt("age");
			     String phone = rs.getString("phone");
			     Date regdate = rs.getDate("regdate") ;
			     String email = rs.getString("email");
			     String address = rs.getString("address");
			     String recommendName = rs.getString("recommend_name");
			     int ratingId = rs.getInt("rating_id");
			     int warningCount = rs.getInt("warning_count");
			     
			      u = new User(
			    		 	id,
			    		    nicname,
			    		    pwd,
			    		    name,
			    		    gender,
			    		    age,
			    		    phone,
			    		    regdate,
			    		    email,
			    		    address,
			    		    warningCount,
			    		    recommendName,
			    		    ratingId
			    		    );
			     
			     
			}
			
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return u;
	}

	@Override
	public List<User> getList() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "SELECT * FROM USER_MEMBER"; 
	
		List<User>list = new ArrayList<>();
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			
			while(rs.next()){
				 int id = rs.getInt("id");
			     String nicname = rs.getString("nicname");
			     String pwd = "1";
			     String name = rs.getString("name");
			     String gender = rs.getString("gender");
			     int age = rs.getInt("age");
			     String phone = rs.getString("phone");
			     Date regdate = rs.getDate("regdate") ;
			     String email = rs.getString("email");
			     String address = rs.getString("address");
			     String recommendName = rs.getString("recommend_name");
			     int ratingId = rs.getInt("rating_id");
			     int warningCount = rs.getInt("warning_count");
			     
			     User u = new User(
			    		 	id,
			    		    nicname,
			    		    pwd,
			    		    name,
			    		    gender,
			    		    age,
			    		    phone,
			    		    regdate,
			    		    email,
			    		    address,
			    		    warningCount,
			    		    recommendName,
			    		    ratingId
			    		    );
			     
			     list.add(u);
			}
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public User overlapId(String nicname) {
		
		User u = null;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "SELECT * FROM USER_MEMBER WHERE ID="+nicname; 
	
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			
			if(rs.next()){
				
				 int id = rs.getInt("id");
			     nicname = rs.getString("nicname");
			     String pwd = "1";
			     String name = rs.getString("name");
			     String gender = rs.getString("gender");
			     int age = rs.getInt("age");
			     String phone = rs.getString("phone");
			     Date regdate = rs.getDate("regdate") ;
			     String email = rs.getString("email");
			     String address = rs.getString("address");
			     String recommendName = rs.getString("recommend_name");
			     int ratingId = rs.getInt("rating_id");
			     int warningCount = rs.getInt("warning_count");
			     
			      u = new User(
			    		 	id,
			    		    nicname,
			    		    pwd,
			    		    name,
			    		    gender,
			    		    age,
			    		    phone,
			    		    regdate,
			    		    email,
			    		    address,
			    		    warningCount,
			    		    recommendName,
			    		    ratingId
			    		    );
			     
			     
			}
			
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return u;
	}


	


	
}