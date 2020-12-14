package gc.dao.productOrder.jdbc;

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
import gc.dao.productOrder.ProductOrderDao;
import gc.dao.productOrder.entity.ProductOrderView;
import gc.entity.productOrder.ProductOrder;

public class JdbcProductOrderDao implements ProductOrderDao{

	@Override
	public int insert(ProductOrder productOrder) {
		int count=0;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "INSERT INTO PRODUCT_ORDER(SENDER_NAME,SENDER_PHONE,RECEIVER_NAME,RECEIVER_PHONE,RECEIVER_ADDRESS,TOTAL_PRICE, SENDER_EMAIL, BASKET_ID) VALUES (?,?,?,?,?,?,?,?)";

		try {
			Class.forName(driver);
			//2. 연결하기
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			//3. 명령어를 옮겨주기 위한 객체 생성
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, productOrder.getSenderName());
			st.setString(2, productOrder.getSenderPhone());
			st.setString(3, productOrder.getReceiverName());
			st.setString(4, productOrder.getReceiverPhone());
			st.setString(5, productOrder.getReceiverAddress());
			st.setInt(6, productOrder.getTotalPrice());
			st.setString(7, productOrder.getSenderEmail());
			st.setInt(8, productOrder.getBasketId());
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
public int update(ProductOrder productOrder) {
	int count=0;

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = DBContext.URL;
	String sql = "UPDATE PRODUCT_ORDER SET SENDER_NAME=?, SENDER_PHONE=?, SENDER_EMAIL=?, RECEIVER_NAME=?, RECEIVER_PHONE=?, RECEIVER_ADDRESS=?";

	try {
		Class.forName(driver);
		//2. 연결하기
		Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
		//3. 명령어를 옮겨주기 위한 객체 생성
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, productOrder.getSenderName());
		st.setString(2, productOrder.getSenderPhone());
		st.setString(3, productOrder.getSenderEmail());
		st.setString(4, productOrder.getReceiverName());
		st.setString(5, productOrder.getReceiverPhone());
		st.setString(6, productOrder.getReceiverAddress());
		

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
	String sql = "DELETE FROM PRODUCT_ORDER WHERE ID=?";

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
public ProductOrder get(int id) {
	ProductOrder p = null;

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = DBContext.URL;
	String sql = "SELECT * FROM PRODUCT_ORDER WHERE ID="+id;


	List<ProductOrder> list = new ArrayList<>();
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
		    int number;
		    int basketId;
		    String senderName;
		    String senderPhone;
		    String senderEmail;
		    String receiverName;
		    String receiverPhone;
		    String receiverAddress;
		    Date regdate;
		    int totalPrice;

			
			id = rs.getInt("id");
			number = rs.getInt("\"NUMBER\"");
			basketId = rs.getInt("basket_id");
			senderName = rs.getString("sender_name");
			senderPhone = rs.getString("sender_phone");
			senderEmail = rs.getString("sender_email");
			receiverName = rs.getString("receiver_name");
			receiverPhone = rs.getString("receiver_phone");
			receiverAddress = rs.getString("receiver_address");
			regdate = rs.getDate("regdate");
			totalPrice = rs.getInt("total_price");

			
			p = new ProductOrder(
					id,
					number,
					basketId,
					senderName,
					senderPhone,
					senderEmail,
					receiverName,
					receiverPhone,
					receiverAddress,
					regdate,
					totalPrice
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
public List<ProductOrder> getList() {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = DBContext.URL;
	String sql = "SELECT * FROM PRODUCT_ORDER_VIEW";

	List<ProductOrder> list = new ArrayList<>();
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
		    int number;
		    int basketId;
		    String senderName;
		    String senderPhone;
		    String senderEmail;
		    String receiverName;
		    String receiverPhone;
		    String receiverAddress;
		    Date regdate;
		    int totalPrice;
		    String productName;
		    int productCount;

			
			id = rs.getInt("id");
			number = rs.getInt("\"NUMBER\"");
			basketId = rs.getInt("basket_id");
			senderName = rs.getString("sender_name");
			senderPhone = rs.getString("sender_phone");
			senderEmail = rs.getString("sender_email");
			receiverName = rs.getString("receiver_name");
			receiverPhone = rs.getString("receiver_phone");
			receiverAddress = rs.getString("receiver_address");
			regdate = rs.getDate("regdate");
			totalPrice = rs.getInt("total_price");
			productName = rs.getString("product_name");
			productCount= rs.getInt("product_count");

			
			ProductOrder p = new ProductOrder(
					id,
					number,
					basketId,
					senderName,
					senderPhone,
					senderEmail,
					receiverName,
					receiverPhone,
					receiverAddress,
					regdate,
					totalPrice,
					productName,
					productCount
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
public List<ProductOrder> getList(int startIndex, int endIndex) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public List<ProductOrder> getList(int startIndex) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public List<ProductOrderView> getViewList(int statrtIndex, int endIndex) {
	// TODO Auto-generated method stub
	return null;
}



}
