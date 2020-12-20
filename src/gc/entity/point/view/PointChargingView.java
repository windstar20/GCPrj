package gc.entity.point.view;

import java.util.Date;

import gc.entity.point.PointCharging;

public class PointChargingView extends PointCharging {
	private String name;

	public PointChargingView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PointChargingView(int id, String memberNicname, Date regdate, int amount, String content, String name) {
		super(id, memberNicname, regdate, amount, content);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PointChargingView [name=" + name + "]";
	}
	
	
	
}

