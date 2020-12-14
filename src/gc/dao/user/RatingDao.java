package gc.dao.user;

import java.util.List;

import gc.entity.user.Rating;


public interface RatingDao {
	int insert(Rating rating);
	int update(Rating rating);
	int delete(int id);
	
	Rating get(int id);
	List<Rating> getList();
}
