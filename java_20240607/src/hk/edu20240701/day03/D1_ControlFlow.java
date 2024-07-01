package hk.edu20240701.day03;

import java.util.Iterator;

public class D1_ControlFlow {

	public static void main(String[] args) {
		//if문
		//유형: 3가지
		//1.if(조건식){실행코드}
		//2.if(조건식){실행코드}else{실행코드}
		//3.if(조건식){실행코드}else if(조건식){실행코드}else if(조건)...
		
		int num1=10;
		int num2=5;
		
		//if문을 독립적으로 사용: if문끼리 영향이 없음
		if(num1>num2) {
			System.out.println("실행결과:"+num1+">"+num2);
		}
		
		if(num1<num2) {
			System.out.println("실행결과:"+num1+"<"+num2);
		}
		
		//참과 거짓에 의한 실행이 반드시 일어나야 하는 경우
		if(num1>num2) {
			System.out.println("실행결과:"+num1+">"+num2);
		}else {
			System.out.println("실행결과:"+num1+"<"+num2);
		}
		
		//여러 조건을 설정한다면..
		if(num1>num2) {
			if(num1!=num2) {//조건문을 중첩해서 사용...
				
			}
		}else if(num1<num2) {
			
		}else if(num1==num2) {
			
		}else {
			
		}
		
		//switch case문: 대상값이 정수형, String
		int num=10;
		switch (num) {
			case 1: System.out.println("1입니다.");break;
			case 2: System.out.println("2입니다.");break;
			case 5: System.out.println("5입니다.");break;
			case 10: System.out.println("10입니다.");break;
			case 20: System.out.println("20입니다.");break;
			default: System.out.println("일치하는 값이 없습니다.");
				break;
		}
		
		//제어문(반복문)
		//for문 : 기본형식(index기반의 실행), 향상된 for문
		// 1.초기값 선언  2. 조건확인 3.코드실행 4. 스텝증가 --> 2.조건확인....
		for (int i = 0; i < 10; i++) {
			//실행코드
			if(i==3) {
//				break;//가장 가까운 반복문을 빠져나온다.
				continue;//가장 가까운 반복문으로 돌아간다.
			}
			System.out.println(i);
		}
		
		//향상된 for문
		//배열: 어떤 값의 나열 --> 자바에서는 같은 타입의 나열
		int[] i= {1,2,3,4,5}; 
		//   (초기값:사용될 객체)
		for (int j : i) {
			System.out.println(j);//자동으로 index에 해당하는 값을 가져온다.
		}
		for (int j = 0; j < i.length; j++) {
			System.out.println(i[j]);//index를 통해 값을 가져온다.
		}
		
		//while문: 반드시 반복문을 빠져나가는 코드 처리가 필요
		int w=0;
		while(true) {
			System.out.println("while문 실행");
			if(w>5) {
				break;
			}
			w++;
		}
		
		//do ~ while문 : 최초 한번은 코드 실행
		do {
			System.out.println("조건에 맞지 않아도 한번은 실행한다.");
		}while(10<5);
	}
}













