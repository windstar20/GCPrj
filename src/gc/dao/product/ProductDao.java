package gc.dao.product;

import java.util.List;

import gc.entity.Product;

public interface ProductDao {
	
	int insert(Product product);
	int update(Product product);
	int delete(int id);
	int deleteAll(int[] ids);
	
	Product get(int id);
	List<Product> getList();
	
	int display(int id);
	int displayAll(int[] ids);
	
	
	
}
