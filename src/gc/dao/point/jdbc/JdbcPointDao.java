package gc.dao.point.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gc.dao.jdbc.DBContext;
import gc.dao.point.PointDao;
import gc.entity.point.Point;
import gc.entity.point.view.PointView;

public class JdbcPointDao implements PointDao{

	@Override
	public int insert(Point Point) {
		int count=0;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "INSERT INTO POINT(MEMBER_ID,CURRENT_AMOUNT) VALUES (?,?)";

		try {
			Class.forName(driver);
			//2. 연결하기
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			//3. 명령어를 옮겨주기 위한 객체 생성
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, Point.getmemberId());
			st.setInt(2, Point.getcurrentAmount());
	
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
	public int update(Point Point) {
		int count=0;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "UPDATE POINT SET MEMBER_ID=?, CURRENT_AMOUNT=?";

		try {
			Class.forName(driver);
			//2. 연결하기
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			//3. 명령어를 옮겨주기 위한 객체 생성
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, Point.getmemberId());
			st.setInt(2, Point.getcurrentAmount());



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
	public int delete(String memberId) {
		int count = 0;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "DELETE FROM POINT WHERE MEMBER_ID="+memberId;

		try {
			Class.forName(driver);
			//2. 연결하기
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			//3. 명령어를 옮겨주기 위한 객체 생성
			PreparedStatement st = con.prepareStatement(sql);

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
	public Point get(String memberId) {
		Point p = null;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "SELECT * FROM POINT WHERE MEMBER_ID="+memberId;


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
				int currentAmount;


				memberId = rs.getString("member_id");
				currentAmount = rs.getInt("current_amount");


				p = new Point(
						currentAmount,
						memberId
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


		return p;
	}

	@Override
	public List<Point> getList() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "SELECT * FROM POINT";

		List<Point> list = new ArrayList<>();
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
				String memberId;
				int currentAmount;


				memberId = rs.getString("member_id");
				currentAmount = rs.getInt("current_amount");


				Point p = new Point(
						currentAmount,
						memberId
						);


				list.add(p);
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
	public PointView getView(String field,String memberId) {
		PointView p = null;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql="";
		if (field.equals("name"))
			sql = "SELECT * FROM POINT_VIEW WHERE NAME="+memberId;
		else
			sql="SELECT * FROM POINT_VIEW WHERE MEMBER_ID="+memberId;
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
				int currentAmount;
				String name;

				memberId = rs.getString("member_id");
				currentAmount = rs.getInt("current_amount");
				name = rs.getString("name");


				p = new PointView(
						currentAmount,
						memberId,
						name
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


		return p;
	}







}
