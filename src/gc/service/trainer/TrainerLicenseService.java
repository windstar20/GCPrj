package gc.service.trainer;

import java.util.List;

import gc.dao.trainer.TrainerLicenseDao;
import gc.dao.trainer.jdbc.JdbcTrainerLicenseDao;
import gc.entity.trainer.TrainerLicense;

public class TrainerLicenseService {
	private TrainerLicenseDao trainerLicenseDao;
	
	public TrainerLicenseService() {
		trainerLicenseDao = new JdbcTrainerLicenseDao();
	}
	
	public int insert(TrainerLicense trainerLicense) {
		
		return trainerLicenseDao.insert(trainerLicense);
	}
	
	public int update(TrainerLicense trainerLicense) {
		
		return trainerLicenseDao.update(trainerLicense);
	}

	public int delete(int trainerId,String name) {
		
		return trainerLicenseDao.delete(trainerId, name);
	}
	
	public TrainerLicense get(int trainerId,String name) {
		
		return trainerLicenseDao.get(trainerId, name);
	}
	
	public List<TrainerLicense> getList(int trainerId){
		
		return trainerLicenseDao.getList(trainerId);
	}
}
