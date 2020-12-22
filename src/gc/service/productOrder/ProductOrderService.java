package gc.service.productOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gc.dao.productOrder.ProductOrderDao;
import gc.dao.productOrder.jdbc.JdbcProductOrderDao;
import gc.entity.productOrder.ProductOrder;
import gc.entity.productOrder.view.ProductOrderView;


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



	public List<ProductOrder> getList() {


		return productOrderDao.getList();
	};

	public List<ProductOrderView> getViewList() {

		return productOrderDao.getViewList();
	};

	public List<ProductOrderView> getViewList(int page, int size) {

		int startIndex = 1 + (page-1)*size;
		int endIndex = size*page;

		return productOrderDao.getViewList(startIndex, endIndex);
	};

	public List<ProductOrderView> getViewList(int page, int size, String field, String query,List<String> orderState, String startDate, String endDate) {
		int startIndex=0;
		int endIndex=0;

		if(orderState!=null) {
			if(orderState.get(0).equals("all"))
				orderState = new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12"));
		}

		if(field!=null && !field.equals("")) {
			query = (field.equals("number"))? (" = "+query): (" LIKE '%"+query+"%'"); // QUERY가 숫자일 때 처리
			field = (field.equals("number"))? "\"NUMBER\"": field; //Field 가 예약어 number일 경우 처리
		}

		if(page!=0 && size!=0) {
			startIndex = 1 + (page-1)*size;
			endIndex = size*page;
		}
		if(startDate!=null && !startDate.equals(""))
			startDate="\'" + startDate +"\'";
		if(endDate!=null && !endDate.equals(""))
			endDate="\'" + endDate +"\'";
		return productOrderDao.getViewList(startIndex, endIndex,field, query, orderState,startDate,endDate);
	};


	public List<ProductOrderView> getViewList(int page, int size, String field, String query,List<String> orderState, String startDate, String endDate, String sortField, String sortOption) {

		int startIndex=0;
		int endIndex=0;
		if(orderState!=null) {
			if(orderState.get(0).equals("all"))
				orderState = new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12"));
		}

		if(field!=null && !field.equals("")) {
			query = (field.equals("number"))? (" = "+query): (" LIKE '%"+query+"%'"); // QUERY가 숫자일 때 처리
			field = (field.equals("number"))? "\"NUMBER\"": field; //Field 가 예약어 number일 경우 처리
		}

		if(page!=0 && size!=0) {
			startIndex = 1 + (page-1)*size;
			endIndex = size*page;
		}

		if(startDate!=null && !startDate.equals(""))
			startDate="\'" + startDate +"\'";
		if(endDate!=null && !endDate.equals(""))
			endDate="\'" + endDate +"\'";



		if(sortField==null||sortField.equals(""))
			sortField="number";
		if(sortOption==null||sortOption.equals(""))
			sortOption="asc";	

		return productOrderDao.getViewList(startIndex, endIndex,field, query,orderState,startDate,endDate,sortField,sortOption);
	}













}
