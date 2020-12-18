package gc.controller.admin.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.entity.product.Brand;
import gc.entity.product.Category;
import gc.entity.product.Product;
import gc.entity.product.ProductTaste;
import gc.service.product.BrandService;
import gc.service.product.CategoryService;
import gc.service.product.ProductService;
import gc.service.product.TasteService;

@WebServlet("/admin/product/edit")
public class EditController extends HttpServlet{
	
	@Override   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BrandService bService = new BrandService();
		CategoryService cService = new CategoryService();
		TasteService tService = new TasteService();
		
		List<Brand> bList = bService.getList();
		List<Category> cList = cService.getList();
		List<ProductTaste> tList = tService.getList();
		
		int id = Integer.parseInt(request.getParameter("id"));
//		ProductListService service = new ProductListService();
//		Product p = service.get(id);
		
		ProductService service = new ProductService();
		Product p = service.get(id);

		request.setAttribute("bList", bList);
		request.setAttribute("cList", cList);
		request.setAttribute("tList", tList);
		request.setAttribute("p", p);				
		request.getRequestDispatcher("edit.jsp").forward(request, response);

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ProductService service = new ProductService();
			TasteService tService = new TasteService();
			
			String code = request.getParameter("code");
			String name = request.getParameter("name");//web에서 받아온 text
			int brandId = Integer.parseInt(request.getParameter("brand"));
			int categoryId = Integer.parseInt(request.getParameter("category"));
			int price = Integer.parseInt(request.getParameter("price"));
			int inventory = Integer.parseInt(request.getParameter("inventory"));
			int deliveryId = Integer.parseInt(request.getParameter("delivery-price"));
			String content = request.getParameter("content");
			String tastes = request.getParameter("taste");
			String[] taste = tastes.split("/");
			
			int id = Integer.parseInt(request.getParameter("id"));	
			
			Product p = new Product();
				p.setCode(code);
				p.setName(name);
				p.setBrandId(brandId);
				p.setCategoryId(categoryId);
				p.setPrice(price);
				p.setInventory(inventory);
				p.setDeliveryId(deliveryId);
				p.setContent(content);
				p.setId(id);
			
		
			service.update(p);
			
			for(int i=0;i<taste.length;i++) {
				ProductTaste temp = new ProductTaste(code, taste[i]);
				tService.update(temp);
			}
			
			response.sendRedirect("list");
		
		
	}
}
