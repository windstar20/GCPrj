package gc.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import gc.entity.product.view.ProductView;
import gc.service.product.ProductService;

@WebServlet("/product/list")
public class ListController extends HttpServlet{


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int page = 1;
		int size = 15;		
		int pageEnd = 1;
		ProductService service = new ProductService();

		if(request.getParameter("page")!=null)
			page = Integer.parseInt(request.getParameter("page"));
		if(request.getParameter("size")!=null)
			size = Integer.parseInt(request.getParameter("size"));
		
		List <ProductView> list = service.getViewList(page, size);

		int count = service.getCount();
		int lastPage = count/size;
		pageEnd = count%size > 0 ? lastPage+1 : lastPage; //마지막

		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("size", size);
		request.setAttribute("pageEnd", pageEnd);
		request.setAttribute("count", count);

		request.getRequestDispatcher("/product/list.jsp").forward(request, response);
	}//end service
}