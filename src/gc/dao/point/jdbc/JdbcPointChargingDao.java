package gc.dao.point.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gc.dao.jdbc.DBContext;
import gc.dao.point.PointChargingDao;
import gc.entity.point.PointCharging;
import gc.entity.point.view.PointChargingView;

public class JdbcPointChargingDao implements PointChargingDao{

	@Override
	public int insert(PointCharging pointCharging) {
		int count=0;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "INSERT INTO POINT_CHARGING(MEMBER_ID,CONTENT,AMOUNT) VALUES (?,?,?)";

		try {
			Class.forName(driver);
			//2. 연결하기
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			//3. 명령어를 옮겨주기 위한 객체 생성
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, pointCharging.getmemberNicname());
			st.setString(2, pointCharging.getContent());
			st.setInt(3, pointCharging.getAmount());
	
			count = st.executeUpdate();


			st.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return count;
	}

	@Override
	public int update(PointCharging pointCharging) {
		int count=0;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "UPDATE POINT_CHARGING SET MEMBER_NICNAME=?, CONTENT=?, AMOUNT=?";

		try {
			Class.forName(driver);
			//2. 연결하기
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			//3. 명령어를 옮겨주기 위한 객체 생성
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, pointCharging.getmemberNicname());
			st.setString(2, pointCharging.getContent());
			st.setInt(3, pointCharging.getAmount());



			count = st.executeUpdate();


			st.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public int delete(int id) {
		int count = 0;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "DELETE FROM POINT_CHARGING WHERE ID=?";

		try {
			Class.forName(driver);
			//2. 연결하기
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			//3. 명령어를 옮겨주기 위한 객체 생성
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);

			count = st.executeUpdate();


			st.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public PointCharging get(int id) {
		PointCharging c = null;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "SELECT * FROM POINT_CHARGING WHERE ID="+id;


		//1. 드라이버 로드하기
		try {
			Class.forName(driver);
			//2. 연결하기
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			//3. 명령어를 옮겨주기 위한 객체 생성
			Statement st = con.createStatement();
			//4. 결과집합 사용하기
			ResultSet rs = st.executeQuery(sql);

			if(rs.next()) {
				String memberNicname;
				int amount;
				String content;
				Date regdate;


				id = rs.getInt("id");
				memberNicname = rs.getString("member_nicname");
				amount = rs.getInt("amount");
				content = rs.getString("content");
				regdate = rs.getDate("regdate");


				c = new PointCharging(
						id,
						memberNicname,
						regdate,
						amount,
						content
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


		return c;
	}

	@Override
	public List<PointCharging> getList() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "SELECT * FROM POINT_CHARGING";

		List<PointCharging> list = new ArrayList<>();
		//1. 드라이버 로드하기
		try {
			Class.forName(driver);
			//2. 연결하기
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			//3. 명령어를 옮겨주기 위한 객체 생성
			Statement st = con.createStatement();
			//4. 결과집합 사용하기
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {
				int id;
				String memberNicname;
				int amount;
				String content;
				Date regdate;


				id = rs.getInt("id");
				memberNicname = rs.getString("member_nicname");
				amount = rs.getInt("amount");
				content = rs.getString("content");
				regdate = rs.getDate("regdate");


				PointCharging c = new PointCharging(
						id,
						memberNicname,
						regdate,
						amount,
						content
						);
			



				list.add(c);
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
	public List<PointChargingView> getViewList() {

		return getViewList(0, 0, null, null, null, null,"ID","ASC");
	}

	@Override
	public List<PointChargingView> getViewList(int startIndex, int endIndex) {
		// TODO Auto-generated method stub
		return getViewList(startIndex, endIndex, null, null, null, null,"ID","ASC");
	}

	@Override
	public List<PointChargingView> getViewList(int startIndex, int endIndex, String field, String query, String startDate,
			String endDate) {
		
		return getViewList(startIndex, endIndex, field, query, startDate, endDate, "ID","ASC");
	}

	@Override
	public List<PointChargingView> getViewList(int startIndex, int endIndex, String field, String query,
			String startDate, String endDate, String sortField, String sortOption) {

		LocalDateTime current = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE; // 2020-12-16 형태로 포맷
		String nowDate = "\'"+current.format(formatter)+"\'";
		// 동적 쿼리
		String url = DBContext.URL;
		String sql = "SELECT N.* FROM POINT_CHARGING_VIEW N ";


		
		if(field!=null && query != null && !field.equals("") && !query.equals(""))
			sql +="WHERE "+ field + query;  //F(s,e,f,q)
		
		if(sql.contains("WHERE")) {
			if(startDate==null || startDate.equals("") )
				startDate = "\'2020-12-01\'";
			if(endDate==null || endDate.equals(""))
				endDate = nowDate;
			sql += " AND REGDATE BETWEEN "+startDate + " AND " + endDate; 
		}
		else {
			if(startDate==null || startDate.equals("") )
				startDate = "\'2020-12-01\'";
			if(endDate==null || endDate.equals(""))
				endDate = nowDate;
			sql += " WHERE REGDATE BETWEEN "+startDate + " AND " + endDate; 
			
		}
		
		if(sortField!=null && !sortField.equals("") && sortOption!=null && !sortOption.equals("") ) {
			sql += " ORDER BY "+sortField+" "+sortOption;
		}	
		sql = "SELECT ROWNUM NUM ,M.* FROM ("+sql+") M";
		if(startIndex!=0 && endIndex!=0)
			sql = "SELECT * FROM ("+sql+") "+ "WHERE NUM BETWEEN "+ startIndex +" AND "+endIndex; //F(s,e,null,null)
		System.out.println(sql);
		//	SELECT * FROM PRODUCT_ORDER_VIEW;
		List<PointChargingView> list = new ArrayList<>();
		//1. 드라이버 로드하기
		try {
			Class.forName(DBContext.DRIVER);
			//2. 연결하기
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			//3. 명령어를 옮겨주기 위한 객체 생성
			Statement st = con.createStatement();
			//4. 결과집합 사용하기
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {
				int id;
				String memberNicname;
				int amount;
				String content;
				Date regdate;
				String name;


				id = rs.getInt("id");
				memberNicname = rs.getString("member_nicname");
				amount = rs.getInt("amount");
				content = rs.getString("content");
				regdate = rs.getDate("regdate");
				name = rs.getString("name");


				PointChargingView c = new PointChargingView(
						id,
						memberNicname,
						regdate,
						amount,
						content,
						name
						);
			



				list.add(c);
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
	public List<PointCharging> getList(String nicname) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "SELECT * FROM POINT_CHARGING WHERE MEMBER_NICNAME = '"+nicname+"'";

		List<PointCharging> list = new ArrayList<>();
		//1. 드라이버 로드하기
		try {
			Class.forName(driver);
			//2. 연결하기
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			//3. 명령어를 옮겨주기 위한 객체 생성
			Statement st = con.createStatement();
			//4. 결과집합 사용하기
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {
				int id;
				String memberNicname;
				int amount;
				String content;
				Date regdate;


				id = rs.getInt("id");
				memberNicname = rs.getString("member_nicname");
				amount = rs.getInt("amount");
				content = rs.getString("content");
				regdate = rs.getDate("regdate");


				PointCharging c = new PointCharging(
						id,
						memberNicname,
						regdate,
						amount,
						content
						);
			



				list.add(c);
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
