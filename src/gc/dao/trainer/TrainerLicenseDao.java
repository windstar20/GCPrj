package gc.dao.trainer;

import java.util.List;

import gc.entity.trainer.TrainerLicense;

public interface TrainerLicenseDao {

	int insert(TrainerLicense trainerLicense);
	
	int update(TrainerLicense trainerLicense);
	
	int delete(int trainerId, String name);
	
	TrainerLicense get(int trainerId, String name);
	
	List<TrainerLicense> getList(int trainerId);

}
