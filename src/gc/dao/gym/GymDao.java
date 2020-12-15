package gc.dao.gym;

import java.util.List;

import gc.entity.gym.Gym;

//SQL의 자바 함수화
public interface GymDao {
	
	int insert(Gym gym);
	int update(Gym gym);
	int delete(int id);
	int deleteAll(int ids[]);
	
	Gym get(int id);
	List<Gym> getList();


}
