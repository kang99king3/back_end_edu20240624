package hk.edu20240712.day11;

import java.util.Calendar;

public class D4_CalendarApi {

	public static void main(String[] args) {
		int year=2025;
		int month=1;
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, 1);
		int lastDay=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int dayOfWeek=cal.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("\t\t\t"+year+"년 "+month+"월");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		for (int i = 0; i < dayOfWeek-1; i++) {
			System.out.print("\t");
		}
		for (int i = 1; i <= lastDay; i++) {
			System.out.print(i+"\t");
			if((i+dayOfWeek-1)%7==0) {
				System.out.println();
			}
		}
		
//		for (int i = 1; i <= 12; i++) {
//			calendarPrint(2025, i);
//		}
	}
	
	//메서드로 구현하여 쓰자
	public static void calendarPrint(int year, int month) {
		
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, 1);
		int lastDay=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int dayOfWeek=cal.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("\t\t\t"+year+"년 "+month+"월");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		for (int i = 0; i < dayOfWeek-1; i++) {
			System.out.print("\t");
		}
		for (int i = 1; i <= lastDay; i++) {
			System.out.print(i+"\t");
			if((i+dayOfWeek-1)%7==0) {
				System.out.println();
			}
		}
		System.out.println("\n");
	}
}









