package gc.dao.productOrder;

import java.util.List;

import gc.entity.productOrder.ProductBasketItem;


public interface ProductBasketItemDao {

	int insert(ProductBasketItem productBasketItem);
	int update(ProductBasketItem productBasketItem );
	int delete(int id);
	
	ProductBasketItem get(int id);
	
	List<ProductBasketItem> getList();
}
