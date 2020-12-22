package gc.entity.productOrder;

import java.util.Date;

public class ProductOrderCancel {

	private int orderNumber;
	private Date regdate;
	private String reason;
	
	public ProductOrderCancel() {
		// TODO Auto-generated constructor stub
	}

	public ProductOrderCancel(int orderNumber, Date regdate, String reason) {
		super();
		this.orderNumber = orderNumber;
		this.regdate = regdate;
		this.reason = reason;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "ProductOrderCancel [orderNumber=" + orderNumber + ", regdate=" + regdate + ", reason=" + reason + "]";
	}
	
}
