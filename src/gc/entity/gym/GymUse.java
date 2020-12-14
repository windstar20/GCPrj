package gc.entity.gym;

import java.util.Date;

public class GymUse {
	private int reservationNumber;
	private Date date;
	
	public GymUse() {
		
	}

	public GymUse(int reservationNumber, Date date) {
		super();
		this.reservationNumber = reservationNumber;
		this.date = date;
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

	@Override
	public String toString() {
		return "GymUse [reservationNumber=" + reservationNumber + ", date=" + date + "]";
	}
	
	
}
