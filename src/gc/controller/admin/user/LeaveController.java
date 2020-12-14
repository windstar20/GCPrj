package gc.controller.admin.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.entity.User;
import gc.service.UserService;

@WebServlet("/admin/user/leave")
public class LeaveController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("leave.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nicname = req.getParameter("nicname");
		
		if(nicname.equals("")) {
			UserService service = new UserService();
			List<User> list = service.getLeaveList();
			
			req.setAttribute("list", list);
		}
		else {
			UserService service = new UserService();
			List<User> list = service.get(nicname);
		
			req.setAttribute("list",list);
		}
		req.getRequestDispatcher("leave.jsp").forward(req, resp);
	}

}
