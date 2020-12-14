package gc.dao.notice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gc.dao.jdbc.DBContext;
import gc.dao.notice.NoticeFilesDao;
import gc.entity.notice.NoticeFiles;

public class JdbcNoticeFilesDao implements NoticeFilesDao {

	@Override
	public int insert(NoticeFiles noticeFiles) {
		int result = 0;

		String url = DBContext.URL;
		String sql = "INSERT INTO NOTICE_FILES(NOTICE_ID, FILE_NAME) VALUES(?,?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, noticeFiles.getNoticeid());
			st.setString(2, noticeFiles.getFileName());

//				ResutlSet rs = st.executeQuery(); // sselect 문장?���?
			st.executeUpdate(); // insert, update, delete 문장?�� ?��

//				rs.close();
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
	public int update(NoticeFiles noticeFiles) {
		int result = 0;

		String url =  DBContext.URL;
		String sql = "UPDATE NOTICE_FILES SET NOTICE_ID=?, FILE_NAME=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, noticeFiles.getNoticeid());
			st.setString(2, noticeFiles.getFileName());
			
//			ResutlSet rs = st.executeQuery(); // sselect 문장?���?
			st.executeUpdate(); // insert, update, delete 문장?�� ?��
			
			
//			rs.close();
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
	public int delete(int noticeId) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "DELETE NOTICE_FIELS WHERE NOTICE_ID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, noticeId);
			
//			ResutlSet rs = st.executeQuery(); // sselect 문장?���?
			st.executeUpdate(); // insert, update, delete 문장?�� ?��
			
			
//			rs.close();
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
	public NoticeFiles get(int noticeId) {
		NoticeFiles n = null;

		String url = DBContext.URL;
		String sql = "SELECT * FROM NOTICE_FIELS WHERE NOTICE_ID=" + noticeId;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				String fileName = rs.getString("file_name");

				n = new NoticeFiles(noticeId, fileName);

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
		return n;
	}

	@Override
	public List<NoticeFiles> getList() {
		List<NoticeFiles> list = new ArrayList<>(); // ArrayList

		String url = DBContext.URL;
		String sql = "SELECT * FROM NOTICE_FIELS";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int noticeId = rs.getInt("notice_id");
				String fileName = rs.getString("file_name");

				NoticeFiles n = new NoticeFiles(noticeId, fileName);

				list.add(n);
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
