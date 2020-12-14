package gc.entity.product;

public class Delivery {

	private int id;
	private String charge;
	
	public Delivery() {
		// TODO Auto-generated constructor stub
	}

	public Delivery(int id, String charge) {
		super();
		this.id = id;
		this.charge = charge;
	}

	@Override
	public String toString() {
		return "Delivery [id=" + id + ", charge=" + charge + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}
	
	
}
