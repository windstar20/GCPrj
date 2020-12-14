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
import gc.dao.product.ProductImgDao;
import gc.entity.product.ProductImg;

public class JdbcProductImgDao implements ProductImgDao{

	@Override
	public int insert(ProductImg productimg) {
		int result = 0;				     
		String url = DBContext.URL;		
		String sql = "INSERT INTO PRODUCT_IMG(PRODUCT_CODE, NAME, VALUES(?,?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, productimg.getProductCode());
			st.setString(2, productimg.getFileName());


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
	public int update(ProductImg productimg) {
		int result = 0;				    

		String url = DBContext.URL;
		String sql = "UPDATE PRODUCT_IMG SET NAME=? WHERE PRODUCT_CODE=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, productimg.getFileName());
			st.setString(2,  productimg.getProductCode());


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
	public int delete(String productCode) {
		int result = 0;				     

		String url = DBContext.URL;
		String sql = "DELETE FROM PRODUCT_IMG WHERE PRODUCT_CODE=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, productCode);

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
	public ProductImg get(String productCode) {//?��?��?�� ?��?��?��.
		ProductImg p = null;

		String url = DBContext.URL;
		String sql = "SELECT * FROM PRODUCT_IMG WHERE PRODUCT_CODE="+productCode;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {

				String name = rs.getString("NAME");

				p = new ProductImg(productCode, name);
			}
			rs.close();
			st.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return p;

	}	

	@Override
	public List<ProductImg> getList() {
		String url = DBContext.URL;
		String sql = "SELECT * FROM PRODUCT_IMG";

		List<ProductImg> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {
				String productCode = rs.getString("PRODUCT_CODE");
				String name = rs.getString("NAME");

				ProductImg p = new ProductImg(productCode, name);
				list.add(p);
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
