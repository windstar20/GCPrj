package gc.controller.admin.user.trainer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.entity.gym.Gym;
import gc.entity.trainer.Trainer;
import gc.entity.user.User;
import gc.service.trainer.TrainerService;
import gc.service.user.GymService;
import gc.service.user.UserService;

@WebServlet("/admin/user/index")
public class IndexController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		GymService gService = new GymService();
		TrainerService tService = new TrainerService();
		UserService uService = new UserService();
		
		List<Gym> gList = gService.getList();
		List<Trainer> tList = tService.getList(); 
		List<User> uList = uService.getList();
		
		int gymLength = gList.size();
		int trainerLength = tList.size();
		int userLength = uList.size();
		
		req.setAttribute("gymLength", gymLength);
		req.setAttribute("trainerLength", trainerLength);
		req.setAttribute("userLength", userLength);
		
		req.getRequestDispatcher("/admin/user/index.jsp").forward(req, resp);
	}
}
