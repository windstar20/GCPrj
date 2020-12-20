package gc.entity.point;

import java.util.Date;

public class PointCharging {
	private int id;
	private String memberNicname;
	private Date regdate;
	private int amount;
	private String content;
	
	public PointCharging() {
		// TODO Auto-generated constructor stub
	}

	public PointCharging(int id, String memberNicname, Date regdate, int amount, String content) {
		super();
		this.id = id;
		this.memberNicname = memberNicname;
		this.regdate = regdate;
		this.amount = amount;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getmemberNicname() {
		return memberNicname;
	}

	public void setmemberNicname(String memberNicname) {
		this.memberNicname = memberNicname;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "PointCharging [id=" + id + ", memberNicname=" + memberNicname + ", regdate=" + regdate + ", amount=" + amount
				+ ", content=" + content + "]";
	}

	
	
}
	