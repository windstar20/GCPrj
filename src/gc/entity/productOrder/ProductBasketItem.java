package gc.entity.productOrder;

public class ProductBasketItem {
	private int basketId;
	private String productCode;
	private int count;
	private int sumPrice;
	
	public ProductBasketItem() {
		// TODO Auto-generated constructor stub
	}

	public ProductBasketItem(int basketId, String productCode, int count, int sumPrice) {
		super();
		this.basketId = basketId;
		this.productCode = productCode;
		this.count = count;
		this.sumPrice = sumPrice;
	}

	public int getBasketId() {
		return basketId;
	}

	public void setBasketId(int basketId) {
		this.basketId = basketId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(int sumPrice) {
		this.sumPrice = sumPrice;
	}

	@Override
	public String toString() {
		return "ProductBasketItem [basketId=" + basketId + ", productCode=" + productCode + ", count=" + count
				+ ", sumPrice=" + sumPrice + "]";
	}
	
	
}
