package gc.entity.product;

import java.util.Date;

public class Product {

	 	private int id;
	 	private String name;
	 	private String content;
	    private Date regdate;	    
	    private String code;
	    private int price;
	    private int display;
	    private int brandId;
	    private int categoryId;
	    private int adminId;
	    private int inventory;
	    private int deliveryId;
	    private String image;
	    
	    public Product() {
			// TODO Auto-generated constructor stub
		}
	    public Product(int id, String name, Date regdate, String code, int price, int display, int inventory, String image) {
	    	super();
	    	this.id = id;
			this.name = name;
			this.regdate = regdate;
			this.code = code;
			this.price = price;
			this.display = display;
			this.inventory = inventory;
			this.image = image;
	    	
	    }
		public Product(int id, String name, String content, Date regdate, String code, int price, int display,
				int brandId, int categoryId, int adminId, int inventory, int deliveryId, String image) {
			super();
			this.id = id;
			this.name = name;
			this.content = content;
			this.regdate = regdate;
			this.code = code;
			this.price = price;
			this.display = display;
			this.brandId = brandId;
			this.categoryId = categoryId;
			this.adminId = adminId;
			this.inventory = inventory;
			this.deliveryId = deliveryId;
			this.image = image;
		}
		@Override
		public String toString() {
			return "Product [id=" + id + ", name=" + name + ", content=" + content + ", regdate=" + regdate + ", code="
					+ code + ", price=" + price + ", display=" + display + ", brandId=" + brandId + ", categoryId="
					+ categoryId + ", adminId=" + adminId + ", inventory=" + inventory + ", deliveryId=" + deliveryId
					+ ", image=" + image + "]";
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public Date getRegdate() {
			return regdate;
		}
		public void setRegdate(Date regdate) {
			this.regdate = regdate;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public int getDisplay() {
			return display;
		}
		public void setDisplay(int display) {
			this.display = display;
		}
		public int getBrandId() {
			return brandId;
		}
		public void setBrandId(int brandId) {
			this.brandId = brandId;
		}
		public int getCategoryId() {
			return categoryId;
		}
		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}
		public int getAdminId() {
			return adminId;
		}
		public void setAdminId(int adminId) {
			this.adminId = adminId;
		}
		public int getInventory() {
			return inventory;
		}
		public void setInventory(int inventory) {
			this.inventory = inventory;
		}
		public int getDeliveryId() {
			return deliveryId;
		}
		public void setDeliveryId(int deliveryId) {
			this.deliveryId = deliveryId;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
	    

		
	

}