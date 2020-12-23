package gc.dao.productOrder.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gc.dao.jdbc.DBContext;
import gc.dao.productOrder.ProductBasketItemDao;
import gc.entity.productOrder.ProductBasketItem;

public class JdbcProductBasketItem implements ProductBasketItemDao{

	@Override
	public int insert(ProductBasketItem productBasketItem) {
		int count=0;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "INSERT INTO PRODUCT_BASKET_ITEM(BASKET_ID,PRODUCT_CODE,COUNT,SUM_PRICE,BUY) VALUES (?,?,?,?,'NO')";

		try {
			Class.forName(driver);
			//2. 연결하기
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			//3. 명령어를 옮겨주기 위한 객체 생성
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, productBasketItem.getBasketId());
			st.setString(2, productBasketItem.getProductCode());
			st.setInt(3, productBasketItem.getCount());
			st.setInt(4, productBasketItem.getSumPrice());

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
	public int update(ProductBasketItem productBasketItem) {
		int count=0;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "UPDATE PRODUCT_BASKET_ITEM SET BASKET_ID=?,PRODUCT_CODE=?,COUNT=?,SUM_PRICE=?,BUY=?";

		try {
			Class.forName(driver);
			//2. 연결하기
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			//3. 명령어를 옮겨주기 위한 객체 생성
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, productBasketItem.getBasketId());
			st.setString(2, productBasketItem.getProductCode());
			st.setInt(3, productBasketItem.getCount());
			st.setInt(4, productBasketItem.getSumPrice());
			st.setString(5, productBasketItem.getBuy());


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
	public int delete(int basketId, String productCode) {
		int count = 0;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "DELETE FROM PRODUCT_BASKET_ITEM WHERE BASKET_ID=? AND PRODUCT_CODE=?";

		try {
			Class.forName(driver);
			//2. 연결하기
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			//3. 명령어를 옮겨주기 위한 객체 생성
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, basketId);
			st.setString(1, productCode);

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
	public ProductBasketItem get(int basketId, String productCode) {
		ProductBasketItem p = null;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "SELECT * FROM PRODUCT_BASKET_ITEM WHERE WHERE BASKET_ID="+basketId+" AND PRODUCT_CODE="+productCode;


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
				int count;
				int sumPrice;
				String buy;


				basketId = rs.getInt("basket_id");
				productCode= rs.getString("sender_phone");
				count = rs.getInt("count");
				sumPrice = rs.getInt("sum_price");
				buy = rs.getString("buy");

				p = new ProductBasketItem(
						basketId,
						productCode,
						count,
						sumPrice,
						buy
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
	public List<ProductBasketItem> getList() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "SELECT * FROM PRODUCT_BASKET_ITEM";

		List<ProductBasketItem> list = new ArrayList<>();
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
				int basketId;
				String productCode;
				int count;
				int sumPrice;
				String buy;


				basketId = rs.getInt("basket_id");
				productCode= rs.getString("sender_phone");
				count = rs.getInt("count");
				sumPrice = rs.getInt("sum_price");
				buy = rs.getString("buy");

				ProductBasketItem p = new ProductBasketItem(
						basketId,
						productCode,
						count,
						sumPrice,
						buy
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


		return list;

	}

	@Override
	public ProductBasketItem getOnePersonList(int basketId) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "SELECT * FROM PRODUCT_BASKET_ITEM WHERE BASKET_ID="+basketId;

		List<ProductBasketItem> list = new ArrayList<>();
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
				String productCode;
				int count;
				int sumPrice;
				String buy;


				basketId = rs.getInt("basket_id");
				productCode= rs.getString("sender_phone");
				count = rs.getInt("count");
				sumPrice = rs.getInt("sum_price");
				buy = rs.getString("buy");

				ProductBasketItem p = new ProductBasketItem(
						basketId,
						productCode,
						count,
						sumPrice,
						buy
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


		return list;

	}

}
