package gc.entity.productOrder;

import java.util.Date;

public class ProductComment {

    private int adminId;
    private int orderNumber;
    private Date regdate;
    private String content;
    
    
    public ProductComment() {
		// TODO Auto-generated constructor stub
	}


	public ProductComment(int adminId, int orderNumber, Date regdate, String content) {
		super();
		this.adminId = adminId;
		this.orderNumber = orderNumber;
		this.regdate = regdate;
		this.content = content;
	}


	public int getAdminId() {
		return adminId;
	}


	public void setAdminId(int adminId) {
		this.adminId = adminId;
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


	@Override
	public String toString() {
		return "ProductComment [adminId=" + adminId + ", orderNumber=" + orderNumber + ", regdate=" + regdate
				+ ", content=" + content + "]";
	}
    
    
}
