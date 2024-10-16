package com.hk.board.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CalServiceImp {

	public Map<String, Integer> makeCalendar(String paramYear,String paramMonth){
		
		Map<String,Integer>map=new HashMap<>();
		
		Calendar cal=Calendar.getInstance();//추상클래스 : new(X)
		
		//paramYear와 paramMonth의 값이 null이 아니면 사용자가 원하는 달을 요청
		int year=(paramYear==null)?cal.get(Calendar.YEAR):Integer.parseInt(paramYear);
		int month=(paramMonth==null)?cal.get(Calendar.MONTH)+1:Integer.parseInt(paramMonth);// calendar[0~11] -> 9+1 -> 10월
		
		// 월을 이동할때 12 13 14 .....,       -2 -1 0 1 2 3 ... 오류 처리
		if(month>12) {
			month=1;
			year++;
		}
		
		if(month<1) {
			month=12;
			year--;
		}
		// ----- 
		
		//1. 해당 월의 1일에 대한 요일을 구하자
		//1~7숫자중에 반환: 1은 일요일~ 7은 토요일
		cal.set(year, month-1, 1);// 특정날짜로 설정: 해당 월의 1일로 셋팅
		int dayOfWeek=cal.get(Calendar.DAY_OF_WEEK);
		System.out.println("dayOfWeek:"+dayOfWeek);
		//2. 월의 마지막 날 구하기
		int lastDay=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		//달력을 표현에 필요한 값을 map에 저장
		map.put("year", year);
		map.put("month", month);
		map.put("dayOfWeek", dayOfWeek);
		map.put("lastDay", lastDay);
		
		return map;
	}
}










