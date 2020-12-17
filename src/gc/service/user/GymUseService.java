package gc.service.user;

import java.util.List;

import gc.dao.gym.GymUseDao;
import gc.dao.gym.jdbc.JdbcGymUseDao;
import gc.entity.gym.GymUse;
import gc.entity.trainer.TrainerUse;

public class GymUseService {
	
	private GymUseDao gymUseDao;
	
	public GymUseService() {
		gymUseDao = new JdbcGymUseDao();
	}
	
	public int insert(GymUse gymUse) {
		
		return gymUseDao.insert(gymUse);
	}
	
	public int update(GymUse gymUse) {
		
		return gymUseDao.update(gymUse);
	}
	
	public int delete(int reservationNumber) {
		
		return gymUseDao.delete(reservationNumber);
	}
	
	public GymUse get(int reservationNumber) {
		
		return gymUseDao.get(reservationNumber);
	}
	
	public List<GymUse> getList(){
		
		return gymUseDao.getList();
	}
}
