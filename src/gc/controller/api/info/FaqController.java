package gc.controller.api.info;

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

@WebServlet("/info/info")
public class FaqController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/info/info.jsp").forward(request, response);
		
	}
	
	
}
