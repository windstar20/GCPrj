package gc.service.product;

import java.util.List;

import gc.dao.product.CategoryDao;
import gc.dao.product.jdbc.JdbcCategoryDao;
import gc.entity.product.Category;

public class CategoryService {
	private CategoryDao categoryDao;
	
	public CategoryService() {
		categoryDao = new JdbcCategoryDao();
	}
	
	public int insert(Category category) {
	
		return categoryDao.insert(category);
	}
	
	public int update(Category category) {
		
		return categoryDao.update(category);
	}
	
	public int delete(int id) {
		
		return categoryDao.delete(id);
	}
	
	public List<Category> getList(){
		
		return categoryDao.getList();
	}
	
}
