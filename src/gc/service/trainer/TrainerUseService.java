package gc.service.trainer;

import java.util.List;

import gc.dao.trainer.TrainerUseDao;
import gc.dao.trainer.jdbc.JdbcTrainerUseDao;
import gc.entity.trainer.TrainerUse;

public class TrainerUseService {
	private TrainerUseDao trainerUseDao;
	
	public TrainerUseService() {
		trainerUseDao = new JdbcTrainerUseDao();
	}
	
	public int insert(TrainerUse trainerUse) {
		
		return trainerUseDao.insert(trainerUse);
	}
	
	public int update(TrainerUse trainerUse) {
		
		return trainerUseDao.update(trainerUse);
	}
	
	public int delete(int reservationNumber) {
		
		return trainerUseDao.delete(reservationNumber);
	}
	
	public TrainerUse get(int reservationNumber) {
		
		return trainerUseDao.get(reservationNumber);
	}
	
	public List<TrainerUse> getList(){
		
		return trainerUseDao.getList();
	}
}
