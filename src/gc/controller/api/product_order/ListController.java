package gc.controller.api.product_order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import gc.entity.productOrder.view.ProductOrderView;
import gc.service.productOrder.ProductOrderService;



@WebServlet("/api/product-order/list")
public class ListController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      response.setCharacterEncoding("UTF-8");      
	      response.setContentType("text/json; charset=UTF-8");
		int page=1; // 페이지 번호
		int size=10; // 페이지당 보여지는 글 갯수
		int pageNum=1;
		String field=null;
		String query=null;
		String startDate = null;
		String endDate=null;
		String sortField=null;
		String sortOption=null;
		String[] orderStates= null;
		List<String> orderState = null;
		ProductOrderService service = new ProductOrderService();


		if(request.getParameter("page")!=null)
			page = Integer.parseInt(request.getParameter("page"));

		if(request.getParameter("size")!=null)
			size = Integer.parseInt(request.getParameter("size"));
		if(request.getParameter("field")!=null)
			field = request.getParameter("field");
		if(request.getParameter("query")!=null)
			query = request.getParameter("query");
		if(request.getParameter("start-date")!=null)
			startDate = request.getParameter("start-date");
		if(request.getParameter("end-date")!=null)
			endDate = request.getParameter("end-date");
		if(request.getParameter("sort-field")!=null)
			sortField = request.getParameter("sort-field");
		if(request.getParameter("sort-option")!=null)
			sortOption = request.getParameter("sort-option");
		if(request.getParameter("order-state")!=null) {
			orderStates = request.getParameterValues("order-state");
			orderState = new ArrayList<String>(Arrays.asList(orderStates));
		}
		
		List<ProductOrderView> list = service.getViewList(page, size, field, query, orderState,startDate, endDate, sortField,sortOption); 
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd aa hh:mm").create();
		String json = gson.toJson(list);
		
		response.getWriter().println(json);

	}
}
