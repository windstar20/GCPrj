package gc.service.point;

import java.util.List;

import gc.dao.point.PointDao;
import gc.dao.point.jdbc.JdbcPointDao;
import gc.entity.point.Point;


public class PointService {

	private PointDao PointDao;

	public PointService() {
		PointDao = new JdbcPointDao();
	}

	public int insert(Point Point) {

		return PointDao.insert(Point);
	}

	public int update(Point Point) {
		return PointDao.update(Point);
	}


	public int delete(String memberId) {

		return PointDao.delete(memberId);
	}


	public Point get(String memberId) {

		return PointDao.get(memberId);
	}

	

	public List<Point> getList() {

		
		return PointDao.getList();
	};
	
	
	public void ChangeAmount(String memberId, int amount) {
		Point p = PointDao.get(memberId);
		amount += p.getcurrentAmount();
		p.setcurrentAmount(amount);
		PointDao.update(p);
	}


	
	














}
