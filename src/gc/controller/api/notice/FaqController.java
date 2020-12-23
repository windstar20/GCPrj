package gc.controller.api.notice;

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

@WebServlet("/notice/faq")
public class FaqController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/notice/faq.jsp").forward(request, response);
		
	}
	
	
}
