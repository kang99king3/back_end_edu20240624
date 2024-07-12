package hk.edu20240712.day11;

public class D2_ChildMain {

	public static void main(String[] args) {
		
//		D2_Parent c=new D1_Calendar();//아무 관련없는 객체끼리 참조할 수 없다.
//		byte b=5;//1
//		int a=b;//4
		
		D2_Parent p=new D2_Child();//부모의 타입으로 자식을 생성
				  p.parentMethod();//오버라이딩을 하면 자식에 메서드가 실행된다.
				  
		D2_Child c=new D2_Child();//자식의 타입으로 자식을 생성	
			     c.childMethod();// 모든 기능을 사용할 수 있다.
			     c.parentMethod();
			     
		D2_Child cc=(D2_Child)p;//자식의 기능을 모두 사용하려면 자식타입으로 캐스팅해야 한다.   
		
		//부모인 Object클래스의 toString()---> 자식에서 오버라이딩한 toString()이 호출됨
		System.out.println(cc.toString());
		
		D2_Parent ppp=new D2_Parent();
		ppp.parentMethod();
	}

}








