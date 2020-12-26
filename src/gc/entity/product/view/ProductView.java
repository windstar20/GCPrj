package gc.entity.product.view;

import java.util.Date;

import gc.entity.product.Product;

public class ProductView extends Product{
	
	
	private String brand;
	private String category;
	private String delivery;
	
	public ProductView() {
		
	}
	
	public ProductView(int id, String name, Date regdate, String code, int price, int display, int inventory, String image, String brand, String category, String delivery) {
		super(id, name, regdate, code, price, display, inventory, image);
		this.brand = brand;
		this.category = category;
		this.delivery = delivery;
	}
	

	

	@Override
	public String toString() {
		return "ProductView [brand=" + brand + ", category=" + category + ", delivery=" + delivery + "]";
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


	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	
}
