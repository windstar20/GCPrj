package gc.controller.admin.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import gc.entity.product.view.ProductView;
import gc.service.product.ProductService;


@WebServlet("/admin/product/list")
public class ListController extends HttpServlet{


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int pageEnd = 1;
		
		
		ProductService service = new ProductService();
		
		String page_ = request.getParameter("page");
		String size_ = request.getParameter("size");
		String keyword_ = request.getParameter("keyword");
		String query_ = request.getParameter("query");
		String prevPrice_ = request.getParameter("prevPrice");
		String nextPrice_ = request.getParameter("nextPrice");
		
		int page = 1;
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
		
		int size = 10;
		if(size_ != null && !size_.equals(""))
			size = Integer.parseInt(size_);	
		
		String keyword = "";
		if(keyword_ != null && !keyword_.equals(""))
			keyword = keyword_;	
		
		String query = "";
		if(query_ != null && !query_.equals(""))
			query = query_;	
		
		String prevPrice = "";
		if(prevPrice_ != null && !prevPrice_.equals(""))
			prevPrice = prevPrice_;	
		
		String nextPrice = "";
		if(nextPrice_ != null && !nextPrice_.equals(""))
			nextPrice = nextPrice_;	
		
		List<ProductView> list = service.getViewList(page, size, keyword, query, prevPrice, nextPrice);
		
		 int count = service.getCount(keyword, query);//게시물의 수를 구하기(함수처리) 
		 int lastPage = count/size; //마지막 페이지구하기(1) 
		 pageEnd = count%size > 0 ? lastPage+1 : lastPage; //마지막
		 //페이지구하기(2) // lastPage = count%10=0?lastPage:lastPage+1; pageEnd = lastPage;
		 System.out.println("count: "+count);
		 System.out.println("라스트: "+lastPage);
		 
//		 if(list.size()%10==0)
//			pageEnd = list.size();
//		else
//			pageEnd = list.size()+1;
			
//		list = service.getViewList(page, size, keyword, query, prevPrice, nextPrice);
//		System.out.println("pageEnd: "+pageEnd);
		
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("size", size);
		request.setAttribute("count", count);
		request.setAttribute("pageEnd", pageEnd);

		request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService service = new ProductService();			
		String[] selected = null;
		String deleteSubmit = null;
		String displaySubmit = null;
		
		if(request.getParameter("delete-submit")!=null) 
			deleteSubmit = request.getParameter("delete-submit");
		if(request.getParameter("display-submit")!=null) 
			displaySubmit = request.getParameter("display-submit");
		
		
		if(request.getParameterValues("selected")!=null) {
			selected = request.getParameterValues("selected");
					
			for(int j=0;j<selected.length;j++)
				System.out.println(selected[j]);
			
			
			int[] ids = new int[selected.length];
	
			for(int i=0;i<selected.length;i++) {
				ids[i] = Integer.parseInt(selected[i]);
				System.out.println("ids는: "+ids[i]);
			}
			
			if(deleteSubmit != null) {
				service.deleteAll(ids);
				System.out.println(deleteSubmit);
			}
			if(displaySubmit != null) {
				service.displayAll(ids);
				System.out.println(displaySubmit);
			}
		}
		response.sendRedirect("list");
	}//end doPost

}

