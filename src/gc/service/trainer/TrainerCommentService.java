package gc.service.trainer;

import gc.dao.trainer.TrainerCommentDao;
import gc.dao.trainer.jdbc.JdbcTrainerCommentDao;
import gc.entity.trainer.TrainerComment;

public class TrainerCommentService {
	private TrainerCommentDao trainerCommentDao;

	public TrainerCommentService() {
		trainerCommentDao = new JdbcTrainerCommentDao();
	}
	
	public int insert(TrainerComment trainerComment) {
		
		return trainerCommentDao.insert(trainerComment);
	}
	
	public int update(TrainerComment trainerComment) {
		
		return trainerCommentDao.update(trainerComment);
	}
	
	public int delete(int reservationNumber, int trainerId) {
		
		return trainerCommentDao.delete(reservationNumber, trainerId);
	}
	
	public TrainerComment get(int reservationNumber, int trainerId) {
		
		return trainerCommentDao.get(reservationNumber, trainerId);
	}
}
