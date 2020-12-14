package gc.controller.admin.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.entity.notice.Notice;
import gc.service.notice.NoticeService;

@WebServlet("/admin/notice/reg")
public class RegController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getMethod().equals("GET"))
			req.getRequestDispatcher("reg.jsp").forward(req, resp);
		else if (req.getMethod().equals("POST")) {
			
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			Notice notice = new Notice(title, content);

			NoticeService service = new NoticeService();
			service.insert(notice);
			resp.sendRedirect("list");
			
		}
	}
}
