package hk.edu20240704.day06;

public class D4_WrapperTest {

	public static void main(String[] args) {
		//참조타입끼리 형변환
//		Object obj=new D4_WrapperTest();
//		D4_WrapperTest wr=(D4_WrapperTest)obj;
		
		int a=10; //기본타입-->참조타입
//		Integer ii=new Integer(a);
		Integer ii=a;//중간 과정  
		Object obj2=ii;
		int b=(Integer)obj2;//다시 int형으로 사용하려면 캐스팅해서 꺼낸다
	}
}
