package gc.dao.trainer;

import java.util.List;

import gc.entity.trainer.TrainerEvaluation;

public interface TrainerEvaluationDao {
	int insert(TrainerEvaluation trainerEvaluation);
	
	int update(TrainerEvaluation trainerEvaluation);
	
	int delete(int reservationNumber);
	
	TrainerEvaluation get(int reservationNumber);

}
