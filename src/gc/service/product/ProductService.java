package gc.service.product;

import java.util.List;

import gc.dao.product.ProductDao;
import gc.dao.product.jdbc.JdbcProductDao;
import gc.entity.product.Product;
import gc.entity.product.view.ProductView;


//여기에서는 sql을 모른다.
public class ProductService {

	private ProductDao productDao;

	public ProductService() {
		productDao = new JdbcProductDao();
	}

	//	public List<Product> getList(int page, int size, String field, String query) {
	//		//등차수열
	//		int startIndex = 1+(page-1)*size; //1, 11, 21, 31...
	//		//int end  10, 20 , 30 , 40 ,50
	//		int endIndex = page*10;
	//
	//		return productDao.getList(startIndex, endIndex, field, query);
	//	}

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
		return 0;
	}

	public List<ProductView> getViewList(){


		return productDao.getViewList();

	}


	
	public List<ProductView> getViewList(int page, int size){

		int startIndex = 1+(page-1)*size; //1, 11, 21, 31...//수열: 초항+(n-1)*d
		int endIndex = page*5;
		//int end  10, 20 , 30 , 40 ,50
		return productDao.getViewList(startIndex, endIndex);

	}

	public Product get(int id) {


		return productDao.get(id);
	}
	
	//페이지 처리를 위한 함수(int page, int size)
	public List<ProductView> getViewList(int page, int size, String field, String query) {
		int startIndex = 1+(page-1)*size; //1, 6, 11
		int endIndex = page*5;            //5, 10, 15		

		return productDao.getViewList(startIndex, endIndex, field, query);
	}	
	
	/*
	 * public void movePrevList(int page) { if(page == 1) { return ; } page--;
	 * 
	 * }
	 * 
	 * public void moveNextList(int page, int pageEnd) { if(page == pageEnd) {
	 * return ; } page++; }
	 */
	
}
