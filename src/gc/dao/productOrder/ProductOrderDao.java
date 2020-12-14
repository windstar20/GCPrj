package gc.dao.productOrder;

import java.util.Date;
import java.util.List;

import gc.entity.productOrder.ProductOrder;
import gc.entity.productOrder.view.ProductOrderView;


// SQL의 자바 함수화
// 업무는 몰라
public interface ProductOrderDao {

	int insert(ProductOrder productOrder);
	int update(ProductOrder productOrder);
	int delete(int id);
	
	ProductOrder get(int id);
	
	
	List<ProductOrder> getList();
	
	//========================
	List<ProductOrderView> getViewList(int startIndex, int endIndex);
	List<ProductOrderView> getViewList(int startIndex);
	
	List<ProductOrderView> getViewList(int startIndex, int endIndex, String field, String query, List<String> orderState, List<String> cancelState, Date startDate, Date endDate);

	
}
