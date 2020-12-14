package gc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gc.entity.Product;
import gc.entity.User;

public class UserService {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
	public List<User> getList() {
		
		String sql = "SELECT * FROM USER_MEMBER";
		
		List<User> list = new ArrayList<>();
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, "hm", "1026");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String pwd = rs.getString("pwd");
				String nicname = rs.getString("nicname");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String birthday = rs.getString("birthday");
				String phone = rs.getString("phone");
				String postcode = rs.getString("postcode");
				String adress = rs.getString("adress");
				String frend = rs.getString("frend");
				String hPurpose = rs.getString("h_purpose");
				int hHour = rs.getInt("h_hour");
				String hStyle = rs.getString("h_style");
				String hVolume = rs.getString("h_volume");
				String leave = rs.getString("leave");
				
				User m = new User();
				m.setId(id);
				m.setPwd(pwd);
				m.setName(name);
				m.setNicname(nicname);
				m.setGender(gender);
				m.setAge(age);
				m.setEmail(email);
				m.setBirthday(birthday);
				m.setPhone(phone);				
				m.setPostcode(postcode); 
				m.setAdress(adress); 
				m.setFrend(frend); 
				m.sethPurpose(hPurpose);
				m.sethHour(hHour);
				m.sethStyle(hStyle);
				m.sethVolume(hVolume);
				m.setLeave(leave);
				
				list.add(m);
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

	public List<User> getLeaveList() {
		String sql = "SELECT * FROM USER_MEMBER	WHERE LEAVE='true'";
		
		List<User> list = new ArrayList<>();
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, "hm", "1026");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String pwd = rs.getString("pwd");
				String nicname = rs.getString("nicname");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String birthday = rs.getString("birthday");
				String phone = rs.getString("phone");
				String postcode = rs.getString("postcode");
				String adress = rs.getString("adress");
				String frend = rs.getString("frend");
				String hPurpose = rs.getString("h_purpose");
				int hHour = rs.getInt("h_hour");
				String hStyle = rs.getString("h_style");
				String hVolume = rs.getString("h_volume");
				String leave = rs.getString("leave");
				
				User m = new User();
				m.setId(id);
				m.setPwd(pwd);
				m.setName(name);
				m.setNicname(nicname);
				m.setGender(gender);
				m.setAge(age);
				m.setEmail(email);
				m.setBirthday(birthday);
				m.setPhone(phone);				
				m.setPostcode(postcode); 
				m.setAdress(adress); 
				m.setFrend(frend); 
				m.sethPurpose(hPurpose);
				m.sethHour(hHour);
				m.sethStyle(hStyle);
				m.sethVolume(hVolume);
				m.setLeave(leave);
				
				list.add(m);
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

	public int delete(int id) {
		int result = 0;
		
		String sql = "DELETE FROM USER_MEMBER WHERE ID=?";
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, "hm", "1026");
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

	public List<User> get(String nicname) {
		List<User> list = new ArrayList<>();
		
		String sql = "SELECT * FROM USER_MEMBER WHERE NICNAME='"+nicname+"'";
		
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, "hm", "1026");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				int id = rs.getInt("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String birthday = rs.getString("birthday");
				String phone = rs.getString("phone");
				String postcode = rs.getString("postcode");
				String adress = rs.getString("adress");
				String frend = rs.getString("frend");
				String hPurpose = rs.getString("h_purpose");
				int hHour = rs.getInt("h_hour");
				String hStyle = rs.getString("h_style");
				String hVolume = rs.getString("h_volume");
				String leave = rs.getString("leave");
				
				User m = new User(
					id,
				    pwd,
				    nicname,
				    name,
				    gender,
				    age,
				    email,
				    birthday,
				    phone,
				    postcode,
				    adress,
				    frend,
				    hPurpose,
				    hHour,
				    hStyle,
				    hVolume,
				    leave
				);
				
				list.add(m);
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
