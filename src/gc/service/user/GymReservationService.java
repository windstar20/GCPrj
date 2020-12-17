package gc.service.user;

import java.util.List;

import gc.dao.gym.GymReservationDao;
import gc.dao.gym.jdbc.JdbcGymReservationDao;
import gc.entity.gym.GymReservation;

public class GymReservationService {
	
	private GymReservationDao gymReservationDao;
	
	public GymReservationService() {
		gymReservationDao = new JdbcGymReservationDao();
	}
	
	public int insert(GymReservation gymReservation) {
		
		return gymReservationDao.insert(gymReservation);
	}
	
	public int update(GymReservation gymReservation) {
		
		return gymReservationDao.update(gymReservation);
	}
	
	public int delete(int id) {
		
		return gymReservationDao.delete(id);
	}
	
	public GymReservation get(int id) {
		
		return gymReservationDao.get(id);
	}
	
	public List<GymReservation> getList(){
		
		return gymReservationDao.getList();
	}
	
}
