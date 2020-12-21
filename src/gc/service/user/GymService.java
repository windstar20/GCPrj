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
import gc.entity.gym.view.GymView;

public class GymService {
	
	private GymDao gymDao;
	
	public GymService() {
		gymDao = new JdbcGymDao();
	}
	
	public int insert(Gym gym) {
		
		return gymDao.insert(gym);
	}
	public int update(Gym gym) {
		
		return gymDao.update(gym);
	}
	
	public int delete(int id) {
		
		return gymDao.delete(id);
	}
	
	public List<GymView> getViewList(){
		
		return gymDao.getViewList();
	}
	
	public List<GymView> getViewList(int page,int size){
		
		int startIndex = 1 + (page - 1) * size; 
		int endIndex = page * 5;
		
		return gymDao.getViewList(startIndex, endIndex);
	}
	
	public List<GymView> getViewList(int page,int size,String field,String query){
		
		int startIndex = 1 + (page - 1) * size; 
		int endIndex = page * 5;
		
		return gymDao.getViewList(startIndex, endIndex, field, query);
	}
	
	public Gym get(int id) {
		
		return gymDao.get(id);
	}
	
	public List<Gym> getList() {
		
		return gymDao.getList();
	}
	
	public int getCount() {
		
		return gymDao.getCount();
	}
	
}
