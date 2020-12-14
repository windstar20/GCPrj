package gc.service.productOrder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gc.dao.productOrder.ProductOrderDao;
import gc.dao.productOrder.jdbc.JdbcProductOrderDao;
import gc.entity.productOrder.ProductOrder;


public class ProductOrderService {

	private ProductOrderDao productOrderDao;

	public ProductOrderService() {
		 productOrderDao = new JdbcProductOrderDao();
	}

	public int insert(ProductOrder productOrder) {

		return productOrderDao.insert(productOrder);
	}

	public int update(ProductOrder productOrder) {
		return productOrderDao.update(productOrder);
	}


	public int delete(int id) {

		return productOrderDao.delete(id);
	}


	public ProductOrder get(int id) {

		return productOrderDao.get(id);
	}

	

	public List<ProductOrder> getList(int page, int size) {

		int startIndex = 0 + (page-1)*size;
		int endIndex = size*page-1;
		
		return productOrderDao.getList(startIndex, endIndex);
	};


	
	public List<ProductOrder> getList(String keyword, List<Integer> orderState, List<Integer> cancelState, Date startDate, Date endDate, int size, Date regdate, String senderName, int totalPrice ) {

		return productOrderDao.getList(totalPrice, totalPrice);
	}
	














}
