package gc.entity.point;

import java.util.Date;

public class PointUse {
	private int id;
	private Date regdate;
	private int amount;
	private String content;
	private String memberNicname;
	
	
	public PointUse() {
		// TODO Auto-generated constructor stub
	}


	public PointUse(int id, Date regdate, int amount, String content, String memberNicname) {
		super();
		this.id = id;
		this.regdate = regdate;
		this.amount = amount;
		this.content = content;
		this.memberNicname = memberNicname;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public String getMemberNicname() {
		return memberNicname;
	}


	public void setMemberNicname(String memberNicname) {
		this.memberNicname = memberNicname;
	}


	@Override
	public String toString() {
		return "PointUse [id=" + id + ", regdate=" + regdate + ", amount=" + amount + ", content=" + content
				+ ", memberNicname=" + memberNicname + "]";
	}

	
	
	
	
}
