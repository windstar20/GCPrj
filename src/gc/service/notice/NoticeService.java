package gc.service.notice;

import java.util.List;

import gc.dao.notice.NoticeDao;
import gc.dao.notice.jdbc.JdbcNoticeDao;
import gc.entity.notice.Notice;

public class NoticeService {
	
	private NoticeDao noticeDao;
	
	public NoticeService() {
		noticeDao = new JdbcNoticeDao();
	}

	public List<Notice> getList() {
		
		return noticeDao.getList();
	}

	public Notice get(int id) {
		
		return noticeDao.get(id);
	}

	public int insert(Notice notice) {
		
		return noticeDao.insert(notice);
	}
	
	public int update(Notice notice) {
		int result = 0;

		result =  noticeDao.update(notice);
		
		return result;
	}
	
	public int delete(int id) {
		int result = 0;

		result =  noticeDao.delete(id);
		
		return result;
	}
}
