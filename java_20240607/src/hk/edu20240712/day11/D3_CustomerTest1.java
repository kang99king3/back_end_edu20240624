package hk.edu20240712.day11;

public class D3_CustomerTest1 {

	public static void main(String[] args) {
		/*
		D3_Customer customerLee=new D3_Customer();//부모의 타입으로 부모를 생성함
		customerLee.setCustomerID(10010);
		customerLee.setCustomerName("이순신");
		customerLee.bonusPoint=1000;
		System.out.println(customerLee.showCustomerInfo());
		
		D3_VIPCustomer customerKim=new D3_VIPCustomer();//자식의 타입으로 자식을 생성함
		customerKim.setCustomerID(10020);
		customerKim.setCustomerName("김유신");
//		customerKim.customerName="김유신임";//같은 패키지면 접근가능
		customerKim.bonusPoint=10000;
		System.out.println(customerKim.showCustomerInfo());  */
		
		D3_Customer customerLee=new D3_Customer(10010,"이순신");
		customerLee.bonusPoint=1000;
		System.out.println(customerLee.toString());
		int price=customerLee.calcPrice(10000);
		System.out.println(customerLee.getCustomerName()+"님의 지불할 가격은 "+price);
		
		D3_VIPCustomer customerKim=new D3_VIPCustomer(10020, "김유신",20010);
		customerKim.bonusPoint=10000;
		System.out.println(customerKim);
		int price2=customerKim.calcPrice(10000);
		System.out.println(customerKim.getCustomerName()+"님의 지불할 가격은 "+price2);
	}

}






