package gc.controller.admin.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.service.product.ProductListService;



@WebServlet("/admin/product/del")
public class DeleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		int id = Integer.parseInt(request.getParameter("id"));
		
		ProductListService service = new ProductListService();
		int result = service.delete(id);
		
		response.sendRedirect("list");
	}
}
