package hk.edu20240703.day05;

public class D3_AccessMain {

	public static void main(String[] args) {
		D3_AccessTest access=new D3_AccessTest();
		int a=access.a;//public선언: 접근가능
		int b=access.b;//default선언: 접근가능
//		int c=access.c;//private선언: 접근불가능
		int c=access.getC(3);//메서드를 통해 접근 가능(은닉화)
	}

}
