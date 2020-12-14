package gc.entity.trainer;

import java.util.Date;

public class TrainerReservation {
	
	private int id;
    private Date date;
    private int trainerId;
    private int memberId;
    private Date regdate;
    private int number;
    
    public TrainerReservation() {

    }

	public TrainerReservation(int id, Date date, int trainerId, int memberId, Date regdate, int number) {
		super();
		this.id = id;
		this.date = date;
		this.trainerId = trainerId;
		this.memberId = memberId;
		this.regdate = regdate;
		this.number = number;
	}

	@Override
	public String toString() {
		return "TrainerLicense [id=" + id + ", date=" + date + ", trainerId=" + trainerId + ", memberId=" + memberId
				+ ", regdate=" + regdate + ", number=" + number + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
    
}
