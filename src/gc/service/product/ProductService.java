package gc.service.product;

import java.util.List;

import gc.dao.product.ProductDao;
import gc.dao.product.jdbc.JdbcProductDao;
import gc.entity.product.Product;


//여기에서는 sql을 모른다.
public class ProductService {

	private ProductDao productDao;

	public ProductService() {
		productDao = new JdbcProductDao();
	}

	public List<Product> getList(int page, int size, String field, String query) {
		//등차수열
		int startIndex = 1+(page-1)*size; //1, 11, 21, 31...
		//int end  10, 20 , 30 , 40 ,50
		int endIndex = page*10;

		return productDao.getList(startIndex, endIndex, field, query);
	}
	
	public int deleteAll(int[] ids) {
		//다오를 사용하는 이유
		//1. 협업
		//2. 재사용
		//3. 데이터베이스(소스)를 숨김.
		//*. 수정의 용이성(x) 더 복잡해짐, 성능 둘 다 비슷함.
		
		
		
		//DELETE NOTICE WHERE ID IN(...);
		//noticeDao.deleteAll(ids);
		//만약에 쿼리를 안다면 아래와 같이 하지 않을 것.
		//
		
		int result = 0;
		for(int i=0; i<ids.length; i++) {
			int id = ids[i];
			result += productDao.delete(id);
		}
		
		return result;
	}
	
	
	public int hitUp(int id) {
		//int result = noticeDao.hitUp(id);   //내가 받은걸 그대로 돌려줘
		
		//ProductService와 ProductDao를 둘다 다루는 사람이라면, 분리해서 해야한다.
		
		
		//기업형은 아래와 같이
		//SELECT * FROM NOTICE WHERE ID=?
//		Notice notice = NoticeDao.get(id);//가져오고    //서비스와 다오를 경계를 가른다고 하면, 이게 맞다.
//		notice.setHit(notice.getHit()+1);//셋팅
		//UPDATE ...
//		noticeDao.update(notice);//업데이트
		
		// SELECT * FROM NOTICE WHERE ID=?
	      Product product  = productDao.get(id); 
//	      product.setHit(product.getHit()+1);
	      // UPDATE NOTICE SET ... WHERE ID=?
	      int result = productDao.update(product);
	      
	      return result;
				
	}
	
	public int open(int id) {
//		noticeDao.open(id);
//		
//		Notice notice = noticeDao.get(id);
//		notice.setPub(true);
		
	}
	

	public List<ProductView> getViewList(int page, int size){
		int startIndex = 1+(page-1)*size; //1, 11, 21, 31...
		//int end  10, 20 , 30 , 40 ,50
		int endIndex = page*10;
		return productDao.getViewList(startIndex, endIndex);

	}
	
	
	
	
	
}
