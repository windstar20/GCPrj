package gc.entity.productOrder;

public class OrderState {
	int code;
	String state;
	
	public OrderState() {
		// TODO Auto-generated constructor stub
	}

	public OrderState(int code, String state) {
		super();
		this.code = code;
		this.state = state;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "OrderState [code=" + code + ", state=" + state + "]";
	}
	
}
