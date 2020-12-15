package gc.controller.admin.product;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.dao.product.jdbc.JdbcProductDao;
import gc.entity.product.Product;
import gc.entity.product.view.ProductView;
import gc.service.product.ProductListService;


@WebServlet("/admin/product/reg")
public class RegController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getMethod().equals("GET"))
			request.getRequestDispatcher("reg.jsp").forward(request, response);		
		else if(request.getMethod().equals("POST")) {
		
			String code = request.getParameter("code");
			String name = request.getParameter("product-name");//web에서 받아온 text			
			int price = Integer.parseInt(request.getParameter("price"));
			String content = request.getParameter("content");
//			String brand = request.getParameter("brand");			
//			String category = request.getParameter("category");
//			String delivery = request.getParameter("delivery");
//			String fileName = request.getParameter("file-name");
			
		Product p = new Product();
		p.setCode(code);
		p.setName(name);
		p.setPrice(price);
		p.setContent(content);			
		
//		ProductListService service= new ProductListService();
		JdbcProductDao dao = new JdbcProductDao();
		
		dao.insert(p);		
		dao.insert(p);
		//맛에 대한건 와일문, 배열의 길이만큼 돌면서 insert
		//3개면 3번 돌면서 insert
		
		
		response.sendRedirect("list");
		
		}
	}
}
