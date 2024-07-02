package hk.edu20240702.day04;

public class D3_Divisor {

	public static void main(String[] args) {
      	divisor(30);
	}
	
	//약수를 구하는 메서드
	public static void divisor(int num) {
		for (int i = 1; i <= num; i++) {
			if(num%i==0) {
				System.out.print((i==num)?i:i+",");//삼항연산자
			}
		}
	}
	
}
