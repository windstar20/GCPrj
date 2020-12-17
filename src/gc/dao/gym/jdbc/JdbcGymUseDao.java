package gc.dao.gym.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gc.dao.gym.GymUseDao;
import gc.dao.jdbc.DBContext;
import gc.entity.gym.GymUse;
import gc.entity.trainer.TrainerUse;


public class JdbcGymUseDao implements GymUseDao {
	
	@Override
	public int insert(GymUse gymUse) {
		
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "INSERT INTO GYM_USE(RESERVATION_NUMBER, DATE) VALUE(?,?)";
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, gymUse.getReservationNumber());
			st.setDate(2, (Date) gymUse.getDate());
			
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
	public int update(GymUse gymUse) {
		
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "UPDATE GYM_USE SET DATE=? WHERE RESERVATION_NUMBER=?";
		
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setDate(1, (Date) gymUse.getDate());
			st.setInt(2, gymUse.getReservationNumber());
			
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
	public int delete(int reservationNumber) {
		
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "DELETE FROM GYM_USE WHERE RESERVATION_NUMBER=?";
		
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, reservationNumber);
			
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
	public GymUse get(int reservationNumber) {
		
		GymUse g = null;
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM GYM_USE WHERE RESERVATION_NUMBER="+reservationNumber;
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Date date = rs.getDate("date");
				
				g = new GymUse(
						reservationNumber,
						date
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
	public List<GymUse> getList() {
		
			List<GymUse> list = new ArrayList<>();
			
			String url = DBContext.URL;
			String sql = "SELECT * FROM GYM_USE";
			
			try {
				Class.forName(DBContext.DRIVER);
				Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				while(rs.next()) {
					
					int reservationNumber = rs.getInt("reservation_Number");
					Date date = rs.getDate("date");
						
					GymUse g = new GymUse(
							reservationNumber,
							date
							
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


}
