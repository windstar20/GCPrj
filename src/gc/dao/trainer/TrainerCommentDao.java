package gc.dao.trainer;

import java.util.List;

import gc.entity.trainer.TrainerComment;

public interface TrainerCommentDao {
	int insert(TrainerComment trainerComment);
	
	int update(TrainerComment trainerComment);
	
	int delete(int id1,int id2);
	
	TrainerComment get(int id1, int id2);

}
