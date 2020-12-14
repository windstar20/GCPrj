package gc.controller.admin.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.entity.product.Product;
import gc.service.product.ProductListService;


@WebServlet("/admin/product/list")
public class ListController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ProductListService service = new ProductListService();
		List<Product> list = service.getList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
		
		
	}
}
