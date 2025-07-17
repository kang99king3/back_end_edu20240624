package hk.edu20240715.day12;

public abstract class D2_Computer {

	//추상메서드: body{ }가 없음 --> 미완성 메서드
	//display방식이 컴퓨터 유형별로 다를 수 있네??
	//나중에 하위 클래스에서 정의하게 해야될것 같음..
	public abstract void display();
	
	//typing방식이 컴퓨터 유형별로 다를 수 있네??
	//나중에 하위 클래스에서 정의하게 해야될것 같음..
	public abstract void typing();
	
	//전원 켜고 끄는 건 어떤 컴퓨터나 공통 기능이니깐 
	//미리 정의해 두자..
	public void turnOn() {
		System.out.println("전원을 켭니다.");
	}
	
	public void turnOff() {
		System.out.println("전원을 끕니다.");
	}
}



