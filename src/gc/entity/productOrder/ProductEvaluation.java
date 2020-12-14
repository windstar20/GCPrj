package gc.entity.productOrder;

import java.util.Date;

public class ProductEvaluation {

	private int orderNumber;
	private Date regdate;
	private String content;
	private int score;

	public ProductEvaluation() {
		// TODO Auto-generated constructor stub
	}

	public ProductEvaluation(int orderNumber, Date regdate, String content, int score) {
		super();
		this.orderNumber = orderNumber;
		this.regdate = regdate;
		this.content = content;
		this.score = score;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "ProductEvaluation [orderNumber=" + orderNumber + ", regdate=" + regdate + ", content=" + content
				+ ", score=" + score + "]";
	}



}
