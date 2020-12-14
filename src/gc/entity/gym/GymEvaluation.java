package gc.entity.gym;

import java.util.Date;

public class GymEvaluation {
	
	private int reservationNumber;
	private Date regdate;	
	private int score;	
	private String content;	
	
	public GymEvaluation() {
		
	}

	public GymEvaluation(int reservationNumber, Date regdate, int score, String content) {
		super();
		this.reservationNumber = reservationNumber;
		this.regdate = regdate;
		this.score = score;
		this.content = content;
	}

	public int getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(int reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "GymEvaluation [reservationNumber=" + reservationNumber + ", regdate=" + regdate + ", score=" + score
				+ ", content=" + content + "]";
	}
	
	
}
