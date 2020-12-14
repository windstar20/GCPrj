package gc.entity.productOrder;

import java.util.Date;

public class ProductReturn {

    private int orderNumber;
    private Date date;
    private String content;
    
    
    public ProductReturn() {
		// TODO Auto-generated constructor stub
	}


	public ProductReturn(int orderNumber, Date date, String content) {
		super();
		this.orderNumber = orderNumber;
		this.date = date;
		this.content = content;
	}


	public int getOrderNumber() {
		return orderNumber;
	}


	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "ProductReturn [orderNumber=" + orderNumber + ", date=" + date + ", content=" + content + "]";
	}
    
}
