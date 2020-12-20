package gc.controller.admin.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.dao.gym.jdbc.JdbcGymDao;
import gc.entity.gym.Gym;
import gc.entity.gym.view.GymView;
import gc.service.user.GymService;

@WebServlet("/admin/user/gym/list")
public class GymListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int page = 1;
		int size = 5;
		int pageEnd = 1;
		
		GymService service = new GymService();
		JdbcGymDao dao = new JdbcGymDao();
		
		//List<Gym> list = service.getList();
		
		if(request.getParameter("page")!=null)
			page = Integer.parseInt(request.getParameter("page"));
		
		List<GymView> list = service.getViewList(page,size);
		int count = dao.getCount();
		int lastPage = count / 5;
		lastPage = count % 5 > 0 ? lastPage + 1 : lastPage;
		pageEnd = lastPage;
		
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("pageEnd", pageEnd);
		
		request.getRequestDispatcher("/admin/user/gym/list.jsp").forward(request, response);
	}
}
