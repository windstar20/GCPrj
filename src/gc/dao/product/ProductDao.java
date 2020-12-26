package gc.dao.product;

import java.util.List;

import gc.entity.product.Product;
import gc.entity.product.view.ProductView;




public interface ProductDao {
	
	int insert(Product product);
	int update(Product product);
	int delete(int id);
	int getCount();
	int display(int id);
	
	
//	Product get(int id);
	List<Product> getList();
	
//	int insert(ProductView productView);	
	List<ProductView> getViewList();
	List<ProductView> getViewList(int startIndex, int endIndex);
	List<ProductView> getViewList(int startIndex, int endIndex, String keyword, String query, String prevPrice, String nextPrice);
	
	
	Product get(int id);
	Product getView(int id); //상품디테일을 위한 메소드
	
	Product getLast();
}
