package gc.controller.admin.point.charge;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.service.point.PointChargingService;
import gc.service.productOrder.ProductOrderService;



@WebServlet("/admin/product-order/point-charge-del")
public class DelController extends HttpServlet{



	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		PointChargingService service = new PointChargingService();
		int result = service.delete(id);

		response.sendRedirect("point-charge-list");
	}


}
