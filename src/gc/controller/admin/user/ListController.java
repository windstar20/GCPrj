package gc.controller.admin.user;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import gc.entity.user.User;
import gc.service.user.UserService;



@WebServlet("/admin/user/list")
public class ListController extends HttpServlet {
	 
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
			UserService service = new UserService();
			List<User> list = service.getList();
			
			request.setAttribute("userlist", list);
			
			request.getRequestDispatcher("list.jsp").forward(request, response);
			
			
	}
}
