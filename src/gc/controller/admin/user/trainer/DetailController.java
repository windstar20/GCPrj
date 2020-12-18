package gc.controller.admin.user.trainer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.dao.trainer.jdbc.JdbcTrainerReservationDao;
import gc.entity.trainer.Trainer;
import gc.entity.trainer.TrainerContest;
import gc.entity.trainer.TrainerLicense;
import gc.entity.trainer.view.TrainerView;
import gc.service.trainer.TrainerCommentService;
import gc.service.trainer.TrainerContestService;
import gc.service.trainer.TrainerImgService;
import gc.service.trainer.TrainerLicenseService;
import gc.service.trainer.TrainerReservationService;
import gc.service.trainer.TrainerService;

@WebServlet("/admin/user/trainer/detail")
public class DetailController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		TrainerService service = new TrainerService();
		TrainerLicenseService lService = new TrainerLicenseService();
		TrainerContestService cService = new TrainerContestService();
		TrainerImgService iService = new TrainerImgService();
		
		TrainerView t = service.getView(id);
		
		List<TrainerLicense> lList = lService.getList(id);
		List<TrainerContest> cList = cService.getList(id);
		
		int lListLength = lList.size();
		int cListLength = cList.size();
		
		req.setAttribute("t", t);
		req.setAttribute("lList", lList);
		req.setAttribute("lListLength", lListLength);
		req.setAttribute("cList", cList);
		req.setAttribute("cListLength", cListLength);
		
		req.getRequestDispatcher("/admin/user/trainer/detail.jsp").forward(req, resp);
	
	}
}
