package gc.dao.productOrder;

import java.util.List;

import gc.entity.productOrder.ProductReturn;


public interface ProductReturnDao {

	int insert(ProductReturn productReturn);
	int update(ProductReturn productReturn);
	int delete(int id);
	
	ProductReturn get(int id);
	
	List<ProductReturn> getList();
}
