package gc.controller.admin.product;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.entity.product.Product;
import gc.service.product.ProductListService;


@WebServlet("/admin/product/reg")
public class RegController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getMethod().equals("GET"))
			request.getRequestDispatcher("reg.jsp").forward(request, response);
		else if(request.getMethod().equals("POST")) {
		
			String productName = request.getParameter("product-name");//web에서 받아온 text
			String  manufacturer = request.getParameter("manufacture");
			String brand = request.getParameter("brand");			
			String productModel = request.getParameter("model");
			String category = request.getParameter("category");
			int price = Integer.parseInt(request.getParameter("price"));
			int savePoint = Integer.parseInt(request.getParameter("save-point"));
			String delivery = request.getParameter("delivery");
			String summaryExplain = request.getParameter("summary-explain");
			String detailExplain = request.getParameter("detail-explain");
			
		Product product = new Product(productName, manufacturer, brand, productModel, category, price,
				savePoint, delivery, summaryExplain, detailExplain);
		
		ProductListService service= new ProductListService();
		
		service.insert(product);
		
		response.sendRedirect("list");
		
		}
	}
}
