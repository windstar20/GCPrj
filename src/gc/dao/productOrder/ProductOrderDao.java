package gc.dao.productOrder;

import java.util.Date;
import java.util.List;

import gc.dao.productOrder.entity.ProductOrderView;
import gc.entity.productOrder.ProductOrder;


// SQL의 자바 함수화
// 업무는 몰라
public interface ProductOrderDao {

	int insert(ProductOrder productOrder);
	int update(ProductOrder productOrder);
	int delete(int id);
	
	ProductOrder get(int id);
	

	List<ProductOrderView> getViewList(int statrtIndex, int endIndex);
	List<ProductOrderView> getViewList(int statrtIndex);
}
