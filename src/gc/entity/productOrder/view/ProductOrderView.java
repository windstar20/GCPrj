package gc.entity.productOrder.view;

import java.util.Date;

import gc.entity.productOrder.ProductOrder;

public class ProductOrderView extends ProductOrder{
	
	private String productName;
	private int productCount;
	private String state;
	private String paymentWay;
	
	public ProductOrderView() {
		// TODO Auto-generated constructor stub
	}

	
	public ProductOrderView(int id, int number, int basketId, String senderName, String senderPhone, String senderEmail,
			String receiverName, String receiverPhone, String receiverAddress, Date regdate, int totalPrice,String productName, int productCount, int stateCode,String state, int paymentMethodId, String paymentWay,String deliveryMsg) {
		super(id, number, basketId, senderName, senderPhone, senderEmail, receiverName, receiverPhone, receiverAddress, regdate,
				totalPrice,stateCode,paymentMethodId, deliveryMsg);
		this.productName = productName;
		this.productCount = productCount;
		this.state = state;
		this.paymentWay = paymentWay;
		
	}


	public ProductOrderView(String productName, int productCount,String state, String paymentWay) {
		this.productName = productName;
		this.productCount = productCount;
		this.state = state;
		this.paymentWay = paymentWay;
	}




	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPaymentWay() {
		return paymentWay;
	}


	public void setPaymentWay(String paymentWay) {
		this.paymentWay = paymentWay;
	}


	@Override
	public String toString() {
		return "ProductOrderView [productName=" + productName + ", productCount=" + productCount + ", state=" + state
				+ ", paymentWay=" + paymentWay + "]";
	}




	
}
