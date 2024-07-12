package hk.edu20240712.day11;

public class D3_Customer {

	protected int customerID;
	protected String customerName;
	protected String customerGrade;
	int bonusPoint;
	double bonusRatio;
	
	public D3_Customer() {
		customerGrade="SILVER";
		bonusRatio=0.01;
		System.out.println("Customer생성자호출");
	}
	
	public D3_Customer(int customerID, String customerName) {
		this.customerID=customerID;
		this.customerName=customerName;
		customerGrade="SILVER";
		bonusRatio=0.01;
	}

	public int calcPrice(int price) {
		bonusPoint+=price*bonusRatio;
		return price;
	}
	
	public String showCustomerInfo() {
		return customerName+" 님의 등급은 "+ customerGrade +"이며, 보너스 포인트는"
				           +bonusPoint +"입니다.";
	}

	// 다른 패키지에서 메서드를 통해 접근할 수 있도록 함
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGrade() {
		return customerGrade;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}

	@Override
	public String toString() {
		return "D3_Customer [customerID=" + customerID + ", customerName=" + customerName + ", customerGrade="
				+ customerGrade + ", bonusPoint=" + bonusPoint + ", bonusRatio=" + bonusRatio + "]";
	}
	
	
}







