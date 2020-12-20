package gc.service.point;

import java.util.List;

import gc.dao.point.PointDao;
import gc.dao.point.jdbc.JdbcPointDao;
import gc.entity.point.Point;
import gc.entity.point.view.PointView;


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


	public int delete(String memberNicname) {

		return PointDao.delete(memberNicname);
	}


	public Point get(String memberNicname) {

		return PointDao.get(memberNicname);
	}

	

	public List<Point> getList() {

		
		return PointDao.getList();
	};
	
	public PointView getView(String field,String memberNicname) {

			memberNicname = "\'"+memberNicname + "\'";
		return PointDao.getView(field,memberNicname);
	}
	
	
	public void ChangeAmount(String memberNicname, int amount) {
		Point p = PointDao.get(memberNicname);
		amount += p.getcurrentAmount();
		p.setcurrentAmount(amount);
		PointDao.update(p);
	}


	
	














}
