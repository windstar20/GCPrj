package gc.entity.gym.view;

import java.util.Date;

import gc.entity.gym.Gym;

public class GymView extends Gym{
	
	public GymView() {
		
	}
	public GymView(int id, String pwd, String name, String gymName, String email, String telephone, String phone,
			String licenseNumber, String adress, Date regdate) {
		super(id,pwd,name,gymName,email,telephone,phone,licenseNumber,adress,regdate);
		
	}
	
}