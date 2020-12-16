package gc.controller.admin.user.trainer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.entity.trainer.Trainer;
import gc.service.trainer.TrainerService;

@WebServlet("/admin/user/trainer/list")
public class ListController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page=1;
		int size=10;
		int pageNum=1;
		String name="";
		String gymName="";
		String phone="";
		
		TrainerService service = new TrainerService();
		
		if(request.getParameter("page")!=null)
			page = Integer.parseInt(request.getParameter("page"));
			
		if(request.getParameter("size")!=null)
			size = Integer.parseInt(request.getParameter("size"));
		
		if(request.getParameter("name")!=null)
			name = request.getParameter("name");
		
		if(request.getParameter("gymName")!=null)
			gymName = request.getParameter("gymName");
		
		if(request.getParameter("phone")!=null)
			phone = request.getParameter("phone");
		
		List<Trainer> list = service.getList(0, 10, name, gymName,phone,0);
		
		if(list.size()%10==0)
			pageNum = list.size()/size;
		else
			pageNum = list.size()/size+1;
		
		
		list = service.getList(page, size, name, gymName,phone,0);
		
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("size", size);
		request.setAttribute("pageNum", pageNum);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	 
		
	}
}
