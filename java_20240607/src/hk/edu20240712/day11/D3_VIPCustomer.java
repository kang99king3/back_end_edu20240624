package hk.edu20240712.day11;

public class D3_VIPCustomer extends D3_Customer{
	
//	private int customerID;
//	private String customerName;
//	private String customerGrade;
//	int bonusPoint;
//	double bonusRatio;
	
	private int agentID;//담당 상담원 id
	double saleRatio; //할인율
	
	
	public D3_VIPCustomer() {
		super();//생략가능하다.  부모의 생성자도 실행이 된다.
		customerGrade="VIP";
		bonusRatio=0.05;
		saleRatio=0.1;
		System.out.println("VIPCustomer생성자호출");
	}
	
	public D3_VIPCustomer(int customerID, String customerName, int agentID) {
		
		//부모생성자를 통해 맴버필드 초기화
		super(customerID,customerName);
		//부모의 맴버필드에 접근해서 초기화
		super.customerID=customerID;
		super.customerName=customerName;
		super.customerGrade="VIP";
		super.bonusRatio=0.05;
		
		this.saleRatio=0.1;
		this.agentID=agentID;
	}
	
	@Override
	public int calcPrice(int price) {
		bonusPoint+=price*bonusRatio;
		return price-(int)(price*saleRatio);
	}
	
	//은닉화 : 메서드를 통해 접근할 수 있게 하자
	public int getAgentID() {
		return agentID;
	}
	
	//Object의 toString()을 오버라이딩해서 재정의함
	@Override
	public String toString() {
		return  super.toString()+":"+
				"D3_VIPCustomer [agentID=" + agentID + ", saleRatio=" + saleRatio + "]";
	}

	public String showCustomerInfo() {
		return customerName+" 님의 등급은 "+ customerGrade +"이며, 보너스 포인트는"
				           +bonusPoint +"입니다.";
	}
}







