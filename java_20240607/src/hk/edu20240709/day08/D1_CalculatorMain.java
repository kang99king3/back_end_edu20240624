package hk.edu20240709.day08;

import java.util.Scanner;
import java.util.regex.Pattern;

public class D1_CalculatorMain {

	public static void main(String[] args) {
//		System.out.println("계산 값을 입력하세요(+,-*,/ 연산만 가능)입력은 \"5+10\"");
//		Calculator 객체생성
		D1_Calculator cal=new D1_Calculator();
//		Scanner 객체생성
		Scanner scan=new Scanner(System.in);
		
		while(true) {
			System.out.println("계산 값을 입력하세요(+,-*,/ 연산만 가능)입력은 \"5+10\"");
			//예: "5+10"입력값 받는 코드 작성
			String s=scan.next();// 5+10 
			//입력받은 값 s의 패턴: "숫자[+-/*]숫자" 확인 ---> 정규화표현식 
			if(Pattern.matches("^[0-9][0-9]*[+|\\-|/|*][0-9]*[0-9]$", s)) {	
//				"5+10"에 대한 연산 처리 코드실행
				cal.calcu(s);//계산실행
			}else {
				//"9"를 입력하면 "계산 프로그램을 종료해요~~" 출력하고 끝내기 코드 작성
				if(s.equals("9")) {
					System.out.println("계산 프로그램을 종료해요~~~");
					break;
				}else {
					System.out.println("형식이 잘못됐습니다. 다시 입력하세요");
				}
				
			}
			
			//계산실행하기 메서드 호출: 객체명.메서드명	
			//cal.메서드명(s);
		}

	}

}
