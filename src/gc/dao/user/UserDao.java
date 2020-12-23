package gc.dao.user;

import java.util.List;

import gc.entity.user.User;



public interface UserDao {

	int insert(User user);
	int update(User user);
	int delete(int id);
	
	User overlapId(String nicname);
	
	User get(int id);
	List<User> getList();
	List<User> getList(String field,String query,int leave);
	
}
