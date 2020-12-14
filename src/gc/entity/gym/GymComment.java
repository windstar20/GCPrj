package gc.entity.gym;

import java.util.Date;

public class GymComment {
	
	private int reservationNumber;
	private Date regdate;	
	private int gymId;	
	private String content;	
	
	public GymComment() {
		
	}

	public GymComment(int reservationNumber, Date regdate, int gymId, String content) {
		super();
		this.reservationNumber = reservationNumber;
		this.regdate = regdate;
		this.gymId = gymId;
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

	public int getGymId() {
		return gymId;
	}

	public void setGymId(int gymId) {
		this.gymId = gymId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "GymComment [reservationNumber=" + reservationNumber + ", regdate=" + regdate + ", gymId=" + gymId
				+ ", content=" + content + "]";
	}
	
	
}
