package gc.controller.admin.product;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
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
import gc.service.product.BrandService;
import gc.service.product.CategoryService;
import gc.service.product.ProductListService;
import gc.service.product.ProductService;
import gc.service.product.TasteService;

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
		Part filePart = request.getPart("file");//#1. jsp file 파라미터를 받음
		
		//자식테이블인 맛 컬럼을 tastes로 받아
		String tastes = request.getParameter("taste");
		//다수로 작성되었다면 / 단위로 split 하여 taste[]로 담는다.
		String[] taste = tastes.split("/");

		//getLast()를 실행하여 마지막 id 값을 lastP로 받음. 
		Product lastP = service.getLast();
		int newId = lastP.getId()+1;  //마지막 id 값에+1 하여 최종적 Id 생성.	
		
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
		
		
		for(int i=0;i<taste.length;i++) {
			ProductTaste temp = new ProductTaste(code,taste[i]);
			tService.insert(temp);
		}

//==========멀티 files upload: files 	
/*		Collection<Part> fileParts = request.getParts();
		//fileNames==image
		String fileName = "";
		String fileNames = "";
		for(Part p : fileParts) {   //getName() 파라미터이름을 구함
			if(p.getName().equals("file") && p.getSize()>0) {
				Part filePart = p;
				
				fileName = filePart.getSubmittedFileName(); //업로드한 파일의 이름을 구함.
				fileNames += fileName;
				fileNames += ",";
				
				String pathTemp = request.getServletContext().getRealPath("/image/admin/product/"+newId+"/");
				
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
*/	
//==========file
		
			//9. 전송한 파일이 없으면?답:체크한다.
		if(filePart !=null) {
			String fileName = filePart.getSubmittedFileName();
			product.setImage(fileName);
		
			//7. 마지막 경로를 위한 처리(작성자에 따라 폴더가 바뀜)
			//int lastId = service.getLastId() +1;   
			
			//8. 현재연도 수 찾기 2020 일단은 2020으로 고정.			
			
			//1. 배포된 디렉토리의 폴더에 저장
			//  /static/notice/2020/26/ 이 경로에 저장하겠다. 파일저장을 위한 조치사항
			//배포된 디렉토리에서의 폴더에 저장 그래서 경로 설정이 필요.
						
			//2. 물리경로를 알아내기
										//context=문맥=서블릿간의 교류를 위해 필요한 공동자원이 안에있음
			String pathTemp = request.getServletContext().getRealPath("/static/notice/2020/"+newId+"/");  
			System.out.println(pathTemp);	          	//realpath=물리경로를 알아내주는 녀석

			//3. 알아낸 경로를 절대 경로로 변경.
			File path = new File(pathTemp); //=>절대경로로 바꾸는 작업
			if(!path.exists())
				  path.mkdirs();			//경로를 한번에 만들어라			
			
			//4. 파일경로를 위해 filePath를 만듦 = pathTemp(경로)+File.separator(구분자)+ filePart.getsubmittedFileName(파일)
			String filePath = pathTemp + File.separator + fileName;
									// "\\"이렇게 할수없다. 다른 서비스유닉스,리눅스에서는 경로지정자가 다르다.=>/ 
									//그래서 경로구분자를 얻어내야 한다.=>File.separator
			
			//5. 스트림 준비
			InputStream fis = filePart.getInputStream();
			FileOutputStream fos = new FileOutputStream(filePath);//()파일을 만들어주긴 하지만, 경로가 없으면 문제가됨.
			
			//6. 파일쓰기
			byte[] buf = new byte[1024];
			int size = 0;
			while((size = fis.read(buf)) != -1)
				fos.write(buf, 0, size);//버퍼가 1024인데 3개만 있으면 안되므로, size만큼
			
			fos.close();
			fis.close();			
		}//end if
		
//		File submittedFile = new File("/static/notice/2020/26"+filePart.getSubmittedFileName());
		System.out.printf("title:%s, file:%s\n", code, filePart.getSubmittedFileName());

/*multy files product.setImage(fileName); */
		service.insert(product);		
		
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
