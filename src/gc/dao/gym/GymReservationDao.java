package gc.dao.gym;

import java.util.List;

import gc.entity.gym.GymReservation;


public interface GymReservationDao {
	
	int insert(GymReservation gymReservation);
	int update(GymReservation gymReservation);
	int delete(int id);
	
	GymReservation get(int id);
	List<GymReservation> getList();

}
