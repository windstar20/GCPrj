package gc.service.product;

import java.util.List;

import gc.dao.product.ProductTasteDao;
import gc.dao.product.jdbc.JdbcProductTasteDao;
import gc.entity.product.ProductTaste;

public class TasteService {
	private ProductTasteDao tasteDao;
	
	public TasteService() {
		tasteDao = new JdbcProductTasteDao(); 
	}

	public int insert(ProductTaste productTaste) {
		
		return tasteDao.insert(productTaste);
	}
	
	public int update(ProductTaste productTaste) {
			
		return tasteDao.insert(productTaste);
	}

	public int delete(String productCode) {
		
		return tasteDao.delete(productCode);
	}
	
	public List<ProductTaste> getList(){
		
		return tasteDao.getList();
	}
	
	public ProductTaste get(String productCode) {
		
		return tasteDao.get(productCode);
	}
}
