package hk.edu20240704.day06;

//다른 패키지에 있는 클래스를 사용하려면 import해야 한다.
import hk.edu20240703.day05.D3_AccessTest;

public class D1_ImmutableTest {

	public int bb=5;
	
	public static void main(String[] args) {
		//다른 패키지에 있는 클래스를 사용하려면 import해야 한다.
		D3_AccessTest at=new D3_AccessTest();
		
		int aa=5;
		change01(aa);// int a=aa;
		System.out.println("원본 aa변수값:"+aa);
		
		D1_ImmutableTest itest2=new D1_ImmutableTest();
		change02(itest2);//D1_ImmutableTest itest=itest2; 주소를 전달
		System.out.println("원본 itest2의 값:"+itest2.bb); 
	}
	
	public static void change01(int a) {
		a=10;//전달 받은 쪽에서 값을 변경했음
	}
	
	public static void change02(D1_ImmutableTest itest) {
		itest.bb=10;//주소.bb=10;
	}
}









