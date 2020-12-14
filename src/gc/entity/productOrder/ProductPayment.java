package gc.entity.productOrder;

import java.util.Date;

public class ProductPayment {
	private int orderNumber;
	private int method;
	private Date cancelDate;
	private Date refundDate;
	private int refundPrice;
	
	public ProductPayment() {
		// TODO Auto-generated constructor stub
	}

	public ProductPayment(int orderNumber, int method, Date cancelDate, Date refundDate, int refundPrice) {
		super();
		this.orderNumber = orderNumber;
		this.method = method;
		this.cancelDate = cancelDate;
		this.refundDate = refundDate;
		this.refundPrice = refundPrice;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getMethod() {
		return method;
	}

	public void setMethod(int method) {
		this.method = method;
	}

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	public Date getRefundDate() {
		return refundDate;
	}

	public void setRefundDate(Date refundDate) {
		this.refundDate = refundDate;
	}

	public int getRefundPrice() {
		return refundPrice;
	}

	public void setRefundPrice(int refundPrice) {
		this.refundPrice = refundPrice;
	}

	@Override
	public String toString() {
		return "ProductPayment [orderNumber=" + orderNumber + ", method=" + method + ", cancelDate=" + cancelDate
				+ ", refundDate=" + refundDate + ", refundPrice=" + refundPrice + "]";
	}
	
}
