package gc.service.trainer;

import gc.dao.trainer.TrainerEvaluationDao;
import gc.dao.trainer.jdbc.JdbcTrainerEvaluationDao;
import gc.entity.trainer.TrainerEvaluation;

public class TrainerEvaluationService {
	private TrainerEvaluationDao trainerEvaluationDao;
	
	public TrainerEvaluationService() {
		trainerEvaluationDao = new JdbcTrainerEvaluationDao();
	}

	public int insert(TrainerEvaluation trainerEvaluation) {
		
		return trainerEvaluationDao.insert(trainerEvaluation);
	}
	
	public int update(TrainerEvaluation trainerEvaluation) {
		
		return trainerEvaluationDao.update(trainerEvaluation);
	}
	
	public int delete(int reservationNumber) {
		
		return trainerEvaluationDao.delete(reservationNumber);
	}
	
	public TrainerEvaluation get(int reservationNumber) {
		
		return trainerEvaluationDao.get(reservationNumber);
	}
}
