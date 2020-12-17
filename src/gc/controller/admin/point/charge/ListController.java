package gc.controller.admin.point.charge;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.entity.point.view.PointChargingView;
import gc.service.point.PointChargingService;


@WebServlet("/admin/product-order/point-charge-list")
public class ListController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page=1; // 페이지 번호
		int size=10; // 페이지당 보여지는 글 갯수
		int pageNum=1;
		String field=null;
		String query=null;
		String startDate = null;
		String endDate=null;
		PointChargingService service = new PointChargingService();


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
		List<PointChargingView> list = service.getViewList(0, 0, field, query,startDate, endDate);

		if(list.size()%10==0)
			pageNum = list.size()/size;
		else
			pageNum = list.size()/size+1;

		
		list = service.getViewList(page, size, field, query, startDate, endDate);
		System.out.println(pageNum);

		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("size", size);
		request.setAttribute("field", field);
		request.setAttribute("query", query);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);
		request.getRequestDispatcher("point-charge-list.jsp").forward(request, response);
	}
}
