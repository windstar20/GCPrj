package gc.entity.trainer;

public class TrainerImg {
	
	private int trainerId;
    private String fileName;
    
    public TrainerImg() {

    }

	public TrainerImg(int trainerId, String fileName) {
		super();
		this.trainerId = trainerId;
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "TrainerImg [trainerId=" + trainerId + ", fileName=" + fileName + "]";
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
    
}
