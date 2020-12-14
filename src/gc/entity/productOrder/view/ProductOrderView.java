package gc.entity.productOrder.view;

import gc.entity.productOrder.ProductOrder;

public class ProductOrderView extends ProductOrder{
	
	private String productName;
	private int productCount;
	
	public ProductOrderView() {
		// TODO Auto-generated constructor stub
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
