package hk.edu20240702.day04;

public class D2_MethodTest {

	public static void main(String[] args) {
//		D2_MethodTest mt=new D2_MethodTest();
//		mt.test01();
		D2_MethodTest.test01();//호출방법:클래스명.메서드명()
		
		int result=test05(5, 10);//메서드에 저장된 값은 실행후 삭제된다 그래서 
		                         //변수에 다시 저장해야 사용할 수 있다.
	}
	
	//메서드 유형
	
	//1. static과 non-static
	//static 메서드
	public static void test01() {
		System.out.println("static메서드");
	}
	//non-static메서드
	public void test02() {
		System.out.println("non-static메서드");
	}
	
	//2. 반환타입O/반환타입X
	public int test03() {
		return 0;//반환타입을 선언했다면 반드시 return 값을 정의해야 한다.
	}
	public void test04() {
//		return 0;//반환하면 안됨
	}
	
	//3.파라미터 O/X  :  메서드의 외부로부터 값을 전달받아서 처리할 경우
	public static int test05(int a, int b) {
		int result=a+b;
		System.out.println(result);
		
		return result;
	}
}






