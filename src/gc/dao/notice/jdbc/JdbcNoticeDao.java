package gc.dao.notice.jdbc;

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
import gc.dao.notice.NoticeDao;
import gc.entity.notice.Notice;
import gc.entity.notice.view.NoticeView;

public class JdbcNoticeDao implements NoticeDao {

	@Override
	public int insert(Notice notice) {
		int result = 0;

		String url = DBContext.URL;
		String sql = "INSERT INTO NOTICE(TITLE, CONTENT, ADMIN_NICNAME, FILES) VALUES(?,?,?,?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, notice.getTitle());
			st.setString(2, notice.getContent());
			st.setString(3, notice.getAdminNicname());
			st.setString(4, notice.getFiles());

			st.executeUpdate();
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
	public int update(Notice notice) {
		int result = 0;

		String url =  DBContext.URL;
		String sql = "UPDATE NOTICE SET TITLE=?, CONTENT=?, FILES=? WHERE ID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, notice.getTitle()); 
			st.setString(2, notice.getContent());
			st.setString(3, notice.getFiles());
			st.setInt(4, notice.getId());
			
//			ResutlSet rs = st.executeQuery(); // select 문장에만
			st.executeUpdate(); // insert, update, delete 문장일 때
			
			
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
	public int delete(int id) {
		int result = 0;
		
		String url = DBContext.URL;
		String sql = "DELETE NOTICE WHERE ID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
//			ResutlSet rs = st.executeQuery(); // sselect 문장에만
			st.executeUpdate(); // insert, update, delete 문장일 때
			
			
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
	public Notice get(int id) {
		Notice n = null;

		String url = DBContext.URL;
		String sql = "SELECT * FROM NOTICE WHERE ID=" + id;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				Date regDate = rs.getDate("REGDATE");
				String adminNicname = rs.getString("ADMIN_NICNAME");
				 String files = rs.getString("FILES");

				n = new Notice(id, title, content, regDate, adminNicname, files);

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
	public List<Notice> getList() {
		
		return null;
	}

	
	@Override
	public List<Notice> getList(int startIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	   @Override
	   public List<Notice> getList(int startIndex, int endIndex, String field, String query) {
			List<Notice> list = new ArrayList<>(); // ArrayList

			String url = DBContext.URL;
			String sql = "SELECT * " +
		      		"FROM(" +
		      		"		SELECT ROWNUM NUM, N.* " +
		      		" 	FROM(SELECT * FROM NOTICE ORDER BY REGDATE DESC) N"+
		      		") WHERE NUM BETWEEN ? AND ? ";  

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
				PreparedStatement st = con.prepareStatement(sql);;
				st.setInt(1, startIndex);
		        st.setInt(2, endIndex);
		        
		        ResultSet rs = st.executeQuery();
		        
				while (rs.next()) {
					int id = rs.getInt("ID");
					String title = rs.getString("TITLE");
					String content = rs.getString("CONTENT");
					Date regDate = rs.getDate("REGDATE");
					String adminNicname = rs.getString("ADMIN_NICNAME");
					String files = rs.getString("FILES");

					Notice n = new Notice(id, title, content, regDate, adminNicname, files);

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
	   

	   @Override
	   public List<NoticeView> getViewList() {
	      
	      return getViewList(1, 10, "TITLE", "");
	   }

	   @Override
	   public List<NoticeView> getViewList(int startIndex, int endIndex) {
		   
//	      return getViewList(startIndex, endIndex, "TITLE", "");
		   
		   return getViewList(startIndex, endIndex, "TITLE", "");
	   }

	   @Override
	   public List<NoticeView> getViewList(int startIndex, int endIndex, String field, String query) {
	      
	      
	      String sql = "SELECT * " +
	    	      		"FROM(" +
	    	      		"		SELECT ROWNUM NUM, N.* " +
	    	      		" 	FROM(SELECT * FROM NOTICE_VIEW ORDER BY REGDATE DESC) N"+
	    	      		") WHERE NUM BETWEEN ? AND ? ";  
	      
	      String url = DBContext.URL;
	      List<NoticeView> list = new ArrayList<NoticeView>();
	      
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
	         PreparedStatement st = con.prepareStatement(sql);
	         st.setInt(1, startIndex);
	         st.setInt(2, endIndex);
	         
	         ResultSet rs = st.executeQuery();
	         
	         while (rs.next()) {
				String title = rs.getString("TITLE");
				Date regDate = rs.getDate("REGDATE");
				String nicname = rs.getString("NICNAME");
				String files = rs.getString("FILES");

				NoticeView n = new NoticeView(title, regDate, nicname);

				
//				n.setId(id);
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

	@Override
	public Notice getLast() {
		Notice n = null;
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM NOTICE WHERE ID = (SELECT MAX(ID) FROM NOTICE)"; 
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "hm", "1026");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);			
			
			if(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date regDate = rs.getDate("regdate");
				String adminNicname = rs.getString("admin_nicname");
				 String files = rs.getString("files");

				n = new Notice(id, title, content, regDate, adminNicname, files);

							
				
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
	public int display(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int displayAll(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getCount() {
		int count = 0;
		String url = DBContext.URL;
		String sql = "SELECT COUNT(ID) COUNT FROM NOTICE";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();						
			ResultSet rs = st.executeQuery(sql);

			if(rs.next())			
				count = rs.getInt("COUNT");
			
			rs.close();
			st.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return count;
	}
	

	
	
}
