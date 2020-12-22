package gc.entity.productOrder;

import java.util.Date;

public class ProductBasket {
    private int id;
    private int memberId;
    private int totalPrice;
    private Date regdate;

public ProductBasket() {
	// TODO Auto-generated constructor stub
}



public ProductBasket(int id, int memberId, int totalPrice, Date regdate) {
	super();
	this.id = id;
	this.memberId = memberId;
	this.totalPrice = totalPrice;
	this.regdate = regdate;
}



public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getMemberId() {
	return memberId;
}

public void setMemberId(int memberId) {
	this.memberId = memberId;
}



public int getTotalPrice() {
	return totalPrice;
}

public void setTotalPrice(int totalPrice) {
	this.totalPrice = totalPrice;
}

public Date getRegdate() {
	return regdate;
}

public void setRegdate(Date regdate) {
	this.regdate = regdate;
}



@Override
public String toString() {
	return "ProductBasket [id=" + id + ", memberId=" + memberId + ", totalPrice=" + totalPrice + ", regdate=" + regdate
			+ "]";
}



}
