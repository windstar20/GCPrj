package gc.controller.product_order;

import java.io.IOException;
import java.security.Provider.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.entity.product.Product;
import gc.entity.productOrder.ProductBasket;
import gc.entity.productOrder.ProductBasketItem;
import gc.service.product.ProductService;
import gc.service.productOrder.ProductBasketItemService;

@WebServlet("/product-order/basket")
public class BasketListController extends HttpServlet{
	private ProductService service1;
	private ProductBasketItemService service2;
	public BasketListController() {
		 service1 = new ProductService();
		 service2 = new ProductBasketItemService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =0;
		int memberId=0;
		
		if(request.getParameter("member-id")!=null)
			id = Integer.parseInt(request.getParameter("member-id"));
		
		ProductBasketItem pbi = service2.get(basketId, productCode)
		
				//Product p = service.get(id);
		System.out.println(p);
		request.getRequestDispatcher("basket.jsp").forward(request, response);

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
