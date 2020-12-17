package gc.entity.point;

public class Point {

	 private int currentAmount;
	 private String memberId;
	
	 
	 public Point() {
		// TODO Auto-generated constructor stub
	}


	public Point(int currentAmount, String memberId) {
		super();
		this.currentAmount = currentAmount;
		this.memberId = memberId;
	}


	public int getcurrentAmount() {
		return currentAmount;
	}


	public void setcurrentAmount(int currentAmount) {
		this.currentAmount = currentAmount;
	}


	public String getmemberId() {
		return memberId;
	}


	public void setmemberId(String memberId) {
		this.memberId = memberId;
	}


	@Override
	public String toString() {
		return "Point [currentAmount=" + currentAmount + ", memberId=" + memberId + "]";
	}


}
