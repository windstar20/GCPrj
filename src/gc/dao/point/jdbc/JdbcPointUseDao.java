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
import gc.dao.point.PointUseDao;
import gc.entity.point.PointUse;
import gc.entity.point.view.PointUseView;

public class JdbcPointUseDao implements PointUseDao{

	@Override
	public int insert(PointUse PointUse) {
		int count=0;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "INSERT INTO POINT_USE(MEMBER_NICNAME,CONTENT,AMOUNT) VALUES (?,?,?)";

		try {
			Class.forName(driver);
			//2. 연결하기
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			//3. 명령어를 옮겨주기 위한 객체 생성
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, PointUse.getMemberNicname());
			st.setString(2, PointUse.getContent());
			st.setInt(3, PointUse.getAmount());
	
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
	public int update(PointUse PointUse) {
		int count=0;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "UPDATE POINT_USE SET MEMBER_NICNAME=?, CONTENT=?, AMOUNT=?";

		try {
			Class.forName(driver);
			//2. 연결하기
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			//3. 명령어를 옮겨주기 위한 객체 생성
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, PointUse.getMemberNicname());
			st.setString(2, PointUse.getContent());
			st.setInt(3, PointUse.getAmount());



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
		String sql = "DELETE FROM POINT_USE WHERE ID=?";

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
	public PointUse get(int id) {
		PointUse c = null;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "SELECT * FROM POINT_USE WHERE ID="+id;


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


				c = new PointUse(
						id,
						regdate,
						amount,
						content,
						memberNicname
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
	public List<PointUse> getList() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "SELECT * FROM POINT_USE";

		List<PointUse> list = new ArrayList<>();
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


				PointUse c = new PointUse(
						id,
						regdate,
						amount,
						content,
						memberNicname
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
	public List<PointUseView> getViewList() {

		return getViewList(0, 0, null, null, null, null,"ID","ASC");
	}

	@Override
	public List<PointUseView> getViewList(int startIndex, int endIndex) {
		// TODO Auto-generated method stub
		return getViewList(startIndex, endIndex, null, null, null, null,"ID","ASC");
	}

	@Override
	public List<PointUseView> getViewList(int startIndex, int endIndex, String field, String query, String startDate,
			String endDate) {
		

		return getViewList(startIndex, endIndex, field, query, startDate, endDate,"ID","ASC");
	}

	@Override
	public List<PointUseView> getViewList(int startIndex, int endIndex, String field, String query, String startDate,
			String endDate, String sortField, String sortOption) {

		LocalDateTime current = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE; // 2020-12-16 형태로 포맷
		String nowDate = "\'"+current.format(formatter)+"\'";
		// 동적 쿼리
		String url = DBContext.URL;
		String sql = "SELECT N.* FROM POINT_USE_VIEW N ";


		
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
		List<PointUseView> list = new ArrayList<>();
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


				PointUseView c = new PointUseView(
						id,
						regdate,
						amount,
						content,
						memberNicname,
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
	public List<PointUse> getList(String nicname) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "SELECT * FROM POINT_USE WHERE MEMBER_NICNAME ='"+nicname+"'";

		List<PointUse> list = new ArrayList<>();
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


				PointUse c = new PointUse(
						id,
						regdate,
						amount,
						content,
						memberNicname
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
