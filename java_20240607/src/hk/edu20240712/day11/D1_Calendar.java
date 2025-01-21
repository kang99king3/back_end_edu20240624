package hk.edu20240712.day11;

public class D1_Calendar{

	//leap , plain  : final(금지)
	private static final int[] leap= {31,29,31,30,31,30,31,31,30,31,30,31};
	private static final int[] plain= {31,28,31,30,31,30,31,31,30,31,30,31};
	
	//윤년을 판단하는 메서드
	public boolean isLeapYear(int year) {
		boolean isS=false;
		if((year%4==0&&year%100!=0)||year%400==0) {
			isS=true;
		}
		return isS;
	}
	
	//1-1-1 ~ 2024-07-01의 경과일 구하기
	
	//1년도 ~ 2023년도까지 경과일 구하기
	public int dates(int year) {
		int tot=0;
		for (int i = 1; i < year; i++) {
			if(isLeapYear(i)) {// 윤년이면 366을 더하자
				tot+=366;
			}else {
				tot+=365;
			}
		}
		return tot;
	}
	
	//전년도까지의 경과일 + 7월 전까지의 월별 경과일 --> 7월 전까지의 경과일
	public int dates(int year, int month) {
		int tot=dates(year);// 초기값은 전년도까지의 경과일로 저장
		
		for (int i = 1; i < month; i++) {
			if(isLeapYear(year)) {
				tot+=leap[i-1];// 월의 인덱스값은 0부터 시작 --> i-1
			}else {
				tot+=plain[i-1];
			}
		}
		return tot;
	}
	
	//전년도까지 경과일 + 전월까지 경과일 + 해당일(1일)
	public int dates(int year, int month, int day) {
		return dates(year, month)+day;
	}
	
	//구하려는 달의 마지막 날을 구하는 기능--> 31일이라면 1일~31일까지 출력시키는 코드를 작성할 수 있음
	public int lastDay(int year, int month) {
		return isLeapYear(year)?leap[month-1]:plain[month-1];
	}
	
	//한달을 출력하는 메서드
	public void calendarPrint(int year, int month) {
		System.out.println(year+"년 "+month+"월" );
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		int dayOfWeek=dates(year, month, 1)%7;// 공백수 --> Calendar객체를 활용경우 -1
		//달력의 공백을 출력
		for (int i = 0; i < dayOfWeek; i++) {
			System.out.print("\t");
		}
		//날짜를 출력
		for (int i = 1; i <= lastDay(year, month); i++) {
			System.out.print(i+"\t");
			//여기서 토요일을 확인하는 코드추가
			if((dayOfWeek+i)%7==0) {// 토요일을 구하는 조건 (공백수 + 현재날짜)%7==0
				System.out.println();				
			}
		}
	}
	
	public static void main(String[] args) {
		D1_Calendar cal=new D1_Calendar();
		
		for (int i = 1; i <= 12; i++) {
			cal.calendarPrint(2025, i);	
			System.out.println("\n------------------------------------------------------");
		}
		
		int a=cal.dates(2024, 7, 12);
		int birthday=cal.dates(2004, 5, 10);
		System.out.println("나의 얼마나 살았을까?:"+(a-birthday)+"일");
	}
}



















