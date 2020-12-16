package gc.dao.product;

import java.util.List;

import gc.entity.product.Product;
import gc.entity.product.view.ProductView;




public interface ProductDao {
	
	int insert(Product product);
	int update(Product product);
	int delete(int id);
	int deleteAll(int[] ids);
	
//	Product get(int id);
	List<Product> getList();
	
	int display(int id);
	int displayAll(int[] ids);
	
//	int insert(ProductView productView);	
	List<ProductView> getViewList();
	List<ProductView> getViewList(int startIndex, int endIndex);
	List<ProductView> getViewList(int startIndex, int endIndex, String field, String query);
	
	
	Product get(int id);
	int getCount();
}
