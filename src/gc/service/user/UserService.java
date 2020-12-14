package gc.service.user;

import java.util.List;

import gc.dao.user.UserDao;
import gc.dao.user.jdbc.JdbcUserDao;
import gc.entity.user.User;


public class UserService {
	private UserDao userDao;
	
	public UserService() {
		userDao = new JdbcUserDao();
	}
	public List<User> getList() {
	
		return userDao.getList();
	}

	public User get(int id) {
		
		return userDao.get(id);
	}
//-------------------------------------------
	public int insert(User user) {
		return userDao.insert(user);
	}

	public int update(User user) {
		return userDao.update(user);
	}
	
	public int delete(int id) {
		return userDao.delete(id);
	}
	
}
