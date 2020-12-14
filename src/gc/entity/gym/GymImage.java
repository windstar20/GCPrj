package gc.entity.gym;

public class GymImage {
	
	private int gymID;
	private String fileName;
	
	public GymImage() {
		
	}

	public GymImage(int gymID, String fileName) {
		super();
		this.gymID = gymID;
		this.fileName = fileName;
	}

	public int getGymID() {
		return gymID;
	}

	public void setGymID(int gymID) {
		this.gymID = gymID;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "GymImage [gymID=" + gymID + ", fileName=" + fileName + "]";
	}
	
}
