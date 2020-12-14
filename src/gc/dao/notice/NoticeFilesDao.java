package gc.dao.notice;

import java.util.List;

import gc.entity.notice.NoticeFiles;

public interface NoticeFilesDao {
	int insert(NoticeFiles noticefiles);
	int update(NoticeFiles noticefiles);
	int delete(int noticeId);
	
	NoticeFiles get(int noticeId);
	List<NoticeFiles> getList();
	
}
