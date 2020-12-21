package gc.controller.api.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import gc.entity.product.view.ProductView;
import gc.service.product.ProductService;

@WebServlet("/product/list")
public class ListController extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int page = 1;
		int size = 15;
		
		int pageEnd = 1;
		ProductService service = new ProductService();
		
		 List <ProductView> list = service.getViewList(page, size);
		 
		 int count = service.getCount();
		 int lastPage = count/10;
		 pageEnd = lastPage;
		
		 request.setAttribute("list", list);
		 request.setAttribute("page", page);
		 request.setAttribute("page", size);
		 request.setAttribute("pageEnd", pageEnd);
		 
		 request.getRequestDispatcher("/product/list.jsp").forward(request, response);
	}

	
	
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int page = 1;
//		int size = 18;
//		int pageEnd = 1;
//		String keyword = null;
//		String query = null;
//		String prevPrice = null;
//		String nextPrice = null;
//		ProductService service = new ProductService();
//		JdbcProductDao dao = new JdbcProductDao();
//
//		if(request.getParameter("page")!=null)
//			page = Integer.parseInt(request.getParameter("page"));
//		if(request.getParameter("size")!=null)
//			size = Integer.parseInt(request.getParameter("size"));
//		if(request.getParameter("keyword")!=null)
//			keyword = request.getParameter("keyword");
//		if(request.getParameter("query")!=null)
//			query = request.getParameter("query");	
//		if(request.getParameter("prevPrice")!=null)
//			prevPrice = request.getParameter("prevPrice");
//		if(request.getParameter("nextPrice")!=null)
//			nextPrice = request.getParameter("nextPrice");
//
//		List<ProductView> list = service.getViewList(0, 0, keyword, query, prevPrice, nextPrice);
//		
//		 int count = service.getCount();//게시물의 수를 구하기(함수처리) 
//		 int lastPage = count/10; //마지막 페이지구하기(1) 
//		 lastPage = count%10 > 0 ? lastPage+1 : lastPage; //마지막
//		 //페이지구하기(2) // lastPage = count%10=0?lastPage:lastPage+1; pageEnd = lastPage;
//		 System.out.println("라스트: "+lastPage);
//		 pageEnd = lastPage;
//		 
//		 int aa = list.size();
//		 System.out.println("list.size() "+ aa);
//			
//		list = service.getViewList(page, size, keyword, query, prevPrice, nextPrice);
//		System.out.println("pageEnd: "+pageEnd);
//		
//		request.setAttribute("list", list);
//		request.setAttribute("page", page);
//		request.setAttribute("size", size);
//		request.setAttribute("pageEnd", pageEnd);
//
//		request.getRequestDispatcher("/product/list.jsp").forward(request, response);
//	}
//
//	
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ProductService service = new ProductService();			
//		String[] selected = null;
//		String deleteSubmit = null;
//		String displaySubmit = null;
//		
//		if(request.getParameter("delete-submit")!=null) 
//			deleteSubmit = request.getParameter("delete-submit");
//		if(request.getParameter("display-submit")!=null) 
//			displaySubmit = request.getParameter("display-submit");
//		
//		
//		if(request.getParameterValues("selected")!=null) {
//			selected = request.getParameterValues("selected");
//					
//			for(int j=0;j<selected.length;j++)
//				System.out.println(selected[j]);
//			
//			
//			int[] ids = new int[selected.length];
//	
//			for(int i=0;i<selected.length;i++) {
//				ids[i] = Integer.parseInt(selected[i]);
//				System.out.println("ids는: "+ids[i]);
//			}
//			
//			if(deleteSubmit != null) {
//				service.deleteAll(ids);
//				System.out.println(deleteSubmit);
//			}
//			if(displaySubmit != null) {
//				service.displayAll(ids);
//				System.out.println(displaySubmit);
//			}
//		}
//		response.sendRedirect("list");
//	}//end doPost

}