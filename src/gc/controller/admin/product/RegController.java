package gc.controller.admin.product;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import gc.dao.product.jdbc.JdbcProductDao;
import gc.entity.notice.Notice;
import gc.entity.product.Brand;
import gc.entity.product.Category;
import gc.entity.product.Product;
import gc.entity.product.ProductTaste;
import gc.entity.product.view.ProductView;
import gc.service.notice.NoticeService;
import gc.service.product.BrandService;
import gc.service.product.CategoryService;
import gc.service.product.ProductListService;
import gc.service.product.ProductService;
import gc.service.product.TasteService;
import oracle.net.ano.Service;

@MultipartConfig(
	    fileSizeThreshold = 1024*1024,
	    maxFileSize = 1024*1024*5,
	    maxRequestSize = 1024*1024*5*5
	)

@WebServlet("/admin/product/reg")
public class RegController extends HttpServlet{
		
	private ProductService service;

	public RegController() {
		service = new ProductService();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BrandService bService = new BrandService();
		CategoryService cService = new CategoryService();
		
		List<Brand> bList = bService.getList();
		List<Category> cList = cService.getList();
		
		request.setAttribute("bList",bList);
		request.setAttribute("cList",cList);
		
		request.getRequestDispatcher("reg.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ProductService service = new ProductService();
		TasteService tService = new TasteService();
		
		String code = request.getParameter("code");
		String name = request.getParameter("product-name");//web에서 받아온 text
		int brandId = Integer.parseInt(request.getParameter("brand"));
		int categoryId = Integer.parseInt(request.getParameter("category"));
		int price = Integer.parseInt(request.getParameter("price"));
		int inventory = Integer.parseInt(request.getParameter("inventory"));
		int deliveryId = Integer.parseInt(request.getParameter("delivery-price"));
		String content = request.getParameter("content");
		int display = Integer.parseInt(request.getParameter("display"));

		String tastes = request.getParameter("taste");
		String[] taste = tastes.split("/");

		Product lastP = service.getLast();
		int newId = lastP.getId()+1;
		
		Product product = new Product();
		product.setId(newId);
		product.setCode(code);
		product.setName(name);
		product.setBrandId(brandId);
		product.setCategoryId(categoryId);
		product.setPrice(price);
		product.setInventory(inventory);
		product.setDeliveryId(deliveryId);
		product.setContent(content);		
		product.setDisplay(display);
		
		service.insert(product);		

		for(int i=0;i<taste.length;i++) {
			ProductTaste temp = new ProductTaste(code,taste[i]);
			tService.insert(temp);
		}
		
		Collection<Part> fileParts = request.getParts();
		
		String fileNames = "";
		for(Part p : fileParts) {
			if(p.getName().equals("file") && p.getSize()>0) {
				Part filePart = p;
				
				String fileName = filePart.getSubmittedFileName();
				fileNames += fileName;
				fileNames += ",";
				
				String pathTemp = request.getServletContext().getRealPath("static/product/2020/"+newId+"/");
				
				File path = new File(pathTemp);
				if(!path.exists())
					path.mkdirs();
				
				String filePath = pathTemp + File.separator + fileName;
				System.out.println(filePath);
				
				InputStream fis = filePart.getInputStream();
				FileOutputStream fos = new FileOutputStream(filePath);
				
				byte[] buf = new byte[1024];
				int size = 0;
				while((size = fis.read(buf)) != -1)
					fos.write(buf, 0, size);
				fos.close();
				fis.close();
			}
		}
		
//		NoticeService service = new NoticeService();
//		Notice notice = new Notice(title, content, fileNames); //newId
//		// 꼬랑지 떼기~
//		notice.setFiles(fileNames); // "img1.jpg,img2.png,"
//		notice.setAdminNicname("관리자");
//		service.insert(notice);
				
		//맛에 대한건 와일문, 배열의 길이만큼 돌면서 insert
		//3개면 3번 돌면서 insert
		
		
		response.sendRedirect("list");
	}

}
