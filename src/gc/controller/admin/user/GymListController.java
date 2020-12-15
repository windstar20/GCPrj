package gc.controller.admin.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.entity.gym.Gym;
import gc.service.user.GymService;

@WebServlet("/admin/user/gym/list")
public class GymListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		GymService service = new GymService();
		List<Gym> list = service.getList();
		
		request.setAttribute("gymlist", list);
		
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
}
