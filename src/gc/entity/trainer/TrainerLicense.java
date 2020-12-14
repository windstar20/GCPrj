package gc.entity.trainer;

public class TrainerLicense {

	private int trainerId;
    private String name;
    private String content;
    private String organ;
    
	public TrainerLicense() {
		// TODO Auto-generated constructor stub
	}

	public TrainerLicense(int trainerId, String name, String content, String organ) {
		super();
		this.trainerId = trainerId;
		this.name = name;
		this.content = content;
		this.organ = organ;
	}

	@Override
	public String toString() {
		return "TrainerLicense [trainerId=" + trainerId + ", name=" + name + ", content=" + content + ", organ=" + organ
				+ "]";
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOrgan() {
		return organ;
	}

	public void setOrgan(String organ) {
		this.organ = organ;
	}
	
}
