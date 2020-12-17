package gc.dao.gym;

import java.util.List;

import gc.entity.gym.GymComment;


public interface GymCommentDao {

	int insert(GymComment gymComment);
	int update(GymComment gymComment);
	int delete(int id1, int id2);
	
	GymComment get(int id1, int id2);
	List<GymComment> getList();
}
