package gc.controller.admin.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.entity.user.User;
import gc.service.user.UserService;

public class UserRegController extends HttpServlet {
	
	private UserService service;
	
	public UserRegController() {
		
		service = new UserService();
		
	}
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user = service.overlapId();
		
		request.setAttribute("userlist", list);
		
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
		
		
	}

}
