package hk.edu20240712.day11;

public class D3_Customer {

	protected int customerID; //고객아이디
	protected String customerName;//고객이름
	protected String customerGrade;//고객등급
	int bonusPoint;//보너스포인트
	double bonusRatio;//보너스적립률
	
	public D3_Customer() {//default생성자는 나중에 ID와Name을 따로 추가해야 함
		customerGrade="SILVER";
		bonusRatio=0.01;
		System.out.println("Customer생성자호출");
	}
	
	//ID와 Name을 생성시 바로 추가함
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







