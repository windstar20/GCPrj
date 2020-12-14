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
		String sql = "INSERT INTO MEMBER(NICNAME,PWD,NAME,GENDER,AGE,PHONE,EMAIL,ADDRESS,RECOMMEND_NAME)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)"; 
		
		try {   
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(0, user.getNicname());
			st.setString(1, user.getPwd());
			st.setString(2, user.getName());
			st.setString(3, user.getGender());
			st.setInt(4, user.getAge());
			st.setString(5, user.getPhone());
			st.setString(6, user.getEmail());
			st.setString(7, user.getAddress());
			st.setString(8, user.getRecommendName());
			
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
		String sql = "UPDATE NOTICE SET TITLE=?, CONTENT=? WHERE ID=?";
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			
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
		
		return 0;
	}

	

	@Override
	public User get(int id) {
		User u = null;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "SELECT * FROM MEMBER WHERE ID="+id; 
	
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			
			if(rs.next()){
				 String nicname = rs.getNString("nicname");
			     String pwd = rs.getNString("pwd");
			     String name = rs.getNString("name");
			     String gender = rs.getNString("gender");
			     int age = rs.getInt("age");
			     String phone = rs.getNString("phone");
			     Date regdate = rs.getDate("regdate") ;
			     String email = rs.getNString("email");
			     String address = rs.getNString("address");
			     String recommendName = rs.getString("recommend_Name");
			     int ratingId = rs.getInt("rating_id");
			     
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
		String sql = "SELECT * FROM MEMBER"; 
	
		List<User>list = new ArrayList<>();
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			
			while(rs.next()){
				 int id = rs.getInt("id");
			     String nicname = rs.getNString("nicname");
			     String pwd = rs.getNString("pwd");
			     String name = rs.getNString("name");
			     String gender = rs.getNString("gender");
			     int age = rs.getInt("age");
			     String phone = rs.getNString("phone");
			     Date regdate = rs.getDate("regdate") ;
			     String email = rs.getNString("email");
			     String address = rs.getNString("address");
			     String recommendName = rs.getString("recommend_name");
			     int ratingId = rs.getInt("rating_id");
			     
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
	public User overlapId(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User overlapNicName(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User overlapEmail(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User recomCheck(User user) {
		// TODO Auto-generated method stub
		return null;
	}


	
}