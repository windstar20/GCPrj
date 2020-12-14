package gc.entity.trainer;

import java.util.Date;

public class TrainerUse {
	
	private int reservationNumber;
    private Date date;
    
    public TrainerUse() {

    }

	public TrainerUse(int reservationNumber, Date date) {
		super();
		this.reservationNumber = reservationNumber;
		this.date = date;
	}

	@Override
	public String toString() {
		return "TrainerUse [reservationNumber=" + reservationNumber + ", date=" + date + "]";
	}

	public int getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(int reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
    
}
