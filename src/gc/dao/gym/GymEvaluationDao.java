package gc.dao.gym;

import java.util.List;

import gc.entity.gym.GymEvaluation;



public interface GymEvaluationDao {
	
	int insert(GymEvaluation gymEvaluation);
	int update(GymEvaluation gymEvaluation);
	int delete(int id);
	
	GymEvaluation get(int id);
	List<GymEvaluation> getList();
}
