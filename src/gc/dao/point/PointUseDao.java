package gc.dao.point;

import java.util.List;

import gc.entity.point.PointUse;
import gc.entity.point.view.PointUseView;

public interface PointUseDao {

	int insert(PointUse pointUse);
	int update(PointUse pointUse);
	int delete(int id);
	
	PointUse get(int id);
	List<PointUse> getList();
	List<PointUseView> getViewList();
	List<PointUseView> getViewList(int startIndex, int endIndex);
	List<PointUseView> getViewList(int startIndex, int endIndex, String field, String query, String startDate, String endDate);
	List<PointUseView> getViewList(int startIndex, int endIndex, String field, String query, String startDate, String endDate,String sortField, String sortOption);
}
