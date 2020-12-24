package gc.dao.point;

import java.util.List;

import gc.entity.point.PointCharging;
import gc.entity.point.view.PointChargingView;

public interface PointChargingDao{
	int insert(PointCharging pointCharging);
	int update(PointCharging pointCharging);
	int delete(int id);
	
	PointCharging get(int id);
	List<PointCharging> getList();
	List<PointChargingView> getViewList();
	List<PointChargingView> getViewList(int startIndex, int endIndex);
	List<PointChargingView> getViewList(int startIndex, int endIndex, String field, String query, String startDate, String endDate);
	List<PointChargingView> getViewList(int startIndex, int endIndex, String field, String query, String startDate, String endDate, String sortField, String sortOption);
	List<PointCharging> getList(String nicname);
}
