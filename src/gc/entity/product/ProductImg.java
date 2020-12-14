package gc.entity.product;

public class ProductImg {
	
	 private String productCode;
	 private String fileName;
	 
	 public ProductImg() {
		// TODO Auto-generated constructor stub
	}

	public ProductImg(String productCode, String fileName) {
		super();
		this.productCode = productCode;
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "ProductImg [productCode=" + productCode + ", fileName=" + fileName + "]";
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	 

	 
	 
}
