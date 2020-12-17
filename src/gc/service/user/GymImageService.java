package gc.service.user;

import java.util.List;

import gc.dao.gym.GymImageDao;
import gc.dao.gym.jdbc.JdbcGymImageDao;
import gc.entity.gym.GymImage;

public class GymImageService {

	private GymImageDao gymImageDao;
	
	public GymImageService() {
		gymImageDao = new JdbcGymImageDao();
	}
	
	public int insert(GymImage gymImage) {
		
		return gymImageDao.insert(gymImage);
	}
	
	public int update(GymImage gymImage) {
		
		return gymImageDao.update(gymImage);
	}
	
	public int delete(int gymId) {
		
		return gymImageDao.delete(gymId);
	}
	
	public GymImage get(int gymId) {
		
		return gymImageDao.get(gymId);
	}
	
	public List<GymImage> getList(){
		
		return gymImageDao.getList();
	}
	
}
