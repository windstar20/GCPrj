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
import gc.entity.trainer.view.TrainerView;

public class JdbcTrainerDao implements TrainerDao{

	@Override
	public int insert(Trainer trainer) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "INSERT INTO TRAINER(NAME, GYM_NAME, PHONE,GENDER) VALUE(?,?,?,?)";
		
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, trainer.getName());
			st.setString(2, trainer.getGymName());
			st.setString(3, trainer.getPhone());
			st.setString(4, trainer.getGender());
			
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
		String sql = "DELETE FROM TRAINER WHERE ID=?";
		
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
			    String gymName = rs.getString("gym_name");
			    String gender = rs.getString("gender");
			    String phone = rs.getString("phone");
			    String delReason = rs.getString("del_reason");
			    int del = rs.getInt("del");
			    Date regdate = rs.getDate("regdate");
				
				t = new Trainer(
					id,
				    name,
				    gymName,
				    gender,
				    phone,
				    delReason,
				    del,
				    regdate
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
		
		return getList(0,10,"","","",0);
	}

	@Override
	public List<Trainer> getList(int startIndex, int endIndex,int del) {

		return getList(startIndex,endIndex,"","","",del);
	}

	@Override
	public List<Trainer> getList(int startIndex, int endIndex,String name, String gymName, String phone,int del) {
		List<Trainer> list = new ArrayList<>();
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM TRAINER WHERE NAME LIKE '%"+name+"%' AND GYM_NAME LIKE '%"+gymName+"%' AND PHONE LIKE '%"+phone+"%' AND DEL="+del;
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				name = rs.getString("name");
				gymName = rs.getString("gym_name");
			    String gender = rs.getString("gender");
			    phone = rs.getString("phone");
			    String delReason = rs.getString("del_reason");
			    Date regdate = rs.getDate("regdate");
				
				Trainer t = new Trainer(
					id,
				    name,
				    gymName,
				    gender,
				    phone,
				    delReason,
				    del,
				    regdate
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

	@Override
	public TrainerView getView(int id) {
		TrainerView t = null;
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM TRAINER_VIEW WHERE ID="+id;
		
		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url,DBContext.UID,DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String name = rs.getString("name");
			    String gymName = rs.getString("gym_name");
			    String gender = rs.getString("gender");
			    String phone = rs.getString("phone");
			    Date regdate = rs.getDate("regdate");
			    String gymAdress = rs.getString("gym_adress");
				int resCnt = rs.getInt("res_cnt");
				int cmtCnt = rs.getInt("cmt_cnt");
				String license = rs.getString("license");
				String gName = rs.getString("g_name");
				
				t = new TrainerView(
					id,
				    name,
				    gymName,
				    gender,
				    phone,
				    "",
				    0,
				    regdate,
				    gymAdress,
				    resCnt,
				    cmtCnt,
				    license,
				    gName
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

}
