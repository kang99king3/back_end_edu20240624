package hk.edu20240701.day03;

import java.util.Scanner;

public class D3_BankTest {

	public static void main(String[] args) {
		//클래스를 객체 생성해서 변수에 저장할때 선언되는 타입 --> 참조타입
//		Scanner scan=new Scanner(System.in);// System.in -> 키보드로 입력되는 정보
//		System.out.println("키보드로 입력하세요");
//		String s=scan.nextLine();//콘솔에서 입력되는 내용을 받기위해 대기중--> 입력하면 읽어들인다
//		System.out.println("입력된 내용:"+s);
		
		//예제
		// while문과 Scanner객체를 이용해서 키보드로부터 입력된 데이터로 예금,출금,조회,종료 기능 구현
		// 예금한 금액을 저장할 변수 선언
		// 키보드로 입력받은 값을 저장할 변수 선언
		
		Scanner scan=new Scanner(System.in);
		
		int balance=0;//계좌
		
		while(true) {
			System.out.println("------------------------");
			System.out.println("1.예금|2.출금|3.잔고|4.종료");
			System.out.println("------------------------");
			System.out.println("선택>");
			
			int num=0;
			
			if(scan.hasNextInt()) {//입력된 값이 숫자인지 확인한다.
				num=scan.nextInt();//숫자면 읽는다.
			}else {
				System.out.println("숫자를 입력해야 합니다.");
				scan=new Scanner(System.in);
				continue;
			}
			
			if(num==1) {//입금(예금)
				System.out.println("예금액을 입력하세요>");
				int a=scan.nextInt();//입금액을 입력받는다.
//				balance=balance+a;
				balance+=a;
				System.out.println("입금완료했습니다.");
			}else if(num==2){//출금
				System.out.println("출금액을 입력하세요>");
				int a=scan.nextInt();
				if(balance>a) {
					//balance=balance-a;
					balance-=a;//출금하는 코드  	
					System.out.println("출금하였습니다.");
				}else {
					System.out.println("잔액이 부족합니다.");
					continue;
				}
			}else if(num==3){//잔액조회
				System.out.println("잔고:"+balance+"원 입니다.");
			}else if(num==4) {//종료
				System.out.println("종료합니다.");
				break;
			}else {
				//1~4번을 제외한 다른 번호를 입력하면 다시 입력하도록 알려주기
				System.out.println("1~4까지의 숫자만 입력하세요");
			}
			
		}
		
	}

}





