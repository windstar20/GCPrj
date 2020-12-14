package gc.entity.point;

public class Point {

	 private int current_amount;
	 private int member_id;
	
	 
	 public Point() {
		// TODO Auto-generated constructor stub
	}


	public Point(int current_amount, int member_id) {
		super();
		this.current_amount = current_amount;
		this.member_id = member_id;
	}


	@Override
	public String toString() {
		return "Point [current_amount=" + current_amount + ", member_id=" + member_id + "]";
	}


	public int getCurrent_amount() {
		return current_amount;
	}


	public void setCurrent_amount(int current_amount) {
		this.current_amount = current_amount;
	}


	public int getMember_id() {
		return member_id;
	}


	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	 
	 
}
