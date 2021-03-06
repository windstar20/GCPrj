package gc.entity.trainer;

import java.util.Date;

public class Trainer {

	private int id;
    private String name;
    private String gymName;
    private String gender;
    private String phone;
    private String delReason;
    private int del;
    private Date regdate;
    
    public Trainer() {

    }

	public Trainer(int id, String name, String gymName, String gender, String phone, String delReason, int del,
			Date regdate) {
		super();
		this.id = id;
		this.name = name;
		this.gymName = gymName;
		this.gender = gender;
		this.phone = phone;
		this.delReason = delReason;
		this.del = del;
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Trainer [id=" + id + ", name=" + name + ", gymName=" + gymName + ", gender=" + gender + ", phone="
				+ phone + ", delReason=" + delReason + ", del=" + del + ", regdate=" + regdate + "]";
	}

	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGymName() {
		return gymName;
	}

	public void setGymName(String gymName) {
		this.gymName = gymName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDelReason() {
		return delReason;
	}

	public void setDelReason(String delReason) {
		this.delReason = delReason;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	
    
    
}
