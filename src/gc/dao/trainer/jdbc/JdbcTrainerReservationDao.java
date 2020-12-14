package gc.dao.trainer.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gc.dao.jdbc.DBContext;
import gc.dao.trainer.TrainerReservationDao;
import gc.entity.trainer.Trainer;
import gc.entity.trainer.TrainerReservation;

public class JdbcTrainerReservationDao implements TrainerReservationDao{

	@Override
	public int insert(TrainerReservation trainerReservation) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "INSERT INTO TRAINER_RESERVATION(DATE, TRAINER_ID,MEMBER_ID,NUMBER) VALUE(?,?,?,?)";
		
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setDate(1, (Date) trainerReservation.getDate());
			st.setInt(2, trainerReservation.getTrainerId());
			st.setInt(3, trainerReservation.getMemberId());
			st.setInt(4, trainerReservation.getNumber());
		
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
	public int update(TrainerReservation trainerReservation) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "UPDATE TRAINER_RESERVATION SET DATE=?,TRAINER_ID=? WHERE ID=?";
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setDate(1, (Date) trainerReservation.getDate());
			st.setInt(2, trainerReservation.getTrainerId());
			st.setInt(3, trainerReservation.getId());

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
		String sql = "DELETE FROM TRAINER_RESERVATION WHERE ID=?";
		
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
	public TrainerReservation get(int id) {
		TrainerReservation t = null;
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM TRAINER_RESERVATION WHERE ID="+id;
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Date date = rs.getDate("date");
			    int trainerId = rs.getInt("trainer_id");
			    int memberId = rs.getInt("member_id");
			    Date regdate = rs.getDate("regdate");
			    int number = rs.getInt("number");
				
				t = new TrainerReservation(
						id,
						date,
						trainerId,
						memberId,
						regdate,
						number
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
	public List<TrainerReservation> getList() {
		List<TrainerReservation> list = new ArrayList<>();
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM TRAINER_RESERVATION";
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				Date date = rs.getDate("date");
			    int trainerId = rs.getInt("trainer_id");
			    int memberId = rs.getInt("member_id");
			    Date regdate = rs.getDate("regdate");
			    int number = rs.getInt("number");
				
			    TrainerReservation t = new TrainerReservation(
			    		id,
						date,
						trainerId,
						memberId,
						regdate,
						number
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
