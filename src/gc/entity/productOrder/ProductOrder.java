package gc.entity.productOrder;

import java.util.Date;

public class ProductOrder {

	private int id;
    private int number;
    private int basketId;
    private String senderName;
    private String senderPhone;
    private String senderEmail;
    private String receiverName;
    private String receiverPhone;
    private String receiverAddress;
    private Date regdate;
    private int totalPrice;
    



    


	public ProductOrder() {
		// TODO Auto-generated constructor stub
	}


	public ProductOrder(int id, int number, int basketId, String senderName, String senderPhone, String senderEmail,
			String receiverName, String receiverPhone, String receiverAddress, Date regdate, int totalPrice) {
		super();
		this.id = id;
		this.number = number;
		this.basketId = basketId;
		this.senderName = senderName;
		this.senderPhone = senderPhone;
		this.senderEmail = senderEmail;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.receiverAddress = receiverAddress;
		this.regdate = regdate;
		this.totalPrice = totalPrice;
	}






	




//===================================================

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public int getBasketId() {
		return basketId;
	}


	public void setBasketId(int basketId) {
		this.basketId = basketId;
	}


	public String getSenderName() {
		return senderName;
	}


	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}


	public String getSenderPhone() {
		return senderPhone;
	}


	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}


	public String getSenderEmail() {
		return senderEmail;
	}


	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}


	public String getReceiverName() {
		return receiverName;
	}


	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}


	public String getReceiverPhone() {
		return receiverPhone;
	}


	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}


	public String getReceiverAddress() {
		return receiverAddress;
	}


	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	public int getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	@Override
	public String toString() {
		return "ProductOrder [id=" + id + ", number=" + number + ", basketId=" + basketId + ", senderName=" + senderName
				+ ", senderPhone=" + senderPhone + ", senderEmail=" + senderEmail + ", receiverName=" + receiverName
				+ ", receiverPhone=" + receiverPhone + ", receiverAddress=" + receiverAddress + ", regdate=" + regdate
				+ ", totalPrice=" + totalPrice + "]";
	}


	











}
