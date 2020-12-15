package gc.controller.admin.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.entity.product.Product;
import gc.entity.product.view.ProductView;
import gc.service.product.ProductListService;
import gc.service.product.ProductService;

@WebServlet("/admin/product/edit")
public class EditController extends HttpServlet{
	
	@Override   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
//		ProductListService service = new ProductListService();
//		Product p = service.get(id);
		
		ProductService service = new ProductService();
		ProductView p = service.get(id);

		request.setAttribute("p", p);				
		request.getRequestDispatcher("edit.jsp").forward(request, response);

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String name = request.getParameter("name");
			String brand = request.getParameter("brand");			
			String content = request.getParameter("content");
			String category = request.getParameter("category");
			int price = Integer.parseInt(request.getParameter("price"));
			String delivery = request.getParameter("delivery");
			int id = Integer.parseInt(request.getParameter("id"));	
			
			Product product = new Product();
			product.setName(name);
//			product.setBrandId(brandId);
			product.setContent(content);
			product.setPrice(price);			
			product.setId(id);
		
			ProductService service = new ProductService();			
			service.update(product);
			
			response.sendRedirect("list");
		
		
	}
}
