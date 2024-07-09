package hk.edu20240709.day08;

public class D2_AntQuiz {

	//"11" --> "12" 로 변환해 주는 메서드
	public String antMake(String s) {
		// "11" ---> 0번째와 다음번째 숫자를 비교해서 같으면 숫자를 올리고, 다르면 1로 초기화
		char c=s.charAt(0);//문자열의 첫번째 숫자를 저장해둘 변수
		int count=1;//연속된 숫자의 개수를 저장할 변수
		String t="";//최종 만들어지는 숫자를 저장할 변수
		
		// "112111"    for문의 i는 문자열의 인덱스로 사용
		for (int i = 1; i < s.length(); i++) {
			if(c==s.charAt(i)) {//문자열 비교하기
				count++;
			}else {
				t=t+c+count;// ""+'1'+2  --> "12"
				count=1;//카운트 초기화
				c=s.charAt(i);//카운트할 새로운 값을 저장
			}
		}
		
		t=t+c+count;//마지막 숫자는 t에 저장하는 처리가 안되서 한번더 실행해줌
		return t;
	}
	
	public void antPrint(int num) {
		String s="1";
		for (int i = 0; i < num; i++) {
			s=antMake(s);//다음값을 구해서 다시 s에 저장
			System.out.println(s);
		}
	}
}





