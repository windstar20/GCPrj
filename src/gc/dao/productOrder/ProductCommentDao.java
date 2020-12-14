package gc.dao.productOrder;

import java.util.List;

import gc.entity.productOrder.ProductComment;

public interface ProductCommentDao {

	int insert(ProductComment productComment);
	int update(ProductComment productComment);
	int delete(int id);
	
	ProductComment get(int id);
	
	List<ProductComment> getList();
}
