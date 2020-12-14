package gc.entity.productOrder;

public class PaymentMethod {

	private int id;
	private String way;
	
	public PaymentMethod() {
		// TODO Auto-generated constructor stub
	}

	public PaymentMethod(int id, String way) {
		super();
		this.id = id;
		this.way = way;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	@Override
	public String toString() {
		return "Method [id=" + id + ", way=" + way + "]";
	}
	
	
	
}
