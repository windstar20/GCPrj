package gc.entity.product;

public class ProductTaste {
	private String productCode;
	private String name;
	
	public ProductTaste() {
		// TODO Auto-generated constructor stub
	}

	public ProductTaste(String productCode, String name) {
		super();
		this.productCode = productCode;
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProductTaste [productCode=" + productCode + ", name=" + name + "]";
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
