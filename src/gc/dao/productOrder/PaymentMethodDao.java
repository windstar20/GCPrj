package gc.dao.productOrder;

import java.util.Date;
import java.util.List;

import gc.entity.productOrder.PaymentMethod;



public interface PaymentMethodDao {

	int insert(PaymentMethod paymentMethod);
	int update(PaymentMethod paymentMethod);
	int delete(int id);
	List<PaymentMethod> getList();

}
