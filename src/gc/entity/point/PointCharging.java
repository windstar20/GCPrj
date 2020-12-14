package gc.entity.point;

import java.util.Date;

public class PointCharging {
	private Date DATE;
	private int amount;
	private String content;
	private int member_id;
	
	public PointCharging() {
		// TODO Auto-generated constructor stub
	}

	public PointCharging(Date dATE, int amount, String content, int member_id) {
		super();
		DATE = dATE;
		this.amount = amount;
		this.content = content;
		this.member_id = member_id;
	}

	@Override
	public String toString() {
		return "PointCharging [DATE=" + DATE + ", amount=" + amount + ", content=" + content + ", member_id="
				+ member_id + "]";
	}

	public Date getDATE() {
		return DATE;
	}

	public void setDATE(Date dATE) {
		DATE = dATE;
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

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	
	
}
