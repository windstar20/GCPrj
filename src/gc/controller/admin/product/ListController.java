package gc.controller.admin.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.dao.product.ProductDao;
import gc.dao.product.jdbc.JdbcProductDao;
import gc.entity.product.Product;
import gc.entity.product.view.ProductView;
import gc.service.product.ProductListService;
import gc.service.product.ProductService;


@WebServlet("/admin/product/list")
public class ListController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		Dao 만들기 전 코드
//		ProductListService service = new ProductListService();
//		List<Product> list = service.getList();
		
		ProductService service = new ProductService();
		List<ProductView> list = service.getViewList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
		
	}
}
