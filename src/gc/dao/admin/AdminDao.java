package gc.dao.admin;

import java.util.List;

import gc.entity.admin.Admin;

public interface AdminDao {
	int insert(Admin admin);
	int update(Admin admin);
	int delete(int id);
	
	Admin get(int id);
	List<Admin> getList();
	
}
