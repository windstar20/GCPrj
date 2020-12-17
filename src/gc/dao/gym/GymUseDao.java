package gc.dao.gym;

import java.util.List;

import gc.entity.gym.GymUse;


public interface GymUseDao {
	
	int insert(GymUse gymUse);
	int update(GymUse gymUse);
	int delete(int id);
	
	GymUse get(int id);
	List<GymUse> getList();

}
