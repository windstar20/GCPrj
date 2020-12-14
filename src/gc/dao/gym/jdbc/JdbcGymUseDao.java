package gc.dao.gym.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gc.dao.gym.GymUseDao;
import gc.dao.jdbc.DBContext;
import gc.entity.gym.GymUse;


public class JdbcGymUseDao implements GymUseDao {
	
	@Override
	public List<GymUse> getList() {
		
			List<GymUse> list = new ArrayList<>();
			
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = DBContext.URL;
			String sql = "SELECT * FROM GYM";
			
			try {
				Class.forName(driver);
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

	@Override
	public GymUse get(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int insert(GymUse gymUse) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(GymUse gymUse) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(GymUse id) {
		// TODO Auto-generated method stub
		return 0;
	}



}
