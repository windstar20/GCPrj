package gc.service.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gc.dao.gym.GymDao;
import gc.dao.gym.jdbc.JdbcGymDao;
import gc.entity.gym.Gym;

public class GymService {
	
	private GymDao gymDao;
	
	public GymService() {
			
		gymDao = new JdbcGymDao();
		
	}
	
	public List<Gym> getList() {
		
		return gymDao.getList();
	}
	
	public Gym get(int id) {
		
		return gymDao.get(id);
	}
	
	public int insert(Gym gym) {
		
		return gymDao.insert(gym);
	}
	
	public int update(Gym gym) {
		
		return gymDao.update(gym);
	}
}
