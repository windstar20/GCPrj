package gc.service.productOrder;

import java.util.List;

import gc.dao.productOrder.ProductBasketItemDao;
import gc.dao.productOrder.ProductOrderDao;
import gc.dao.productOrder.jdbc.JdbcProductBasketItem;
import gc.dao.productOrder.jdbc.JdbcProductOrderDao;
import gc.entity.productOrder.ProductBasketItem;
import gc.entity.productOrder.ProductOrder;

public class ProductBasketItemService {

	private ProductBasketItemDao productBasketItemDao;

	public ProductBasketItemService() {
		productBasketItemDao = new JdbcProductBasketItem();
	}
	
	public int insert(ProductBasketItem productBasketItem) {

		return productBasketItemDao.insert(productBasketItem);
	}

	public int update(ProductBasketItem productBasketItem) {
		return productBasketItemDao.update(productBasketItem);
	}


	public int delete(int basketId, String productCode) {

		return productBasketItemDao.delete(basketId,productCode);
	}


	public ProductBasketItem get(int basketId, String productCode) {

		return productBasketItemDao.get(basketId,productCode);
	}



	public List<ProductBasketItem> getList() {


		return productBasketItemDao.getList();
	};
}
