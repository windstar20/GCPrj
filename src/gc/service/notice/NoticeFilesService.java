package gc.service.notice;

import java.util.List;

import gc.dao.notice.NoticeFilesDao;
import gc.dao.notice.jdbc.JdbcNoticeFilesDao;
import gc.entity.notice.NoticeFiles;

public class NoticeFilesService {
	
	private NoticeFilesDao noticeFilesDao;
	
	public NoticeFilesService() {
		noticeFilesDao = new JdbcNoticeFilesDao();
	}

	public List<NoticeFiles> getList() {
		
		return noticeFilesDao.getList();
	}

	public NoticeFiles get(int noticeId) {
		
		return noticeFilesDao.get(noticeId);
	}

	public int insert(NoticeFiles noticeFiles) {
		
		return noticeFilesDao.insert(noticeFiles);
	}
	
	public int update(NoticeFiles noticeFiles) {
		int result = 0;

		result =  noticeFilesDao.update(noticeFiles);
		
		return result;
	}
	
	public int delete(int noticeId) {
		int result = 0;

		result =  noticeFilesDao.delete(noticeId);
		
		return result;
	}
}
