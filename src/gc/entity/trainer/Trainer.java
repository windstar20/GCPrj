package gc.entity.trainer;

public class Trainer {

	private int id;
    private String name;
    private int gymId;
    private String gender;
    private String phone;
    
    public Trainer() {

    }

	public Trainer(int id, String name, int gymId, String gender, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.gymId = gymId;
		this.gender = gender;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Trainer [id=" + id + ", name=" + name + ", gymId=" + gymId + ", gender=" + gender + ", phone=" + phone
				+ "]";
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

	public int getGymId() {
		return gymId;
	}

	public void setGymId(int gymId) {
		this.gymId = gymId;
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
    
    
}
