package gc.dao.productOrder;

import java.util.List;

import gc.entity.productOrder.ProductPayment;


public interface ProductPaymentDao {

	int insert(ProductPayment productPayment);
	int update(ProductPayment productPayment);
	int delete(int id);
	
	ProductPayment get(int id);
	
	List<ProductPayment> getList();
}
