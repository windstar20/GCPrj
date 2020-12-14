package gc.dao.productOrder.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gc.dao.jdbc.DBContext;
import gc.dao.productOrder.PaymentMethodDao;
import gc.entity.productOrder.PaymentMethod;
import gc.entity.productOrder.ProductOrder;

public class JdbcPaymentMethod implements PaymentMethodDao {

	@Override
	public List<PaymentMethod> getList() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = DBContext.URL;
		String sql = "SELECT * FROM PRODUCT_ORDER_LIST_VIEW";

		List<PaymentMethod> list = new ArrayList<>();
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
			    String way;

				
				id = rs.getInt("id");
				
				way = rs.getString("way");

				
				PaymentMethod m = new PaymentMethod(
						id,
						way
						);



				list.add(m);
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
