package gc.dao.point;

import java.util.List;

import gc.entity.point.PointUse;

public interface PointUseDao {

	int insert(PointUse pointUse);
	int update(PointUse pointUse);
	int delete(int id);
	
	PointUse get(int id);
	List<PointUse> getList();
}
