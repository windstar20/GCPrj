package gc.dao.gym;

import java.util.List;

import gc.entity.gym.GymImage;


public interface GymImageDao {
	
	int insert(GymImage gymImage);
	int update(GymImage gymImage);
	int delete(int id);
	 
	GymImage get(int id);
	List<GymImage> getList();

}
