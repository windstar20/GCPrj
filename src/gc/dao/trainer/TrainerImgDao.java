package gc.dao.trainer;

import java.util.List;

import gc.entity.trainer.TrainerImg;

public interface TrainerImgDao {
	int insert(TrainerImg trainerImg);
	
	int update(TrainerImg trainerImg);
	
	int delete(int trainerId,String fileName);
	
	TrainerImg get(int trainerId, String fileName);
	
	List<TrainerImg> getList(int trainerId);

}
