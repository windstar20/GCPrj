package gc.entity.point.view;

import java.util.Date;

import gc.entity.point.PointUse;

public class PointUseView extends PointUse{
	private String name;

	public PointUseView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PointUseView(int id, Date regdate, int amount, String content, String memberNicname, String name) {
		super(id, regdate, amount, content, memberNicname);
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
		return "PointUseView [name=" + name + "]";
	}
	
	
}
