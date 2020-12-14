package gc.dao.productOrder;

import java.util.List;

import gc.entity.productOrder.ProductBasket;



public interface ProductBasketDao {

	int insert(ProductBasket productBasket);
	int update(ProductBasket productBasket);
	int delete(int id);
	
	ProductBasket get(int id);
	
	List<ProductBasket> getList();

}
