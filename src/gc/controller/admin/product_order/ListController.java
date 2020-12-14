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
		int page=1; // 페이지 수
		int size=10; // 페이지당 보여지는 글 갯수
		
		ProductOrderService service = new ProductOrderService();
		request.getParameter(name)
		
		List<ProductOrderView> totalList = service.getList();
		
		
		

		List<ProductOrderView> list = service.getViewList(page,size);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("list.jsp").forward(request, response);
	 
		
	}
}
