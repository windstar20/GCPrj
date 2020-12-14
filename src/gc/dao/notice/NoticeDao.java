package gc.dao.notice;

import java.util.List;

import gc.entity.notice.Notice;
import gc.entity.notice.view.NoticeView;

public interface NoticeDao {
	int insert(Notice notice);
	int update(Notice notice);
	int delete(int id);

	Notice get(int id);
	List<Notice> getList();
	List<Notice> getList(int startIndex, int endIndex, String field, String query);
	List<Notice> getList(int startIndex);
	List<NoticeView> getViewList();
	List<NoticeView> getViewList(int startIndex, int endIndex);
	List<NoticeView> getViewList(int startIndex, int endIndex, String field, String query);
	
//	�??��기능???(?���?, ?��?��?��)
//	1~5?��?���?
//	getList(String title, Date regDate Int page);
	
//	String title;
//	Date regDate;
//	int page;
	
}
