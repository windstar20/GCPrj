package gc.controller.admin.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.entity.Gym;
import gc.entity.User;
import gc.service.GymService;
import gc.service.UserService;

@WebServlet("/admin/user/index")
public class IndexController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService service = new UserService();
		List<User> userList = service.getList();
		
		GymService gService = new GymService();
		List<Gym> gymList = gService.getList();
		
		int userLength = userList.size();
		int gymLength = gymList.size();
		
		req.setAttribute("userLength", userLength);
		req.setAttribute("gymLength", gymLength);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
