package hk.edu20240704.day06;

public class SingletonTest {

	private static SingletonTest singletonTest;
	private SingletonTest() {}//외부에서 new를 이용해서 객체생성하는 작업 막기
	public static SingletonTest getInstance() {
		if(singletonTest==null) {//객체가 생성안됐을 경우만 생성하자
			singletonTest=new SingletonTest();
		}
		return singletonTest;
	}
	
	public void print() {
		System.out.println("싱글톤패턴");
	}
}
