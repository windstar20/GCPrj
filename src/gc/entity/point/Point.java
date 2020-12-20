package gc.entity.point;

public class Point {

	 private int currentAmount;
	 private String memberNicname;
	
	 
	 public Point() {
		// TODO Auto-generated constructor stub
	}


	public Point(int currentAmount, String memberNicname) {
		super();
		this.currentAmount = currentAmount;
		this.memberNicname = memberNicname;
	}


	public int getcurrentAmount() {
		return currentAmount;
	}


	public void setcurrentAmount(int currentAmount) {
		this.currentAmount = currentAmount;
	}


	public String getmemberNicname() {
		return memberNicname;
	}


	public void setmemberNicname(String memberNicname) {
		this.memberNicname = memberNicname;
	}


	@Override
	public String toString() {
		return "Point [currentAmount=" + currentAmount + ", memberNicname=" + memberNicname + "]";
	}


}
