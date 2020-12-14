package gc.controller.admin.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.entity.notice.Notice;
import gc.service.notice.NoticeService;


@WebServlet("/admin/notice/edit")
public class EidtController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id")); // 문자?���? ?��?��?��?���? ?��?��?��?���? �??��?��?�� 받기

		NoticeService service = new NoticeService();
		Notice n = service.get(id);
		
		request.setAttribute("n", n);
		
		request.getRequestDispatcher("/admin/notice/edit.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Notice notice = new Notice(title, content);
		notice.setId(Integer.parseInt(id));
		
		NoticeService service = new NoticeService();
		service.update(notice);
		
		response.sendRedirect("detail?id="+id);
		
	}
	
}