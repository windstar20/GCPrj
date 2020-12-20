package gc.dao.point;

import java.util.List;

import gc.entity.point.Point;
import gc.entity.point.view.PointView;

public interface PointDao {
	int insert(Point point);
	int update(Point point);
	int delete(String memberNicname);
	
	Point get(String memberNicname);
	List<Point> getList();
	
	PointView getView(String field,String memberNicname);

}
