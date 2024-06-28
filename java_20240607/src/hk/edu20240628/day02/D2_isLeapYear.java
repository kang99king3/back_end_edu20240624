package hk.edu20240628.day02;

public class D2_isLeapYear {

	public static void main(String[] args) {
		//윤년: 1년 365일 --> 366일(윤년) 2월달의 마지막날이 28? 29?
		//윤년을 판단하는 조건을 확인
		// - 년도가 4의 배수이면서 100으로 나누어 떨어지지 않는 수 
		// - 또는 400으로 나누어 떨어지는 수
		// 2024년도가 윤년인지 아닌지 확인해서 출력해보기 : "2024년은 윤년이다"
		//									 "2024년은 윤년이다"
		// 코드작성: if(){}else{}
		if((2023%4==0&&2023%100!=0)||2023%400==0) {
			System.out.println("2023년은 윤년이다");
		}else {
			System.out.println("2023년은 평년이다.");
		}
		
		//변수 활용하기 
		int year = 2021;
		if((year%4==0&&year%100!=0)||year%400==0) {
			System.out.println(year+"년은 윤년이다");
		}else {
			System.out.println(year+"년은 평년이다.");
		}
		System.out.println("==========================");
		//2001~2030 사이에 윤년을 모두 출력해보세요
		//반복문을 사용하면 쉽게 구할 수 있을것 같은데...
		for (int i = 2001; i <= 2030; i++) {
			if((i%4==0&&i%100!=0)||i%400==0) {
//			if(isLeapYear(i)) {
				System.out.println(i+"년은 윤년이다");
			}
		}
		
	}

	//윤년을 판단하는 메서드: true/false
	
}








