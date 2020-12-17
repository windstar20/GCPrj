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
import gc.dao.product.ProductTasteDao;
import gc.entity.product.ProductTaste;


public class JdbcProductTasteDao implements ProductTasteDao{

	@Override
	public int insert(ProductTaste productTaste) {
		int result = 0;				     
		String url = DBContext.URL;		
		String sql = "INSERT INTO PRODUCT_TASTE(PRODUCT_CODE, NAME )"
				+ "VALUES(?,?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, productTaste.getProductCode());
			st.setString(2, productTaste.getName());


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
	public int update(ProductTaste productTaste) {
		int result = 0;				    

		String url = DBContext.URL;
		String sql = "UPDATE PRODUCT_TASTE SET NAME=? WHERE PRODUCT_CODE=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, productTaste.getName());
			st.setString(2,  productTaste.getProductCode());


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
		String sql = "DELETE FROM PRODUCT_TASTE WHERE PRODUCT_CODE=?";

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
	public List<ProductTaste> getList() {
		String url = DBContext.URL;
		String sql = "SELECT * FROM PRODUCT_TASTE";

		List<ProductTaste> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {
				String productCode = rs.getString("PRODUCT_CODE");
				String name = rs.getString("NAME");

				ProductTaste p = new ProductTaste(productCode, name);
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

	@Override
	public ProductTaste get(String productCode) {
		ProductTaste p = null;

		String url = DBContext.URL;
		String sql = "SELECT * FROM PRODUCT_TASTE WHERE PRODUCT_CODE="+productCode;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {

				String name = rs.getString("NAME");

				p = new ProductTaste(productCode, name);
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
		
}
