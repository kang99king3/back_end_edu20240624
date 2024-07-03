package hk.edu20240702.day04;

public class D3_Divisor {

	public static void main(String[] args) {
      	divisor(30);//약수구하기
      	System.out.println();
      	greateDivisor(10, 40);//최대공약수 구하기
      	lowestMultiple(10, 40);//최소공배수 구하기
      	amicable(1, 5000);//친화수 구하기
      	perfectNum(1, 10000);//완전수 구하기
	}
	
	//약수를 구하는 메서드
	public static void divisor(int num) {
		for (int i = 1; i <= num; i++) {
			if(num%i==0) {
				System.out.print((i==num)?i:i+",");//삼항연산자
			}
		}
	}
	
	//최대공약수를 구하는 메서드
	public static int greateDivisor(int a, int b) {
		//원본값 저장
		int tempA=a;// 기본타입에 경우 값을 전달한다. 
		int tempB=b;
		
		while(true) {
			
			//a가 b보다 클 경우
			if(a>b) {
				a=a-b;
			}
			//b가 a보다 클 경우
			if(b>a) {
				b=b-a;
			}
			//a와 b가 같을 경우 --> while문을 종료하는 코드
			if(a==b) {
				break;
			}
		}
		System.out.println(tempA+"와"+tempB+"의 최대공약수는 "+a+"입니다.");
		
		return a;
	}
	
	//최소공배수구하기: a*b/(a,b의 최대공약수)
	public static void lowestMultiple(int a, int b) {
		//최대공약수 구하기
		int val=greateDivisor(a, b);//메서드 실행후 반환된 값을 받는다.(재사용성)
		int result=a*b/val;
		System.out.printf("%d와 %d의 최소공배수는 %d이다\n",a,b,result);
	}
	
	//친화수구하기
	// 220 == (220의 진약수의 합)에 진약수 구한 수 
	public static void amicable(int s, int e) {
		for (int i = s; i < e; i++) {
			if(i!=sumDivisor(i)&&i==sumDivisor(sumDivisor(i))) {// 괄호안에 메서드가 먼저 실행된다.
				System.out.println(i+":"+sumDivisor(i)+"는 친화수 관계입니다.");
			}
		}
	}
	//진약수의 합 구하는 메서드: 결과값 합을 반환해야 함
	public static int sumDivisor(int a) {
		int sum=0;//합계를 저장할 변수
		for (int i = 1; i < a; i++) {
			if(a%i==0) { // 약수야??
				sum+=i;
			}
		}
		return sum;
	}
	
	//완전수를 구하는 메서드: 진약수의 합과 자신의 수가 같은 경우
	public static void perfectNum(int s, int e) {
		for (int i = s; i < e; i++) {
			if(i==sumDivisor(i)) {
				System.out.println(i+"는 완전수이다.");
			}
		}
	}
}



















