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
	List<Notice> getList(int startIndex);
	List<Notice> getList(int startIndex, int endIndex, String field, String query);
	
	List<NoticeView> getViewList();
	List<NoticeView> getViewList(int startIndex, int endIndex);
	List<NoticeView> getViewList(int startIndex, int endIndex, String field, String query);
	Notice getLast();
	
}
