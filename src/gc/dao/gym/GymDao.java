package gc.dao.gym;

import java.util.List;

import gc.entity.gym.Gym;
import gc.entity.gym.view.GymView;

//SQL의 자바 함수화
public interface GymDao {
	
	int insert(Gym gym);
	int update(Gym gym);
	int delete(int id);
	int deleteAll(int ids[]);
	
	Gym get(int id);
	int getCount();
	
	List<Gym> getList();
	
	List<GymView> getViewList();
	List<GymView> getViewList(int startIndex, int endIndex);
	List<GymView> getViewList(int startIndex, int endIndex, String field, String query);
	
	Gym getLast();
}
