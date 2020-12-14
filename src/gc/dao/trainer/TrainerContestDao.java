package gc.dao.trainer;

import java.util.List;

import gc.entity.trainer.TrainerContest;

public interface TrainerContestDao {
	int insert(TrainerContest trainerContest);
	
	int update(TrainerContest trainerContest);
	
	int delete(int trainerId, String name);
	
	List<TrainerContest> getList(int trainerId);
	
}
