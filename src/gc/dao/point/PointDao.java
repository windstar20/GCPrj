package gc.dao.point;

import java.util.List;

import gc.entity.point.Point;

public interface PointDao {
	int insert(Point point);
	int update(Point point);
	int delete(int id);
	
	Point get(int id);
	List<Point> getList();
	
}
