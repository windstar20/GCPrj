package gc.controller.admin.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.entity.point.PointCharging;
import gc.entity.point.PointUse;
import gc.entity.user.User;
import gc.service.point.PointChargingService;
import gc.service.point.PointUseService;
import gc.service.user.UserService;

@WebServlet("/admin/user/detail-point")
public class DetailPointController extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
	    UserService service = new UserService();
	    User u  = service.get(id);
	
	    req.setAttribute("u", u);
	    req.getRequestDispatcher("/admin/user/detail-point.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		UserService service = new UserService();
		PointChargingService cService = new PointChargingService();
		PointUseService uService = new PointUseService();
		User u  = service.get(id);
		
		List<PointCharging> cList = cService.getList(u.getNicname());
		List<PointUse> uList = uService.getList(u.getNicname());
		
		List<Object> list = new ArrayList<Object>();
		
		list.add(cList);
		list.add(uList);
		
	    req.setAttribute("u", u);
	    req.getRequestDispatcher("/admin/user/detail-point.jsp").forward(req, resp);
	}
}
