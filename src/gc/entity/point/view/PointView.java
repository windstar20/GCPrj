package gc.entity.point.view;

import gc.entity.point.Point;

public class PointView extends Point{
	private String name;
	
	public PointView() {
		// TODO Auto-generated constructor stub
	}

	public PointView(int currentAmount, String memberNicname, String name) {
		super(currentAmount, memberNicname);
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
		return "PointView [name=" + name + "]";
	}
	
	
}
