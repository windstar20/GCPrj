package gc.controller.admin.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.entity.product.Product;
import gc.service.product.ProductListService;

@WebServlet("/admin/product/edit")
public class EditController extends HttpServlet{
	
	@Override    //detail.jsp에서  수정버튼을 누르면 이곳에서 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		ProductListService service = new ProductListService();
		Product p = service.get(id);

		request.setAttribute("p", p);				
		request.getRequestDispatcher("edit.jsp").forward(request, response);


	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String productName = request.getParameter("product-name");
			String  manufacturer = request.getParameter("manufacture");
			String brand = request.getParameter("brand");			
			String productModel = request.getParameter("model");
			String category = request.getParameter("category");
			int price = Integer.parseInt(request.getParameter("price"));
			int savePoint = Integer.parseInt(request.getParameter("save-point"));
			String delivery = request.getParameter("delivery");
			String summaryExplain = request.getParameter("summary-explain");
			String detailExplain = request.getParameter("detail-explain");
			System.out.println("doPost");		
			int id = Integer.parseInt(request.getParameter("id"));	
			
			Product product = new Product(productName, manufacturer, brand, 
							productModel, category, price, savePoint, delivery, 
							summaryExplain, detailExplain);
			product.setId(id);
		
			ProductListService service= new ProductListService();
			
			service.update(product);
			
			response.sendRedirect("list");
		
		
	}
}
