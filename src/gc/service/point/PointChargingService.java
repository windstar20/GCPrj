package gc.service.point;

import java.util.List;

import gc.dao.point.PointChargingDao;
import gc.dao.point.jdbc.JdbcPointChargingDao;
import gc.entity.point.PointCharging;
import gc.entity.point.view.PointChargingView;


public class PointChargingService {

	private PointChargingDao pointChargingDao;

	public PointChargingService() {
		pointChargingDao = new JdbcPointChargingDao();
	}

	public int insert(PointCharging pointCharging) {

		return pointChargingDao.insert(pointCharging);
	}

	public int update(PointCharging pointCharging) {
		return pointChargingDao.update(pointCharging);
	}


	public int delete(int id) {

		return pointChargingDao.delete(id);
	}


	public PointCharging get(int id) {

		return pointChargingDao.get(id);
	}



	public List<PointCharging> getList() {


		return pointChargingDao.getList();
	};

	
	public List<PointChargingView> getViewList() {

		return pointChargingDao.getViewList();
	};
	public List<PointChargingView> getViewList(int page, int size) {
		int startIndex = 1 + (page-1)*size;
		int endIndex = size*page;
		return pointChargingDao.getViewList(startIndex,endIndex);
	};
	public List<PointChargingView> getViewList(int page, int size, String field, String query,String startDate, String endDate) {
		int startIndex=0;
		int endIndex=0;

		
		if(page!=0 && size!=0) {
			startIndex = 1 + (page-1)*size;
			endIndex = size*page;
		}
		if(startDate!=null && !startDate.equals(""))
			startDate="\'" + startDate +"\'";
		if(endDate!=null && !endDate.equals(""))
			endDate="\'" + endDate +"\'";
		return pointChargingDao.getViewList(startIndex, endIndex,field, query,startDate,endDate);
	};
	
	public List<PointChargingView> getViewList(int page, int size, String field, String query,String startDate, String endDate,String sortField,String sortOption) {
		int startIndex=0;
		int endIndex=0;
		

		
		if(page!=0 && size!=0) {
			startIndex = 1 + (page-1)*size;
			endIndex = size*page;
		}
		if(startDate!=null && !startDate.equals(""))
			startDate="\'" + startDate +"\'";
		if(endDate!=null && !endDate.equals(""))
			endDate="\'" + endDate +"\'";
		
		if(sortField==null||sortField.equals(""))
			sortField="id";
		if(sortOption==null||sortOption.equals(""))
			sortOption="asc";
		return pointChargingDao.getViewList(startIndex, endIndex,field, query,startDate,endDate,sortField,sortOption);
	}

	public List<PointCharging> getList(String nicname) {

		return pointChargingDao.getList(nicname);
	};















}
