package gc.controller.admin.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import gc.entity.user.User;
import gc.service.user.UserService;



@WebServlet("/admin/user/detail")
public class DetailController extends HttpServlet{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
	    UserService service = new UserService();
	    User u  = service.get(id);
	
	    req.setAttribute("u", u);
	    req.getRequestDispatcher("/admin/user/detail.jsp").forward(req, resp);
	}
}
