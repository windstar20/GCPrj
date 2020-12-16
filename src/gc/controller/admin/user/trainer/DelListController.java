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

@WebServlet("/admin/user/trainer/dellist")
public class DelListController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page=1;
		int size=10;
		int pageNum=1;
		String name="";
		String gymName="";
		
		TrainerService service = new TrainerService();
		
		if(request.getParameter("page")!=null)
			page = Integer.parseInt(request.getParameter("page"));
			
		if(request.getParameter("size")!=null)
			size = Integer.parseInt(request.getParameter("size"));
		
		if(request.getParameter("name")!=null)
			name = request.getParameter("name");
		
		if(request.getParameter("gymName")!=null)
			gymName = request.getParameter("gymName");
		
		List<Trainer> list = service.getList(0, 10, name, gymName,"",1);
		
		if(list.size()%10==0)
			pageNum = list.size()/size;
		else
			pageNum = list.size()/size+1;
		
		
		list = service.getList(page, size, name, gymName,"",1);
		
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("size", size);
		request.setAttribute("pageNum", pageNum);
		request.getRequestDispatcher("dellist.jsp").forward(request, response);
	 
		
	}
}
