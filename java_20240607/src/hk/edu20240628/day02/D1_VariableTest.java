package hk.edu20240628.day02;

public class D1_VariableTest {

	public static void main(String[] args) {
		//기본타입의 특징
		//1.정수타입
		// 기본형이 int
		byte b=1;// -128~127 숫자를 표현
//		     b=128;//128은 표현범위를 벗어남
		short sh=128;//2byte니깐 저장할 수 있음
		int i = 500000000;//4byte
		long l= 50000000000L;//기본형이 int이기 때문에 리터럴값이 범위를 벗어나면 오류
		
		//2. 실수형
		//기본형이 double
		double d = 15.8;
//		float f = 12.7f;
		float f = (float)12.7;
		float ff= (float)(d + f); //다른 타입의 두 변수를 연산하면 큰쪽의 타입으로 반환
	}
}






