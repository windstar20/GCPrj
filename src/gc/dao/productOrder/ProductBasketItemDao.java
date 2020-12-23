package gc.dao.productOrder;

import java.util.List;

import gc.entity.productOrder.ProductBasketItem;


public interface ProductBasketItemDao {

	int insert(ProductBasketItem productBasketItem);
	int update(ProductBasketItem productBasketItem );
	int delete(int basketId,String productCode);
	
	ProductBasketItem get(int basketId,String productCode);
	ProductBasketItem getOnePersonList(int basketId);
	List<ProductBasketItem> getList();
}
