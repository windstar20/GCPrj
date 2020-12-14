package gc.dao.product.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gc.dao.jdbc.DBContext;
import gc.dao.product.BrandDao;
import gc.entity.product.Brand;


public class JdbcBrandDao implements BrandDao {

	@Override
	public int insert(Brand brand) {
		int result = 0;				     
		String url = DBContext.URL;		
		String sql = "INSERT INTO BRAND(BRAND_ID_SEQ.NEXTVAL, NAME "
				+ "VALUES(?,?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, brand.getId());
			st.setString(2, brand.getName());


			result = st.executeUpdate();			//ResultSet rs = st.executeQuery(sql);   //???��?��문에?���? ?��?��

			st.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(Brand brand) {
		int result = 0;				    

		String url = DBContext.URL;
		String sql = "UPDATE BRAND SET NAME=? WHERE ID=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, brand.getName());
			st.setInt(2,  brand.getId());


			result = st.executeUpdate();			//ResultSet rs = st.executeQuery(sql);   //???��?��문에?���? ?��?��

			st.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(int id) {
		int result = 0;				     //?���? ?��?���??��?�� DB�? insert

		String url = DBContext.URL;
		String sql = "DELETE FROM BRAND WHERE ID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);

			result = st.executeUpdate(); 

			st.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<Brand> getList() {
		String url = DBContext.URL;
		String sql = "SELECT * FROM BRAND";

		List<Brand> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");

				Brand b = new Brand(
						id,
						name
						);
				list.add(b);
			}
			rs.close();
			st.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}	
}
