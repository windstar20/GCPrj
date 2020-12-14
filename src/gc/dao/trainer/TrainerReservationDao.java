package gc.dao.trainer;

import java.util.List;

import gc.entity.trainer.TrainerReservation;

public interface TrainerReservationDao {
	int insert(TrainerReservation trainerReservation);
	
	int update(TrainerReservation trainerReservation);
	
	int delete(int id);
	
	TrainerReservation get(int id);
	
	List<TrainerReservation> getList();

}
