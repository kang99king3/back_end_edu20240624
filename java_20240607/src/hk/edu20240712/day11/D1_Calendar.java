package hk.edu20240712.day11;

public class D1_Calendar {

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
			if(isLeapYear(year)) {// 윤년이면 366을 더하자
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
}



















