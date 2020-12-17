package gc.controller.admin.product;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.dao.product.jdbc.JdbcProductDao;
import gc.entity.product.Brand;
import gc.entity.product.Category;
import gc.entity.product.Product;
import gc.entity.product.ProductTaste;
import gc.entity.product.view.ProductView;
import gc.service.product.BrandService;
import gc.service.product.CategoryService;
import gc.service.product.ProductListService;
import gc.service.product.ProductService;
import gc.service.product.TasteService;
import oracle.net.ano.Service;


@WebServlet("/admin/product/reg")
public class RegController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BrandService bService = new BrandService();
		CategoryService cService = new CategoryService();
		
		List<Brand> bList = bService.getList();
		List<Category> cList = cService.getList();
		
		req.setAttribute("bList",bList);
		req.setAttribute("cList",cList);
		
		req.getRequestDispatcher("reg.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductService service = new ProductService();
		TasteService tService = new TasteService();
		
		String code = req.getParameter("code");
		String name = req.getParameter("product-name");//web에서 받아온 text
		int brandId = Integer.parseInt(req.getParameter("brand"));
		int categoryId = Integer.parseInt(req.getParameter("category"));
		int price = Integer.parseInt(req.getParameter("price"));
		int inventory = Integer.parseInt(req.getParameter("inventory"));
		int deliveryId = Integer.parseInt(req.getParameter("delivery-price"));
		String content = req.getParameter("content");

		String tastes = req.getParameter("taste");
		String[] taste = tastes.split("/");

		Product lastP = service.getLast();
		int newId = lastP.getId()+1;
		
		Product p = new Product();
		p.setId(newId);
		p.setCode(code);
		p.setName(name);
		p.setBrandId(brandId);
		p.setCategoryId(categoryId);
		p.setPrice(price);
		p.setInventory(inventory);
		p.setDeliveryId(deliveryId);
		p.setContent(content);			
		
		service.insert(p);		

		for(int i=0;i<taste.length;i++) {
			ProductTaste temp = new ProductTaste(code,taste[i]);
			tService.insert(temp);
		}
		
		//맛에 대한건 와일문, 배열의 길이만큼 돌면서 insert
		//3개면 3번 돌면서 insert
		
		
		resp.sendRedirect("list");
	}

}
