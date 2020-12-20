package gc.controller.api.point.use;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import gc.entity.point.view.PointUseView;
import gc.entity.point.view.PointView;
import gc.entity.productOrder.view.ProductOrderView;
import gc.service.point.PointService;
import gc.service.point.PointUseService;
import gc.service.productOrder.ProductOrderService;



@WebServlet("/api/product-order/point-use-list")
public class ListController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      response.setCharacterEncoding("UTF-8");      
	      response.setContentType("text/json; charset=UTF-8");
	      int page=1; // 페이지 번호
			int size=10; // 페이지당 보여지는 글 갯수
			String field=null;
			String query=null;
			String startDate = null;
			String endDate=null;
			String sortField=null;
			String sortOption=null;
			PointUseService service1 = new PointUseService();
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
			
			List<PointUseView> list = service1.getViewList(0, 0, field, query,startDate, endDate);
			
			
			list = service1.getViewList(page, size, field, query, startDate, endDate, sortField,sortOption);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd aa hh:mm").create();
		String json = gson.toJson(list);
		
		response.getWriter().println(json);

	}
}
