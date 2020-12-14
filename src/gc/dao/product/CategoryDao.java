package gc.dao.product;

import java.util.List;

import gc.entity.product.Category;



public interface CategoryDao {
	
	int insert(Category category);
	int update(Category category);
	int delete(int id);
	List<Category> getList();
	
}
