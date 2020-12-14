package gc.dao.product;

import java.util.List;

import gc.entity.product.Delivery;


public interface DeliveryDao {
		
	int insert(Delivery delivery);
	int update(Delivery delivery);
	int delete(int id);
	List<Delivery> getList();

}
