package gc.service.user;

import java.util.List;

import gc.dao.gym.GymCommentDao;
import gc.dao.gym.jdbc.JdbcGymCommentDao;
import gc.entity.gym.GymComment;

public class GymCommentService {
	
	private GymCommentDao gymCommentDao;
	
	public GymCommentService() {
		gymCommentDao = new JdbcGymCommentDao();
	}
	
	public int insert(GymComment gymComment){
		return gymCommentDao.insert(gymComment);
	}
	 
	public int update(GymComment gymComment) {
		return gymCommentDao.update(gymComment);
	}
	
	public int delete(int reservationNumber, int gymId) {
		return gymCommentDao.delete(reservationNumber, gymId);
	}
	public GymComment get(int reservationNumber, int gymId) {
		return gymCommentDao.get(reservationNumber, gymId);
	}
	 
	public List<GymComment> getList(){
		
		return gymCommentDao.getList();
	}
}
