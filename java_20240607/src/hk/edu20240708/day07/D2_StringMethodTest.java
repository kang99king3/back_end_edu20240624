package hk.edu20240708.day07;

public class D2_StringMethodTest {

	//String 주요 메서드 연습
	
	//1.문자 하나를 반환
	//문자열에서 문자를 추출--> "문자열"-> '문'(char타입변환)
	//지원기능: charAt(index) 
	public String sTest01(String s,int ii) {
		char c=s.charAt(ii);
		String ss=c+"";// 문자열을 만나면 문자열로 형변환
		String ss2=String.valueOf(c);//문자열로 형변환
		
		//예시)문자열을 int형으로 변환
		int i=Integer.parseInt("100");// "100"--> 100
		
		return ss2;
	}
	
	//2. 문자열의 인덱스를 반환하는 indexOf()
	// "ABCD" 문자열에서 
	// "ABCD".indexOf("B") ---> 반환값은 1 (인덱스값)
	// "ABCD".indexOf("E") ---> 반환값은 -1 존재하지 않음..
	// "ABCD".indexOf("BC")---> 반환값은 1 (해당 문자열의 첫번째 인덱스)
	// 종류: indexOf():앞에서 부터 검색, lastIndexOf():문자열의 끝에서부터 검색
	public String sTest2(String s) { //s = "선재 업고 튀어"
		int num1=s.indexOf("선");
		int num2=s.indexOf("업고");
		int num3=s.lastIndexOf("튀어");//성능을 고려했을때   예). </body>
		
		//존재한다면.. 조건을 많이 씀
		if(s.indexOf("업고")!=-1) {
			System.out.println("업고라는 단어가 존재합니다.!!");
		}
		
		return num1+","+num2+","+num3;
	}
	
	//3.문자열 길이 반환: length()
	public int sTest03(String s) {
		return s.length();
	}
	//4.문자열의 내용 변환: replace("원본","새로운 내용")
	public void sTest04() {
		String s="자바프로그래밍자바자바자바자바자바";
			   s.replace("자바", "C#");//immutable하기 때문에 값변경안됨
			   s=s.replace("자바", "C#");//결과를 새로 대입해야 적용된다.
			   
	    System.out.println(s);
	}
	//5.문자열을 추출하기: substring()
	//substring(int index): 해당 index부터 끝까지 추출
	//substring(int s,int e): 시작index에서 마지막 인덱스-1번째까지 추출
	public String sTest5(String s) {
		String ss=s.substring(2);//2번째부터
		String sss=s.substring(0, 3);//0번째부터 2번째까지
		return ss+":"+sss;
	}
	
	//예제:
	//문자열에서 해당 검색어가 존재하는지 판단하여 존재한다면 해당 검색어를 추출하여
	//출력하고, "###"으로 변경하여 처리하고, 계속 검색어가 존재하는지 확인하여
	//앞에 작업을 진행한다.
	// 
	//1.해당 검색어가 존재하는 여부 판단해보기,해당검색어가 없으면 "검색어가 존재하지 않습니다."출력
	//2.해당 검색어의 인덱스를 구해보기: 검색어 인덱스 출력하기
	//3.해당 검색어를 추출해서 출력해보기: substring()을 사용해서 추출한뒤  출력하기
	//4.해당 검색어를 문자열에서 ###으로 바꿔주기
	//5.해당 검색어의 검색된 개수 출력하기[indexOf("검색어",검색시작인덱스)]
	
	//String str은 검색어 : 네트워크
	public void search(String str) {
		String s= "SK텔레콤이 싱가포르 1위 통신사 싱텔(Singtel)과 차세대 통신 네트워크 기술 협력을 위한 양해각서(MOU)를 체결했다고 8일 밝혔다.\r\n"
				+ "\r\n"
				+ "두 통신사는 글로벌 주요 통신사들의 인공지능(AI) 연합인 '글로벌 텔코 AI 얼라이언스'의 창립 회원사로서 협력을 약속했다.\r\n"
				+ "\r\n"
				+ "양사는 4G·5G 기술 노하우를 바탕으로 고객 경험 향상과 네트워크 안정성·효율성을 동시에 개선할 계획이다. 이를 위해 이동통신 네트워크 엔지니어링·구축·운용·설루션 등 다양한 상용망 분야에서 기술 논의와 인력 교류를 추진한다.\r\n"
				+ "\r\n"
				+ "아울러 에지 AI 인프라 적용과 코어망 운용 기술 연구, 네트워크 슬라이싱(맞춤형 서비스를 위해 코어네트워크를 독립된 여러 가상 네트워크로 분리하는 기술) 등 5G 유무선 이동통신망 진화 기술 전략, 6G 적용 사례 개발 등 분야에서 협력할 예정이다.";
	
		if(s.indexOf(str)!=-1) {
			int count=0;//검색된 개수
			int idx=0;//검색 시작 인덱스           // 01  4      1+3=4
			while(s.indexOf(str,idx)!=-1) {    // "abcde" -> "bcd"
				String ss=s.substring(s.indexOf(str,idx),s.indexOf(str,idx)+str.length());
				System.out.println("검색어"+(++count)+":"+ss);//검색어 추출
				System.out.println("검색어 인덱스:"+s.indexOf(str,idx));//검색어 인덱스 출력
				idx=s.indexOf(str,idx)+str.length();//검색 시작 인덱스 구하기
				System.out.println("=========================\n");
			}
			System.out.println("더이상 검색어가 존재하지 않습니다.");
			System.out.println("검색된 총 개수는 "+count+"입니다.");
			System.out.println(s.replace(str, "###"));
		}else {
			System.out.println("검색어가 존재하지 않습니다.");
		}
		
	
	}
}











