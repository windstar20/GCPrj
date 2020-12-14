package gc.dao.productOrder;

import java.util.List;

import gc.entity.productOrder.ProductDelivery;


public interface ProductDeliveryDao {

	int insert(ProductDelivery productDelivery);
	int update(ProductDelivery productDelivery);
	int delete(int id);
	
	ProductDelivery get(int id);
	
	List<ProductDelivery> getList();
}
