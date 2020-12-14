package gc.controller.admin.product_order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.entity.productOrder.ProductOrder;
import gc.service.productOrder.ProductOrderService;


@WebServlet("/admin/product-order/edit")
public class EditController extends HttpServlet{


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ProductOrderService service = new ProductOrderService();
		ProductOrder p = service.get(id);

		request.setAttribute("p", p);
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);
		String productName = request.getParameter("product-name");
		int price = Integer.parseInt(request.getParameter("price"));
		int productCount = Integer.parseInt(request.getParameter("count"));
		String senderName = request.getParameter("sender-name");
		String senderPhone = request.getParameter("sender-phone");
		String receiverName = request.getParameter("receiver-name");
		String receiverPhone = request.getParameter("receiver-phone");
		String address = request.getParameter("address");
		
		ProductOrder p = new ProductOrder(productName, price, productCount, senderName, senderPhone, receiverName, receiverPhone, address);
		p.setId(Integer.parseInt(id));
		
		ProductOrderService service = new ProductOrderService();
		service.update(p);
		
		
		response.sendRedirect("detail?id="+id);
	}
}
