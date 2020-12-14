package gc.dao.trainer;

import java.util.List;

import gc.entity.trainer.TrainerUse;

public interface TrainerUseDao {
	
	int insert(TrainerUse trainerUse);
	
	int update(TrainerUse trainerUse);
	
	int delete(int id);
	
	TrainerUse get(int id);
	
	List<TrainerUse> getList();

}
