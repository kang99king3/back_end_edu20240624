package hk.edu20240715.day12;

public class D1_Human extends D1_Animal{

	//Animal 클래스의 move()메서드를 상속받음--> 그냥 쓸 수 있다
	@Override
	public void move() {
		System.out.println("사람이 두발로 걷습니다.");
	}
	
	public void test() {
		System.out.println("자식에서 새로 추가된 메서드");
	}
}
