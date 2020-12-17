package gc.service.user;

import java.util.List;

import gc.dao.gym.GymEvaluationDao;
import gc.dao.gym.jdbc.JdbcGymEvaluationDao;
import gc.entity.gym.GymEvaluation;

public class GymEvaluationService {
	
	private GymEvaluationDao gymEvaluationDao;

	public GymEvaluationService() {
		gymEvaluationDao = new JdbcGymEvaluationDao();
	}
	
	public int insert(GymEvaluation gymEvaluation) {
		
		return gymEvaluationDao.insert(gymEvaluation);
	}
	
	public int update(GymEvaluation gymEvaluation) {
		
		return gymEvaluationDao.update(gymEvaluation);
	}
	
	public int delete(int reservationNumber) {
		
		return gymEvaluationDao.delete(reservationNumber);
	}
	
		
}
