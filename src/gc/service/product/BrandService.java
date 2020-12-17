package gc.service.product;

import java.util.List;

import gc.dao.product.BrandDao;
import gc.dao.product.jdbc.JdbcBrandDao;
import gc.entity.product.Brand;

public class BrandService {
	private BrandDao brandDao;
	
	public BrandService() {
		brandDao = new JdbcBrandDao();
	}
	
	public int insert(Brand brand) {
		
		return brandDao.insert(brand);
	}
	
	public int update(Brand brand) {
		
		return brandDao.update(brand);
	}

	public int delete(int id) {
		
		return brandDao.delete(id);
	}
	
	public List<Brand> getList(){
		
		return brandDao.getList();
	}
}
