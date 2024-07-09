package hk.edu20240709.day08;

public class D1_Calculator {
	//연산을 하기 위한 숫자 2개를 저장할 맴버필드
		public int num1; 
		public int num2;
		
		// scanner 이용해서 키보드로 값을 입력받기:
		//                      "5+10" , "5*20" 하나의 문자열로 입력받기 
		
		// [맴버필드 초기화]문자열에서 정수를 추출하여, 맴버필드 num1,num2에 저장하는 기능 구현
		// "5+10" --> 5, 10 추출   5+10 을 실행해야 15가 구해짐
		// String을 int형으로 변환
		//           String s는"5+10" ,  String cal은 "+","/","-","*" 사칙연산자
		public void paramInt(String s,String cal) {
//			num1=앞에 문자열에 추출하여 int형으로 변환 코드작성; //indexOf, substring 활용
//			num2=뒤에 문자열에 추출하여 int형으로 변환 코드작성;  
		}
		
		//+,-,*,/를 실행하는 메서드 4개를 수정없이 그냥 사용해야 함 
		public int a(int a,int b) {
			System.out.println("덧셈을 실행합니다.");
			return a+b;
		}
		public int b(int a,int b) {
			System.out.println("뺄셈을 실행합니다.");
			return a-b;
		}
		public int c(int a,int b) {
			System.out.println("곱셈을 실행합니다.");
			return a*b;
		}
		public int d(int a,int b) {
			System.out.println("나눗셈을 실행합니다.");
			return a/b;
		}
		// 입력받은 값에 해당하는 위에 주어진 사칙연산 메서드를 실행하는 메서드
		// 키워드: indexOf() 검색대상이 없으면 -1을 리턴 --> 검색대상이 있다면? 조건식은?
		public void calcu(String s) { //s= "5+10"
	/*		
			if(조건식) { //s라는 문자열에서 "+"문자열이 존재하는지 확인하는 조건
			
				// 맴버필드  num1,num2를 초기화해주는 코드(paramInt(s,cal)사용)
				// 연산결과 출력 코드 작성
				 
			}else if(조건식) {//s라는 문자열에서 "-"문자열이 존재하는지 확인하는 조건
			
				// 맴버필드  num1,num2를 초기화해주는 코드(paramInt()사용)
				// 연산결과 출력 코드 작성
				 
			}else if(조건식) {// *연산확인
			
				// 맴버필드  num1,num2를 초기화해주는 코드(paramInt()사용)
				// 연산결과 출력 코드 작성
				 
			}else if(조건식) {// /연산확인
			
				// 맴버필드  num1,num2를 초기화해주는 코드(paramInt()사용)
				// 연산결과 출력 코드 작성
				 
			}else {
				System.out.println("연산식을 확인하세요");
			}
	 
	 */
		}
}
