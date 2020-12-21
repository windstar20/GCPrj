package gc.entity.product.view;

import java.util.Date;

import gc.entity.product.Product;

public class ProductView extends Product{
	
	
	private String brand;
	private String category;
	private String code;
	private String delivery;
	private String fileName;
    
	
	
	public ProductView() {
		
	}
	
	public ProductView(int id, String name, Date regdate, String code, int price, int display, int inventory, String image, String brand, String category, String delivery, String fileName) {
		super(id, name, regdate, code, price, display, inventory, image);
		this.brand = brand;
		this.category = category;
		this.code = code;
		this.delivery = delivery;
		this.fileName = fileName;
	}


	@Override
	public String toString() {
		return "ProductView [brand=" + brand + ", category=" + category + ", code=" + code + ", delivery=" + delivery
				+ ", fileName=" + fileName + "]";
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
