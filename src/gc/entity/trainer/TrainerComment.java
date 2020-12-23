package gc.entity.trainer;

import java.util.Date;

public class TrainerComment {
	
	private int reservationNumber;
	private int trainerId;
	private Date regdate;
	private String content;
	private String title;
	
	public TrainerComment() {
 
	}

	public TrainerComment(int reservationNumber, int trainerId, Date regdate, String content, String title) {
		super();
		this.reservationNumber = reservationNumber;
		this.trainerId = trainerId;
		this.regdate = regdate;
		this.content = content;
		this.title = title;
	}

	@Override
	public String toString() {
		return "TrainerComment [reservationNumber=" + reservationNumber + ", trainerId=" + trainerId + ", regdate="
				+ regdate + ", content=" + content + ", title=" + title + "]";
	}

	public int getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(int reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
