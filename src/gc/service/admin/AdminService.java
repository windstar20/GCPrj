package gc.service.admin;

import java.util.List;

import gc.dao.admin.AdminDao;
import gc.dao.admin.jdbc.JdbcAdminDao;
import gc.entity.admin.Admin;

public class AdminService {
	
	private AdminDao adminDao;
	
	public AdminService() {
		adminDao = new JdbcAdminDao();
	}

	public List<Admin> getList() {
		
		return adminDao.getList();
	}

	public Admin get(int id) {
		
		return adminDao.get(id);
	}

	public int insert(Admin admin) {
		
		return adminDao.insert(admin);
	}
	
	public int update(Admin admin) {
		int result = 0;

		result =  adminDao.update(admin);
		
		return result;
	}
	
	public int delete(int id) {
		int result = 0;

		result =  adminDao.delete(id);
		
		return result;
	}
}
