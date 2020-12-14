package gc.dao.product;

import java.util.List;

import gc.entity.product.Brand;


public interface BrandDao {
	
	int insert(Brand brand);
	int update(Brand brand);
	int delete(int id);	
	List<Brand> getList();
	
	
}
