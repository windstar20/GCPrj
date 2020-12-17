package gc.controller.admin.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.entity.user.User;
import gc.service.user.UserService;

@WebServlet("/user/sign/signin")
public class SignController extends HttpServlet {
	

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService service = new UserService();
		User user = service.overlapId();
		
		request.setAttribute("userlist", user);
		
		request.getRequestDispatcher("signin.jsp").forward(request, response);
		
	}

}
