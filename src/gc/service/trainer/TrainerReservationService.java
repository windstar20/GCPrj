package gc.service.trainer;

import java.util.List;

import gc.dao.trainer.TrainerReservationDao;
import gc.dao.trainer.jdbc.JdbcTrainerReservationDao;
import gc.entity.trainer.TrainerReservation;

public class TrainerReservationService {
	private TrainerReservationDao trainerReservationDao;
	
	public TrainerReservationService() {
		trainerReservationDao = new JdbcTrainerReservationDao();
	}
	
	public int insert(TrainerReservation trainerReservation) {
		
		return trainerReservationDao.insert(trainerReservation);
	}
	
	public int update(TrainerReservation trainerReservation) {
		
		return trainerReservationDao.update(trainerReservation);
	}
	
	public int delete(int id) {
		
		return trainerReservationDao.delete(id);
	}
	
	public TrainerReservation get(int id) {
		
		return trainerReservationDao.get(id);
	}
	
	public List<TrainerReservation> getList(){
		
		return trainerReservationDao.getList();
	}

}
