package hk.edu20240704.day06;

import java.util.Arrays;

public class D2_FinalTest extends D2_ParentTest{

	public static void main(String[] args) {
		//값변경이 안되는 경우 만들기
		int a=5;
			a=10;//변경가능
			
	    //상수로 선언하기
		final int B=10;
//		B=5;//값을 변경할 수 없음
		
		//메서드에 아규먼트로 전달해서 실행..
		D2_FinalTest ft=new D2_FinalTest();
		ft.test01(30);
		
		//참조타입 배열에서 값을 바꿔보기
		arrayA[0]=10;
		System.out.println(Arrays.toString(arrayA));
//		arrayA=new int[] {4,5};//주소값 변경 금지
	}
	//메서드에 전달된 값은 다르게 전달할 수 있다.
	public int test01(int value) {
		final int aa=value;
		
		return aa;
	}
	
	//맴버필드에 정의 사용
	public static final int A=10;
	
	//참조타입중 배열 선언: 주소값을 저장--> 주소 변경 금지
	public static final int [] arrayA= {1,2,3,4,5};
	
	
	
	//메서드에 final 사용하면 오버라이딩 금지
//	@Override
//	public void test() {
//		System.out.println("자식에서 다시 정의했어요");
//	}
}
