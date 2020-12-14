package gc.dao.product;

import java.util.List;

import gc.entity.product.ProductTaste;



public interface ProductTasteDao{
	
	int insert(ProductTaste productTaste);
	int update(ProductTaste productTaste);
	int delete(String productCode);
	List<ProductTaste> getList();	
	ProductTaste get(String productCode);
	
}
