package gc.controller.admin.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gc.service.notice.NoticeService;


@WebServlet("/admin/notice/del")
public class DelController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id")); // 문자?���? ?��?��?��?���? ?��?��?��?���? �??��?��?�� 받기

		NoticeService service = new NoticeService();
		int result = service.delete(id);
		
		response.sendRedirect("list");
		
	}
	
}