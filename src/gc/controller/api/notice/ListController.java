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


@WebServlet("/notice/list")
public class ListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int page = 1;
		int size = 5;
		int pageEnd = 1;
		String field = null;
		String query = null;
		
		NoticeService service = new NoticeService();
		JdbcNoticeDao dao = new JdbcNoticeDao();
		
		if(request.getParameter("page")!=null)
			page = Integer.parseInt(request.getParameter("page"));
		
		if(request.getParameter("size")!=null)
			size = Integer.parseInt(request.getParameter("size"));
		
			field = request.getParameter("field"); 		
			query = request.getParameter("query");
		
		List<Notice> list = service.getList(page, size, field, query);
//		List<NoticeView> list = service.getViewList(page, size, field, query);
		int count = dao.getCount();//게시물의 수를 구하기(함수처리)		
		int lastPage = count/5;    //마지막 페이지(1)
		lastPage = count%5 > 0 ? lastPage+1 : lastPage; //마지막 페이지(2)
//		lastPage = count%10=0?lastPage:lastPage+1;		
		pageEnd = lastPage;
		
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("size", size);
		request.setAttribute("pageEnd", pageEnd);	 
		request.getRequestDispatcher("/admin/notice/list.jsp").forward(request, response);
	}
	
	
}
