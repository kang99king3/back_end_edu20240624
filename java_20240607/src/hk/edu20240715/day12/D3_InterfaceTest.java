package hk.edu20240715.day12;

public interface D3_InterfaceTest{

	//다중상속 흉내 ~ extends.. implements...
	//public interface D3_InterfaceTest extends Test implements ITest{
	
	//인터페이스끼리 다중 구현이 가능함 implements IA,IB,IC
	
	//인터페이스끼리 상속 가능 public interface IA extends IB
	
	//상수 선언
	public static final int A=5;
	public int B=10;
	
	//추상메서드 
	public abstract int test();
	public int test2();
	
	//default 메서드
	public default void test3() {
		test5();//private메서드에 접근할 수 있다
		System.out.println("인터페이스를 구현한 객체가 사용한다.");
	}
//	void test4();
	
	//private 메서드: 구현한 객체에서 사용할 수 없다. 인터페이스 내부에서만 공통기능으로 사용
	private void test5() {
		System.out.println("인터페이스 내부에서만 사용가능하다.");
	}
	
	//static 메서드 : D3_InterfaceTest.test6()로 호출해서 사용가능
	public static void test6() {
		System.out.println("인터페이스만으로 실행 가능하다.");
	}
}



















