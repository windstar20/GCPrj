package gc.entity.trainer;

import java.util.Date;

public class TrainerContest {
	
	private int	trainerId;
    private String name;
    private String content;
    private Date date;
    
    public TrainerContest() {

    }

	public TrainerContest(int trainerId, String name, String content, Date date) {
		super();
		this.trainerId = trainerId;
		this.name = name;
		this.content = content;
		this.date = date;
	}

	@Override
	public String toString() {
		return "TrainerContest [trainerId=" + trainerId + ", name=" + name + ", content=" + content + ", date=" + date
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
    
}
