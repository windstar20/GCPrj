package gc.dao.product;

import java.util.List;

import gc.entity.product.ProductImg;



public interface ProductImgDao {
	int insert(ProductImg productimg);
	int update(ProductImg productimg);
	int delete(String productCode);
	List<ProductImg> getList();
	ProductImg get(String productCode);
}
