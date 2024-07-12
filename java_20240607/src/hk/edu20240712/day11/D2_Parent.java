package hk.edu20240712.day11;

public class D2_Parent {

	public int a;
	
	public D2_Parent() {
		System.out.println("부모의 생성자입니다.(default)");
	}
	
	public D2_Parent(int a) {
		System.out.println("부모의 생성자입니다.(오버로딩)");
	}
	
	public void parentMethod() {
		System.out.println("부모의 메서드입니다:"+getClass()+":parentMethod()");
	}
}





