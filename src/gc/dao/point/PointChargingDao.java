package gc.dao.point;

import java.util.List;

import gc.entity.point.PointCharging;

public interface PointChargingDao{
	int insert(PointCharging pointCharging);
	int update(PointCharging pointCharging);
	int delete(int id);
	
	PointCharging get(int id);
	List<PointCharging> getList();
}
