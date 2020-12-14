package gc.service.trainer;

import java.util.List;

import gc.dao.trainer.TrainerContestDao;
import gc.dao.trainer.jdbc.JdbcTrainerContestDao;
import gc.entity.trainer.TrainerContest;

public class TrainerContestService {
	private TrainerContestDao trainerContestDao;
	
	public TrainerContestService() {
		trainerContestDao = new JdbcTrainerContestDao();
	}

	public int insert(TrainerContest trainerContest) {
		
		return trainerContestDao.insert(trainerContest);
	}
	
	public int update(TrainerContest trainerContest) {
		
		return trainerContestDao.update(trainerContest);
	}
	
	public int delete(int trainerId,String name) {
		
		return trainerContestDao.delete(trainerId, name);
	}
	
	public List<TrainerContest> getList(int trainerId){
		
		return trainerContestDao.getList(trainerId);
	}
}
