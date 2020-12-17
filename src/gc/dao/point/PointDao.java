package gc.dao.point;

import java.util.List;

import gc.entity.point.Point;

public interface PointDao {
	int insert(Point point);
	int update(Point point);
	int delete(String memberId);
	
	Point get(String id);
	List<Point> getList();
	

}
