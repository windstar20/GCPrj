package gc.controller.admin.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.entity.user.User;
import gc.service.user.UserService;

@WebServlet("/admin/user/leave")
public class LeaveController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/admin/user/leave.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String field = "name";
		String query = "";
		
		if(req.getParameter("field")!=null)
			field = req.getParameter("field");
		
		if(req.getParameter("query")!=null)
			query = req.getParameter("query");
		
		UserService service = new UserService();
		
		List<User> list = service.getList(field,query,1);
		
		req.setAttribute("list",list);
		
		req.getRequestDispatcher("/admin/user/leave.jsp").forward(req,resp);
		
		
	}
	
}
