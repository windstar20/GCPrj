package gc.dao.gym.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gc.dao.gym.GymReservationDao;
import gc.dao.jdbc.DBContext;
import gc.entity.gym.GymReservation;
import gc.entity.trainer.TrainerReservation;

public class JdbcGymReservationDao implements GymReservationDao{
	
	@Override
	public int insert(GymReservation gymReservation) {
		
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "INSERT INTO GYM_RESERVATION(PRICE, USER_ID, GYM_ID, MEMEBER_ID, NUMBER, DATE) VALUE(?,?,?,?,?,?)";
		
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, gymReservation.getPrice());
			st.setInt(2, gymReservation.getUserId());
			st.setInt(3, gymReservation.getGymId());
			st.setInt(4, gymReservation.getMemberId());
			st.setInt(5, gymReservation.getNumber());
			st.setDate(6, (Date) gymReservation.getDate());
		
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
	public int update(GymReservation gymReservation) {
		
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "UPDATE GYM_RESERVATION SET PRICE=?,USER_ID=?,GYM_ID=?, MEMBER_ID=?, NUMBER=?,DATE=? WHERE ID=?";
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, gymReservation.getPrice());
			st.setInt(2, gymReservation.getUserId());
			st.setInt(3, gymReservation.getGymId());
			st.setInt(4, gymReservation.getMemberId());
			st.setInt(5, gymReservation.getNumber());
			st.setDate(6, (Date) gymReservation.getDate());

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
		String sql = "DELETE FROM GYM_RESERVATION WHERE ID=?";
		
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
	public GymReservation get(int id) {
		
		GymReservation g = null;
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM GYM_RESERVATION WHERE ID="+id;
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int price = rs.getInt("price");
			    int userId = rs.getInt("user_id");
			    int gymId = rs.getInt("gym_id");
			    int memberId = rs.getInt("member_id");
			    int number = rs.getInt("number");
			    Date regdate = rs.getDate("regdate");
			    Date date = rs.getDate("date");
			  			
				g = new GymReservation(
						id,
						price,
						userId,
						gymId,
						memberId,
						number,
						regdate,
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
	public List<GymReservation> getList() {
		
		List<GymReservation> list = new ArrayList<>();
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM GYM_RESERVATION";
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				int price = rs.getInt("price");
			    int userId = rs.getInt("user_id");
			    int gymId = rs.getInt("gym_id");
			    int memberId = rs.getInt("member_id");
			    int number = rs.getInt("number");
			    Date regdate = rs.getDate("regdate");
			    Date date = rs.getDate("date");
			  			
				GymReservation g = new GymReservation(
						id,
						price,
						userId,
						gymId,
						memberId,
						number,
						regdate,
						date
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
