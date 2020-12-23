package gc.controller.admin.user.trainer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.entity.trainer.Trainer;
import gc.entity.trainer.TrainerComment;
import gc.service.trainer.TrainerCommentService;
import gc.service.trainer.TrainerService;

@WebServlet("/admin/user/trainer/comment")
public class CommentController extends HttpServlet{

	TrainerCommentService service;
	
	public CommentController() {
		service = new TrainerCommentService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		TrainerService tService = new TrainerService();
		
		Trainer t = tService.get(id);
		
		req.setAttribute("t", t);
		
		req.getRequestDispatcher("/admin/user/trainer/comment.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		TrainerService tService = new TrainerService();
		
		Trainer t = tService.get(id);
		
		String field = "title";
		String query = "";
		
		if(req.getParameter("field")!=null)
			field = req.getParameter("field");
		
		if(req.getParameter("query")!=null)
			query = req.getParameter("query");
		
		List<TrainerComment> list = service.getList(0,10,field,query);
		
		req.setAttribute("t", t);
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/admin/user/trainer/comment.jsp").forward(req, resp);
	
	}
	
}
