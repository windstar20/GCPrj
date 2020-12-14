package gc.dao.productOrder;

import java.util.List;

import gc.entity.productOrder.ProductEvaluation;


public interface ProductEvaluationDao {

	int insert(ProductEvaluation productEvaluation);
	int update(ProductEvaluation productEvaluation);
	int delete(int id);
	
	ProductEvaluation get(int id);
	
	List<ProductEvaluation> getList();
}
