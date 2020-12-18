package gc.dao.point;

import java.util.List;

import gc.entity.point.Point;
import gc.entity.point.view.PointView;

public interface PointDao {
	int insert(Point point);
	int update(Point point);
	int delete(String memberId);
	
	Point get(String memberId);
	List<Point> getList();
	
	PointView getView(String field,String memberId);

}
