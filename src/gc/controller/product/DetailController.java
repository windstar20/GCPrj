package gc.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.entity.product.Product;
import gc.entity.product.ProductTaste;
import gc.service.product.ProductService;
import gc.service.product.TasteService;

@WebServlet("/product/detail")
public class DetailController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		ProductService service = new ProductService();
//		Product p = service.get(id);
		Product p = service.getView(id);
		
		TasteService tService = new TasteService();
		
		List<ProductTaste> tList = tService.getList();
		
		request.setAttribute("tList", tList);		
		request.setAttribute("p", p);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}

}
