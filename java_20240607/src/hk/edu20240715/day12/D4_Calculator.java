package hk.edu20240715.day12;

//추상클래스
public abstract class D4_Calculator implements D4_Calc{

	@Override
	public int add(int num1, int num2) {
		return num1+num2;
	}

	@Override
	public int substract(int num1, int num2) {
		return num1-num2;
	}
	//나머지 2개의 메서드는 현재 클래스에서 기능을 구현하기 힘든 상황이라고 한다면...
	//어느 클래스에서는 반드시 구현을 해야 사용을 할 수 있다. 상속강요를 하자
	public abstract int times(int num1, int num2);
	public abstract int divide(int num1, int num2);

}
