package gc.dao.product.jdbc;

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
import gc.dao.product.ProductDao;
import gc.entity.product.Product;
import gc.entity.product.view.ProductView;



public class JdbcProductDao implements ProductDao{

	@Override
	public int insert(Product product) {
		int result = 0;				     
		String url = DBContext.URL;		
		String sql = "INSERT INTO PRODUCT(ID,NAME, CONTENT, CODE, PRICE, DISPLAY, BRAND_ID, CATEGORY_ID, INVENTORY, DELIVERY_ID )"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, product.getId());
			st.setString(2, product.getName());
			st.setString(3, product.getContent());
			st.setString(4, product.getCode());
			st.setInt(5, product.getPrice());
			st.setInt(6, product.getDisplay());
			st.setInt(7, product.getBrandId());
			st.setInt(8, product.getCategoryId());
			st.setInt(9, product.getInventory());
			st.setInt(10, product.getDeliveryId());

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
	public int update(Product product) {
		int result = 0;				    

		String url = DBContext.URL;
		String sql = "UPDATE PRODUCT SET NAME=?, CONTENT=?, CODE=?, PRICE=?, DISPLAY, "
				+ "BRAND_ID=?, CATEGORY_ID=?, ADMIN_ID=?, INVENTORY=?, DELIVERY_ID"  
				+ "WHERE ID=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, product.getName());
			st.setString(2,  product.getContent());
			st.setString(3, product.getCode());
			st.setInt(4, product.getPrice());
			st.setInt(5, product.getDisplay());
			st.setInt(6, product.getBrandId());
			st.setInt(7, product.getCategoryId());
			st.setInt(8, product.getAdminId());
			st.setInt(9, product.getInventory());
			st.setInt(10, product.getDeliveryId());			
			st.setInt(11, product.getId());

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
		String sql = "DELETE FROM PRODUCT WHERE ID=?";

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
	public Product get(int id) {
		Product p = null;

		String url = DBContext.URL;
		String sql = "SELECT * FROM PRODUCT_VIEW WHERE ID="+id;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {

				String name = rs.getString("NAME");
				String content = rs.getString("CONTENT");
				Date regdate = rs.getDate("REGDATE"); 
				String code = rs.getString("CODE");
				int price = rs.getInt("PRICE");
				int display = rs.getInt("DISPLAY");
				int brandId = rs.getInt("BRAND_ID");
				int categoryId = rs.getInt("CATEGORY_ID");
				int adminId = rs.getInt("ADMIN_ID");
				int inventory = rs.getInt("INVENTORY");
				int delivery = rs.getInt("DELIVERY_ID");

				p = new Product(
						id,
						name,
						content,
						regdate,	    
						code,
						price,
						display,
						brandId,
						categoryId,
						adminId,
						inventory,
						delivery
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

	@Override
	public List<Product> getList() {
		String url = DBContext.URL; //\"user\"
		String sql = "SELECT * FROM PRODUCT";

		List<Product> list = new ArrayList<>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String content = rs.getString("CONTENT");
				Date regdate = rs.getDate("REGDATE");
				String code = rs.getString("CODE");
				int price = rs.getInt("PRICE");
				int display = rs.getInt("DISPLAY");
				int brandId = rs.getInt("BRAND_ID");
				int categoryId = rs.getInt("CATEGORY_ID");
				int adminId = rs.getInt("ADMIN_ID");
				int inventory = rs.getInt("INVENTORY");
				int delivery = rs.getInt("DELIVERY_ID");

				Product p = new Product(
						id,
						name,
						content,
						regdate,	    
						code,
						price,
						display,
						brandId,
						categoryId,
						adminId,
						inventory,
						delivery
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

	@Override
	public int deleteAll(int[] ids) {
		int result = 0;				     //?���? ?��?���??��?�� DB�? insert

		String url = DBContext.URL;
		String sql = "DELETE FROM PRODUCT WHERE ID=";

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
	public int display(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int displayAll(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	@Override //게시된 ID의 수 구하기: 게시물의 전체 수.
	public int getCount() {
		int count = 0;
		String url = DBContext.URL;
		String sql = "SELECT COUNT(ID) COUNT FROM PRODUCT_VIEW";
		
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
	

	@Override
	public List<ProductView> getViewList() {
		
		return getViewList(0, 0, null, null, null, null);

	}

	@Override
	public List<ProductView> getViewList(int startIndex, int endIndex) {
		
		return getViewList(startIndex, endIndex, null, null,null,null);
	}
	
	/*
	 * SELECT * FROM (SELECT ROWNUM NUM, V.* FROM(SELECT * FROM PRODUCT_VIEW ORDER
	 * BY ID) V) WHERE NUM BETWEEN 1 AND 5 AND NAME LIKE '%컴%';
	 */
	

	@Override
	public List<ProductView> getViewList(int startIndex, int endIndex, String keyword, String query, String prevPrice, String nextPrice) {
		String url = DBContext.URL;
		String sql = "SELECT * FROM(SELECT ROWNUM NUM, V.* "
					   +" FROM(SELECT * FROM PRODUCT_VIEW ORDER BY ID) V"
					   + ") WHERE NUM BETWEEN "+ startIndex + " AND "+ endIndex;				
		
		String keywordSql = null;
		String priceSql = null;
		
		if(keyword != null && !keyword.equals("")) {
			if(keyword.equals("name")) {
				keywordSql = " AND "+keyword +" LIKE '%"+query+"%'"; 
			} else if(keyword.equals("inventory")) {
				keywordSql = " AND "+keyword +" < "+query;
			} else {
				keywordSql = " AND "+keyword +" LIKE '%"+query+"%'";
			}			 
		}
//		AND price > 30000 AND price < 70000;
//		 && (nextPrice == null && nextPrice.equals("")))
		  if(prevPrice != null && !prevPrice.equals("")) { 
			  priceSql = " AND PRICE >= " +prevPrice; }
		  else if((prevPrice != null && !prevPrice.equals("")) && (nextPrice != null && !nextPrice.equals(""))){ 
			  priceSql = " AND PRICE >= " +prevPrice+" AND PRICE =< " +nextPrice;
		  } else if(nextPrice != null && !nextPrice.equals("")){ 
			  priceSql = " AND PRICE =< " +nextPrice; 
		  }
		 
		
//		 if((keyword==null && query.equals("")) && (fromPrice != null && !prevQuery.equals(""))) 
		if(keyword!=null && !query.equals("")) {
			sql += keywordSql;
		}else if((prevPrice != null && !prevPrice.equals("")) || (nextPrice != null && !nextPrice.equals(""))){
			sql += priceSql;
		}
		System.out.println(sql);
//		else {
//			sql += priceSql;
//		}
		
		
		
		List<ProductView> list = new ArrayList<>();
		System.out.println("query "+ query);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {
				int id = rs.getInt("ID");              
				String name = rs.getString("NAME");
				Date regdate = rs.getDate("REGDATE");
				String brand = rs.getString("BRAND");
				String category = rs.getString("CATEGORY");
				String code = rs.getString("CODE");
				int price = rs.getInt("PRICE");
				int display = rs.getInt("DISPLAY");
				int inventory = rs.getInt("INVENTORY");
				String delivery = rs.getString("DELIVERY");
				String fileName = rs.getString("FILE_NAME");			

				ProductView p = new ProductView(
						id, 
						name, 
						regdate,              
						code, 
						price, 
						display, 
						inventory, 
						brand, 
						category, 
						delivery, 
						fileName
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

	@Override
	public Product getLast() {
		Product p = null;
		
		String url = DBContext.URL;
		String sql = "SELECT * FROM PRODUCT WHERE ID = (SELECT MAX(ID) FROM PRODUCT)";

		try {
			Class.forName(DBContext.DRIVER);
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String content = rs.getString("CONTENT");
				Date regdate = rs.getDate("REGDATE"); 
				String code = rs.getString("CODE");
				int price = rs.getInt("PRICE");
				int display = rs.getInt("DISPLAY");
				int brandId = rs.getInt("BRAND_ID");
				int categoryId = rs.getInt("CATEGORY_ID");
				int adminId = rs.getInt("ADMIN_ID");
				int inventory = rs.getInt("INVENTORY");
				int delivery = rs.getInt("DELIVERY_ID");

				p = new Product(
						id,
						name,
						content,
						regdate,	    
						code,
						price,
						display,
						brandId,
						categoryId,
						adminId,
						inventory,
						delivery
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

}
