package gc.service.trainer;

import java.util.List;

import gc.dao.trainer.TrainerImgDao;
import gc.dao.trainer.jdbc.JdbcTrainerImgDao;
import gc.entity.trainer.TrainerImg;

public class TrainerImgService {
	private TrainerImgDao trainerImgDao;
	
	public TrainerImgService() {
		trainerImgDao = new JdbcTrainerImgDao();
	}
	
	public int insert(TrainerImg trainerImg) {
		
		return trainerImgDao.insert(trainerImg);
	}
	
	public int update(TrainerImg trainerImg) {
		
		return trainerImgDao.update(trainerImg);
	}
	
	public int delete(int trainerId,String fileName) {
		
		return trainerImgDao.delete(trainerId, fileName);
	}

	public TrainerImg get(int trainerId,String fileName) {
		
		return trainerImgDao.get(trainerId, fileName);
	}
	
	public List<TrainerImg> getList(int trainerId){
		
		return trainerImgDao.getList(trainerId);
	}
}
