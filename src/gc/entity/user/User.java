package gc.entity.user;

import java.util.Date;

public class User {

	private int id;
	private String nicname;
	private String pwd;
	private String name;
	private String gender;
	private int age;
	private String phone;
	private Date regdate;
	private String email;
	private String address;
	private int warningCount;
	private String recommendName;
	private int ratingId;
	private int leave;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id, String nicname, String pwd, String name, String gender, int age, String phone, Date regdate,
			String email, String address, int warningCount, String recommendName, int ratingId,int leave) {
		super();
		this.id = id;
		this.nicname = nicname;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.regdate = regdate;
		this.email = email;
		this.address = address;
		this.warningCount = warningCount;
		this.recommendName = recommendName;
		this.ratingId = ratingId;
		this.leave = leave;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", nicname=" + nicname + ", pwd=" + pwd + ", name=" + name + ", gender=" + gender
				+ ", age=" + age + ", phone=" + phone + ", regdate=" + regdate + ", email=" + email + ", address="
				+ address + ", warningCount=" + warningCount + ", recommendName=" + recommendName + ", ratingId="
				+ ratingId + ", leave=" + leave + "]";
	}

	public int getLeave() {
		return leave;
	}

	public void setLeave(int leave) {
		this.leave = leave;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNicname() {
		return nicname;
	}

	public void setNicname(String nicname) {
		this.nicname = nicname;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getWarningCount() {
		return warningCount;
	}

	public void setWarningCount(int warningCount) {
		this.warningCount = warningCount;
	}

	public String getRecommendName() {
		return recommendName;
	}

	public void setRecommendName(String recommendName) {
		this.recommendName = recommendName;
	}

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}


	
}

