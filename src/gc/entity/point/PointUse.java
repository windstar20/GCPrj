package gc.entity.point;

import java.util.Date;

public class PointUse {
	private int id;
	private Date regdate;
	private int amount;
	private String content;
	private String memberId;
	
	
	public PointUse() {
		// TODO Auto-generated constructor stub
	}


	public PointUse(int id, Date regdate, int amount, String content, String memberId) {
		super();
		this.id = id;
		this.regdate = regdate;
		this.amount = amount;
		this.content = content;
		this.memberId = memberId;
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


	public String getmemberId() {
		return memberId;
	}


	public void setmemberId(String memberId) {
		this.memberId = memberId;
	}


	@Override
	public String toString() {
		return "PointUse [id=" + id + ", regdate=" + regdate + ", amount=" + amount + ", content=" + content
				+ ", memberId=" + memberId + "]";
	}

	
	
	
	
}
