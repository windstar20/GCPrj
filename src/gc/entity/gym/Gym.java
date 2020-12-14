package gc.entity.gym;

import java.util.Date;

public class Gym {
	
	private int id;	
	private String pwd;
	private String name;	
	private String gym_name;	
	private String email;	
	private String telephone;	
	private String phone;	
	private String licenseNumber;
	private String adress;	
	private Date regdate;	
	
	public Gym() {
		
	}

	public Gym(int id, String pwd, String name, String gym_name, String email, String telephone, String phone,
			String licenseNumber, String adress, Date regdate) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.gym_name = gym_name;
		this.email = email;
		this.telephone = telephone;
		this.phone = phone;
		this.licenseNumber = licenseNumber;
		this.adress = adress;
		this.regdate = regdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGym_name() {
		return gym_name;
	}

	public void setGym_name(String gym_name) {
		this.gym_name = gym_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Gym [id=" + id + ", pwd=" + pwd + ", name=" + name + ", gym_name=" + gym_name + ", email=" + email
				+ ", telephone=" + telephone + ", phone=" + phone + ", licenseNumber=" + licenseNumber + ", adress="
				+ adress + ", regdate=" + regdate + "]";
	}
	
	
}
	
