package gc.controller.admin.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.dao.notice.jdbc.JdbcNoticeDao;
import gc.entity.notice.Notice;
import gc.entity.notice.view.NoticeView;
import gc.service.notice.NoticeService;


@WebServlet("/admin/notice/list")
public class ListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		NoticeService service = new NoticeService();
//		JdbcNoticeDao dao = new JdbcNoticeDao();
		List<Notice> list = service.getList();
//		List<NoticeView> list = dao.getViewList();
		
		request.setAttribute("list", list);
		 
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	
	
}
