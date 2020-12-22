package gc.dao.productOrder.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import gc.dao.jdbc.DBContext;
import gc.dao.productOrder.ProductOrderDao;
import gc.entity.productOrder.ProductOrder;
import gc.entity.productOrder.view.ProductOrderView;

public class JdbcProductOrderDao implements ProductOrderDao{

	@Override
	public int insert(ProductOrder productOrder) {
		int count=0;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "INSERT INTO PRODUCT_ORDER(SENDER_NAME,SENDER_PHONE,RECEIVER_NAME,RECEIVER_PHONE,RECEIVER_ADDRESS,TOTAL_PRICE, SENDER_EMAIL, BASKET_ID,PAYMENT_METHOD_ID,DELIVERY_MSG) VALUES (?,?,?,?,?,?,?,?,?,?)";

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
			st.setInt(9, productOrder.getPaymentMethodId());
			st.setString(10, productOrder.getDeliveryMsg());
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
		String sql = "UPDATE PRODUCT_ORDER SET SENDER_NAME=?, SENDER_PHONE=?, SENDER_EMAIL=?, RECEIVER_NAME=?, RECEIVER_PHONE=?, RECEIVER_ADDRESS=?, TOTAL_PRICE=? STATE_CODE=?";

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
			st.setInt(7, productOrder.getTotalPrice());
			st.setInt(8, productOrder.getStateCode());


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
				int stateCode;
				int paymentMethodId;
				String deliveryMsg;


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
				stateCode = rs.getInt("stateCode");
				paymentMethodId = rs.getInt("payment_method_id");
				deliveryMsg = rs.getString("delivery_msg");

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
						totalPrice,
						stateCode,
						paymentMethodId,
						deliveryMsg
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
		String sql = "SELECT * FROM PRODUCT_ORDER";

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
				int stateCode;
				int paymentMethodId;
				String deliveryMsg;

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
				stateCode = rs.getInt("stateCode");
				paymentMethodId = rs.getInt("payment_method_id");
				deliveryMsg = rs.getString("delivery_msg");

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
						stateCode,
						paymentMethodId,
						deliveryMsg
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
	public List<ProductOrderView> getViewList() {
		//List<Integer> orderState= new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12));
		
		return getViewList(0, 0, null, null, null, null, null,"number","ASC");

	}

	@Override
	public List<ProductOrderView> getViewList(int startIndex, int endIndex) {
		//List<Integer> orderState= new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12));

		return getViewList(startIndex, endIndex, null, null, null, null, null,"number","ASC");
	}









	@Override
	public List<ProductOrderView> getViewList(int startIndex, int endIndex, String field, String query,
			List<String> orderState, String startDate, String endDate) {
		
		return getViewList(startIndex, endIndex, field, query, orderState, startDate, endDate,"number","ASC");	
	}


	@Override
	public List<ProductOrderView> getViewList(int startIndex, int endIndex, String field, String query,
			List<String> orderState, String startDate, String endDate, String sortField,
			String sortOption) {
	
		LocalDateTime current = LocalDateTime.now().plusDays(1);
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE; // 2020-12-16 형태로 포맷
		String nowDate = "\'"+current.format(formatter)+"\'";
		
		// 동적 쿼리
		String url = DBContext.URL;
		String sql = "SELECT N.* FROM PRODUCT_ORDER_VIEW N ";


		
		if(field!=null && query != null && !field.equals("") && !query.equals(""))
			sql +="WHERE "+ field + query;  //F(s,e,f,q)
		
		if(sql.contains("WHERE")) {
			if(orderState==null || orderState.equals("") )
				orderState = new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12"));
			sql += " AND STATE_CODE IN (";
			
			for (int i=0; i<orderState.size(); i++) {
				if( i!= orderState.size()-1)
				sql += orderState.get(i)+",";
				else
					sql+=orderState.get(i)+")";
			}
		}
		else {
			if(orderState==null || orderState.equals("") )
				orderState = new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12"));
			sql += " WHERE STATE_CODE IN (";
			
			for (int i=0; i<orderState.size(); i++) {
				if( i!= orderState.size()-1)
				sql += orderState.get(i)+",";
				else
					sql+=orderState.get(i)+")";
			}
			
		}
		
		
		if(sql.contains("WHERE")) {
			if(startDate==null || startDate.equals("") )
				startDate = "\'2020-12-01\'";
			if(endDate==null || endDate.equals(""))
				endDate = nowDate;
			sql += " AND REGDATE BETWEEN "+startDate + " AND " + endDate; 
		}
		else {
			if(startDate==null || startDate.equals("") )
				startDate = "\'2020-12-01\'";
			if(endDate==null || endDate.equals(""))
				endDate = nowDate;
			sql += " WHERE REGDATE BETWEEN "+startDate + " AND " + endDate; 
			
		}
		if(sortField!=null && !sortField.equals("") && sortOption!=null && !sortOption.equals("") ) {
			String numberSortField = (sortField.equals("number"))? "\"NUMBER\"": sortField;
			sql += " ORDER BY "+numberSortField+" "+sortOption;
		}	
		
		sql = "SELECT ROWNUM NUM ,M.* FROM ("+sql+") M";
		if(startIndex!=0 && endIndex!=0)
			sql = "SELECT * FROM ("+sql+") "+ " WHERE NUM BETWEEN "+ startIndex +" AND "+endIndex; //F(s,e,null,null)

		
		System.out.println(sql);
		//	SELECT * FROM PRODUCT_ORDER_VIEW;
		List<ProductOrderView> list = new ArrayList<>();
		//1. 드라이버 로드하기
		try {
			Class.forName(DBContext.DRIVER);
			//2. 연결하기
			Connection con = DriverManager.getConnection(url, DBContext.UID, DBContext.PWD);
			//3. 명령어를 옮겨주기 위한 객체 생성


			PreparedStatement st = con.prepareStatement(sql);
			//4. 결과집합 사용하기
			ResultSet rs = st.executeQuery();

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
				int stateCode;
				String state;
				int paymentMethodId;
				String paymentWay;
				String deliveryMsg;

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
				stateCode= rs.getInt("state_code");
				state = rs.getString("state");
				paymentMethodId= rs.getInt("payment_method_id");
				paymentWay = rs.getString("payment_way");
				deliveryMsg = rs.getString("delivery_msg");
				
				ProductOrderView p = new ProductOrderView(
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
						productCount,
						stateCode,
						state,
						paymentMethodId,
						paymentWay,
						deliveryMsg
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











}
