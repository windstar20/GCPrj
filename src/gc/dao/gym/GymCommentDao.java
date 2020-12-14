package gc.dao.gym;

import java.util.List;

import gc.entity.gym.GymComment;


public interface GymCommentDao {

	int insert(GymComment gymComment);
	int update(GymComment gymComment);
	int delete(int id);
	
	GymComment get(int id);
	List<GymComment> getList();
}
