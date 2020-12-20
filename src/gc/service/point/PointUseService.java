package gc.service.point;

import java.util.List;

import gc.dao.point.PointUseDao;
import gc.dao.point.jdbc.JdbcPointUseDao;
import gc.entity.point.PointUse;
import gc.entity.point.view.PointUseView;


public class PointUseService {

	private PointUseDao pointUseDao;

	public PointUseService() {
		pointUseDao = new JdbcPointUseDao();
	}

	public int insert(PointUse pointUse) {

		return pointUseDao.insert(pointUse);
	}

	public int update(PointUse pointUse) {
		return pointUseDao.update(pointUse);
	}


	public int delete(int id) {

		return pointUseDao.delete(id);
	}


	public PointUse get(int id) {

		return pointUseDao.get(id);
	}

	

	public List<PointUse> getList() {

		
		return pointUseDao.getList();
	};

	public List<PointUseView> getViewList() {

		return pointUseDao.getViewList();
	};
	public List<PointUseView> getViewList(int page, int size) {

		int startIndex = 1 + (page-1)*size;
		int endIndex = size*page;
		return pointUseDao.getViewList(startIndex,endIndex);
	};
	public List<PointUseView> getViewList(int page, int size, String field, String query,String startDate, String endDate) {
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
		return pointUseDao.getViewList(startIndex, endIndex,field, query,startDate,endDate);
	};
	public List<PointUseView> getViewList(int page, int size, String field, String query,String startDate, String endDate,String sortField,String sortOption) {
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
		return pointUseDao.getViewList(startIndex, endIndex,field, query,startDate,endDate,sortField,sortOption);
	};
	
	














}
