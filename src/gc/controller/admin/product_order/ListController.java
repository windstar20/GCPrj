package gc.controller.admin.product_order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.entity.productOrder.ProductOrder;
import gc.entity.productOrder.view.ProductOrderView;
import gc.service.productOrder.ProductOrderService;



@WebServlet("/admin/product-order/list")
public class ListController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page=1; // 페이지 번호
		int size=10; // 페이지당 보여지는 글 갯수
		int pageNum=1;
		String field=null;
		String query=null;
		ProductOrderService service = new ProductOrderService();

		
		if(request.getParameter("page")!=null)
			page = Integer.parseInt(request.getParameter("page"));
			
		if(request.getParameter("size")!=null)
			size = Integer.parseInt(request.getParameter("size"));
		if(request.getParameter("field")!=null)
			field = request.getParameter("field");
		if(request.getParameter("query")!=null)
			query = request.getParameter("query");
		
		List<ProductOrderView> list = service.getViewList(0, 0, field, query);
		
		if(list.size()%10==0)
			pageNum = list.size()/size;
		else
			pageNum = list.size()/size+1;
		
		
		list = service.getViewList(page, size, field, query);
		System.out.println(pageNum);
		
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("size", size);
		request.setAttribute("pageNum", pageNum);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	 
		
	}
}
