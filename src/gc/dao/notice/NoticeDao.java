package gc.dao.notice;

import java.util.List;

import gc.entity.notice.Notice;

public interface NoticeDao {
	int insert(Notice notice);
	int update(Notice notice);
	int delete(int id);
	
	Notice get(int id);
	List<Notice> getList();
	
//	�??��기능???(?���?, ?��?��?��)
//	1~5?��?���?
//	getList(String title, Date regDate Int page);
	
//	String title;
//	Date regDate;
//	int page;
	
}
