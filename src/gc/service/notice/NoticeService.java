package gc.service.notice;

import java.util.List;

import gc.dao.notice.NoticeDao;
import gc.dao.notice.jdbc.JdbcNoticeDao;
import gc.entity.notice.Notice;
import gc.entity.notice.view.NoticeView;

public class NoticeService {

	private NoticeDao noticeDao;

	public NoticeService() {
		
		noticeDao = new JdbcNoticeDao();
		
	}

	public List<Notice> getList() {
		
		
		
		return noticeDao.getList();
	}
	
	List<Notice> getList(int startIndex){
		
		
		return noticeDao.getList(startIndex);
	}
	
	public List<Notice> getList(int page, int size, String field, String qurey) {

		int startIndex = 1 + (page - 1) * size; // 1, 11, 21, 31.....
		int endIndex = page * 10; // 10, 20, 30, 50 ,60.....

		return noticeDao.getList(startIndex, endIndex, field, qurey);
	}
	

//	public int deleteAll(int[] ids) {
//		// dao 를 사용하는 이유
//		// 1.협업
//		// 2. 재사용
//		// 3. 데이터(소스)를 숨기는 것
//		
//		// DELETE NOTICE WHERE ID IN (...);
//		// noticeDao.deleteAll(ids);
//
//		int result = 0;
//		for (int i = 0; i < ids.length; i++) {
//			int id = ids[i];
//			result += noticeDao.delete(id);
//		}
//
//		return result;
//	}

//	public int hitUp(int id) {
//
////		int result = noticeDao.hitUp(id);
//
//		// SELECT * FROM NOTICE WHERE ID=?
//		Notice notice = noticeDao.get(id);
//		notice.setHit(notice.getHit() + 1);
//		// UPDATE NOTICE SET ... WHERE ID=?
//		noticeDao.update(notice);
//
//	}
	public List<NoticeView> getViewList() {
		
		
		return noticeDao.getViewList();
	}
	
	public List<NoticeView> getViewList(int startIndex, int endIndex) {
			
		return noticeDao.getViewList(startIndex, endIndex);
	}
	
	public List<NoticeView> getViewList(int page, int size, String field, String qurey) {

		int startIndex = 1 + (page - 1) * size; // 1, 11, 21, 31.....
		int endIndex = page * 10; // 10, 20, 30, 50 ,60.....

		return noticeDao.getViewList(startIndex, endIndex, field, qurey);
	}
	

	public Notice get(int id) {

		return noticeDao.get(id);
	}

	public int insert(Notice notice) {

		return noticeDao.insert(notice);
	}

	public int update(Notice notice) {
		int result = 0;

		result = noticeDao.update(notice);

		return result;
	}

	public int delete(int id) {
		int result = 0;

		result = noticeDao.delete(id);

		return result;
	}

	public int getLastId() {
		Notice n = noticeDao.getLast();
		
		// 업데이트 -> 컬럼
		// 서비스에서는 공개값 업데이트/좋아요 업데이트/조회수 업데이트
		// get -> set -> update();
		return n.getId();
	}
}