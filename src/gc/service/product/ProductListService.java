package gc.service.product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import gc.entity.Product;

public class ProductListService {

	public List<Product> getList() {
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM PRODUCT";
		
		List<Product> list = new ArrayList<>();		
		
		try {
			//1. ?ìú?ùº?ù¥Î≤? Î°úÎìú?ïòÍ∏?
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. ?ó∞Í≤∞ÌïòÍ∏?
			Connection con = DriverManager.getConnection(url, "hm", "1026");
			//3. Î™ÖÎ†π?ñ¥Î•? ?òÆÍ≤®Ï£ºÍ∏? ?úÑ?ïú Í∞ùÏ≤¥ ?Éù?Ñ±
			Statement st = con.createStatement();
			//4. Í≤∞Í≥ºÏßëÌï© ?Ç¨?ö©?ïòÍ∏?
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				
				int id = rs.getInt("ID");
				String productName = rs.getString("PRODUCT_NAME");
				String brand = rs.getString("BRAND");
				Date regdate = rs.getDate("REGDATE");
				int price = rs.getInt("PRICE");
				 
				Product p = new Product(
						id,
						productName,
						brand,
						regdate,
						price
				 );
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
	
	public int insert(Product product) { //?ûÖ?†•?àò?†ï?Ç≠?†ú?äî Î∞òÌôò?ïò?äî Í∞íÏù¥ ?ûà?ã§. =?†àÏΩîÎìúÍ∞úÏàò
		int result = 0;				     //?ì±Î°? ?éò?ù¥Ïß??óê?Ñú DBÎ°? insert
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "INSERT INTO PRODUCT(PRODUCT_NAME, MANUFACTURER, BRAND, PRODUCT_MODEL, "
				+ "CATEGORY, PRICE, SAVE_POINT, DELIVERY, SUMMARY_EXPLAIN, DETAIL_EXPLAIN) VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "hm", "1026");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, product.getProductName());
			st.setString(2,  product.getManufacturer());
			st.setString(3, product.getBrand());
			st.setString(4, product.getProductModel());
			st.setString(5, product.getCategory());
			st.setInt(6, product.getPrice());
			st.setInt(7, product.getSavePoint());
			st.setString(8, product.getDelivery());
			st.setString(9, product.getSummaryExplain());
			st.setString(10, product.getDetailExplain());
			
			result = st.executeUpdate();			//ResultSet rs = st.executeQuery(sql);   //???†â?ä∏Î¨∏Ïóê?ÑúÎß? ?ã§?ñâ
			
			st.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}	
	
	public Product get(int id) {
		Product p = null;
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM PRODUCT WHERE ID="+id;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "hm", "1026");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if(rs.next()) {
//				int id = rs.getInt("id");
				String productName = rs.getString("product_name");
				String manufacturer = rs.getString("manufacturer");
				String brand = rs.getString("brand");
				String productModel = rs.getString("product_model");
				String category = rs.getString("category");
				int price = rs.getInt("price");
				int savePoint = rs.getInt("save_point");
				String delivery = rs.getString("delivery");
				String summaryExplain = rs.getString("summary_explain");
				String detailExplain = rs.getString("detail_explain");
				
				p = new Product(
						id,
						productName,
						brand,
						manufacturer,
						productModel,
						category,
						price,
						savePoint,
						summaryExplain,
						delivery,
						detailExplain
						);
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
	
	public int update(Product product) { //?ûÖ?†•?àò?†ï?Ç≠?†ú?äî Î∞òÌôò?ïò?äî Í∞íÏù¥ ?ûà?ã§. = ?†àÏΩîÎìúÍ∞úÏàò
		int result = 0;				     //?ì±Î°? ?éò?ù¥Ïß??óê?Ñú DBÎ°? insert
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "UPDATE PRODUCT SET PRODUCT_NAME=?, MANUFACTURER=?, BRAND=?, PRODUCT_MODEL=?"
				+ ", CATEGORY=?, PRICE=?, SAVE_POINT=?, DELIVERY=?, SUMMARY_EXPLAIN=?, DETAIL_EXPLAIN=?"
				+ " WHERE ID=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "hm", "1026");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, product.getProductName());
			st.setString(2,  product.getManufacturer());
			st.setString(3, product.getBrand());
			st.setString(4, product.getProductModel());
			st.setString(5, product.getCategory());
			st.setInt(6, product.getPrice());
			st.setInt(7, product.getSavePoint());
			st.setString(8, product.getDelivery());
			st.setString(9, product.getSummaryExplain());
			st.setString(10, product.getDetailExplain());
			st.setInt(11, product.getId());
			
			result = st.executeUpdate();			//ResultSet rs = st.executeQuery(sql);   //???†â?ä∏Î¨∏Ïóê?ÑúÎß? ?ã§?ñâ
			
			st.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int delete(int id) {
		int result = 0;

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "DELETE FROM PRODUCT WHERE ID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "hm", "1026");
			PreparedStatement st = con.prepareStatement(sql);
			//result=?àò?ñâÍ≤∞Í≥º Î∞òÌôò, executeUpdate()=insert, update, delete ?ùº?ïå ?ã§?ñâ
			st.setInt(1, id);
			
			result = st.executeUpdate(); //?ó¨Í∏∞Ïóê sql ?Ç¨?ö©?ïò?äîÍ±? ?ïÑ?ãò Ï£ºÏùò!!

			//ResultSet rs = st.executeQuery(sql);   //???†â?ä∏Î¨∏Ïóê?ÑúÎß? ?ã§?ñâ

			st.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}

}

