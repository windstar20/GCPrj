package gc.dao.productOrder;

import java.util.List;

import gc.entity.productOrder.ProductExchange;


public interface ProductExchangeDao {

	int insert(ProductExchange productExchange);
	int update(ProductExchange productExchange);
	int delete(int id);
	
	ProductExchange get(int id);
	
	List<ProductExchange> getList();
}
