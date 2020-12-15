package gc.controller.admin.product_order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.entity.productOrder.ProductOrder;
import gc.service.productOrder.ProductOrderService;

//@MultipartConfig( 
//	    fileSizeThreshold=1024*1024, 
//	    maxFileSize=1024*1024*5, 
//	    maxRequestSize=1024*1024*5*5)
@WebServlet("/admin/product-order/reg")
public class RegController extends HttpServlet{


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("reg.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 사용자 입력을 변수에 담기
		String productName = request.getParameter("product-name");
		int price = Integer.parseInt(request.getParameter("price"));
		int productCount = Integer.parseInt(request.getParameter("count"));
		String senderName = request.getParameter("sender-name");
		String senderPhone = request.getParameter("sender-phone");
		String receiverName = request.getParameter("receiver-name");
		String receiverPhone = request.getParameter("receiver-phone");
		String address = request.getParameter("address");

		ProductOrder p  = new ProductOrder(id, number, senderName, senderPhone, senderEmail, receiverName, receiverPhone, receiverAddress, count, regdate, totalPrice, productCode, memberId)

		// 1. 데이터베이스에 입력
		ProductOrderService service = new ProductOrderService();
		service.insert(productName, price, productCount, senderName, senderPhone, receiverName, receiverPhone, address);

		// 2. 목록페이지로 이동
		response.sendRedirect("/admin/product-order/list");

	}
}
