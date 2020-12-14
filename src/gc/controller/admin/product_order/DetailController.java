package gc.controller.admin.product_order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.entity.productOrder.ProductOrder;
import gc.service.productOrder.ProductOrderService;


@WebServlet("/admin/product-order/detail")
public class DetailController extends HttpServlet{


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ProductOrderService service = new ProductOrderService();
		ProductOrder p = service.get(id);

		request.setAttribute("p", p);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}

}
