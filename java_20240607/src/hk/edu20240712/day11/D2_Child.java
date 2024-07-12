package hk.edu20240712.day11;

//상속받기: 키워드 extends, 다중상속X
public class D2_Child extends D2_Parent{
	
	//자식이 생성되면 부모가 먼저 생성된다.
	public D2_Child() {
		super();//생략 가능하다.    항상 첫줄에 작성, 부모가 먼저 생성된다.
		System.out.println("자식의 생성자입니다.(default)");
	}
	
	public D2_Child(int a) {
		super(a);//생략 가능하다.    항상 첫줄에 작성, 부모가 먼저 생성된다.
		System.out.println("자식의 생성자입니다.(오버로딩)");
	}
	
	//메서드 오버라이딩: 부모의 메서드를 자식이 재정의한다.
//	@Override
//	public void parentMethod() {
//		System.out.println("자식이 자기 환경에 맞게 기능을 재정의해서 사용한다.:parentMethod()");
//	}
	
	//자식 클래스에서 정의한 메서드
	public void childMethod() {
		System.out.println("자식클래스에만 있는 메서드:childMethod()");
	}
	
	@Override
	public String toString() {
		//Object클래스의 toString메서드를 재정의함
		return "나는 Child객체야~~~";
	}
}







