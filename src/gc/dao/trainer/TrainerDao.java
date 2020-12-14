package gc.dao.trainer;

import java.util.List;

import gc.entity.trainer.Trainer;

public interface TrainerDao {
	int insert(Trainer trainer);
	
	int update(Trainer trainer);
	
	int delete(int id);
	
	Trainer get(int id);
	
	List<Trainer> getList();
	
}
