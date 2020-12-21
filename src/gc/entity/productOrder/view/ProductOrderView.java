package gc.entity.productOrder.view;

import java.util.Date;

import gc.entity.productOrder.ProductOrder;

public class ProductOrderView extends ProductOrder{
	
	private String productName;
	private int productCount;
	
	public ProductOrderView() {
		// TODO Auto-generated constructor stub
	}

	
	public ProductOrderView(int id, int number, int basketId, String senderName, String senderPhone, String senderEmail,
			String receiverName, String receiverPhone, String receiverAddress, Date regdate, int totalPrice,String productName, int productCount, int state) {
		super(id, number, basketId, senderName, senderPhone, senderEmail, receiverName, receiverPhone, receiverAddress, regdate,
				totalPrice,state);
		this.productName = productName;
		this.productCount = productCount;
	}


	public ProductOrderView(String productName, int productCount) {
		this.productName = productName;
		this.productCount = productCount;
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

	@Override
	public String toString() {
		return "ProductOrderView [productName=" + productName + ", productCount=" + productCount + "]";
	}
	
}
