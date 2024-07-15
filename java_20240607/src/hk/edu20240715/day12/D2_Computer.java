package hk.edu20240715.day12;

public abstract class D2_Computer {

	//추상메서드: body{ }가 없음 --> 미완성 메서드
	//display방식이 컴퓨터 유형별로 다를 수 있네??
	public abstract void display();
	
	//typing방식이 컴퓨터 유형별로 다를 수 있네??
	public abstract void typing();
	
	public void turnOn() {
		System.out.println("전원을 켭니다.");
	}
	
	public void turnOff() {
		System.out.println("전원을 끕니다.");
	}
}



