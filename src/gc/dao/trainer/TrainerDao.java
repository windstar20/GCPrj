package gc.dao.trainer;

import java.util.List;

import gc.entity.trainer.Trainer;
import gc.entity.trainer.view.TrainerView;

public interface TrainerDao {
	int insert(Trainer trainer);
	
	int update(Trainer trainer);
	
	int delete(int id);
	
	Trainer get(int id);
	
	TrainerView getView(int id);
	
	List<Trainer> getList();
	
	List<Trainer> getList(int startIndex,int endIndex,int del);
	
	List<Trainer> getList(int startIndex, int endIndex,String name,String gymName,String phone,int del);
	
}
