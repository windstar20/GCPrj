package gc.entity.trainer;

import java.util.Date;

public class TrainerEvaluation {
	
	private int reservationNumber;
    private Date regdate;
    private String content;
    private int score;
    
    public TrainerEvaluation() {

    }

	public TrainerEvaluation(int reservationNumber, Date regdate, String content, int score) {
		super();
		this.reservationNumber = reservationNumber;
		this.regdate = regdate;
		this.content = content;
		this.score = score;
	}

	@Override
	public String toString() {
		return "TrainerEvaluation [reservationNumber=" + reservationNumber + ", regdate=" + regdate + ", content="
				+ content + ", score=" + score + "]";
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
    
}
