package com.hk.board.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hk.board.command.InsertCalCommand;
import com.hk.board.command.UpdateCalCommand;
import com.hk.board.dtos.CalDto;
import com.hk.board.mapper.CalMapper;
import com.hk.board.utils.Util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
@Transactional
public class CalServiceImp {

	@Autowired
	private Util util;
	@Autowired
	private CalMapper calMapper;
	@Autowired
	private ModelMapper modelMapper;
	
							   //id값이 필요하므로 컨트롤러에서 Request객체도 전달해야 함
							   //아니면 컨트롤러에서 id값을 구해서 전달해주기
	public Map<String, Integer> makeCalendar(HttpServletRequest request){
		
		String paramYear=request.getParameter("year");
		String paramMonth=request.getParameter("month");
		
		//id값을 session으로 부터 가져오기 위해 session객체 생성
		HttpSession session=request.getSession();
		
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
		
		//한달에 대한 일정을 구하는 작업
//		String id=session.getAttribute("id");//session으로부터 id정보 가져오기
		String id="hk";// session에 저장된 id값을 불러와야 함
		String yyyyMM=year+util.isTwo(month+"");//년월 6자리
		List<CalDto> clist=calViewList(id, yyyyMM);
		//한달에 대한 일정을 requestScope에 저장함
		request.setAttribute("clist", clist);
		
		return map;
	}
	
	//controller에서는 insertCalCommand객체로 파라미터를 받음
	public boolean insertCalBoard(InsertCalCommand insertCalCommand) {
		// insertCalCommand 값      ---> CalDto로 옮겨 담기
		// year,month,date,hour,min  ->  mdate
		
		//"202410181024"변환하는 작업
		String mdate=insertCalCommand.getYear()
				    +util.isTwo(insertCalCommand.getMonth()+"")
					+util.isTwo(insertCalCommand.getDate()+"")
					+util.isTwo(insertCalCommand.getHour()+"")
					+util.isTwo(insertCalCommand.getMin()+"");
		
		// command --> dto 값 복사해서 넣는 작업
//		CalDto dto=new CalDto();
//		dto.setId(insertCalCommand.getId());
//		dto.setTitle(insertCalCommand.getTitle());
//		dto.setContent(insertCalCommand.getContent());
//		dto.setMdate(mdate);
		//                          (복사할 대상객체     ,붙여넣을 객체의 타입)
		CalDto dto = modelMapper.map(insertCalCommand, CalDto.class);
		dto.setMdate(mdate);
		int count=calMapper.insertCalBoard(dto);
		
		//예외발생코드 추가
//		if(count>0) {
//			throw new Exception("일정추가 오류");
//		}
		
		return count>0?true:false;
	}
	
	//일정목록보기
	public List<CalDto> calBoardList(String id, Map<String,String> paramMap){
		
		//calendar에서 전달된 y,m,d 값을 8자리로 변환한다.
		String yyyyMMdd=paramMap.get("year")
				      +util.isTwo(paramMap.get("month"))
				      +util.isTwo(paramMap.get("date"));
		
		Map<String, String>map=new HashMap<>();
		map.put("id", id);
		map.put("yyyyMMdd", yyyyMMdd);
		
		return calMapper.calBoardList(map);
	}
	
	//일정삭제하기
	public boolean calMulDel(String[] seq) {
		
		Map<String, String[]>map=new HashMap<>();
		map.put("seqs", seq);
		
		return calMapper.calMulDel(map);
	}
	
	public CalDto calBoardDetail(int seq) {
		return calMapper.calBoardDetail(seq);
	}
	
	public boolean calBoardUpdate(UpdateCalCommand updateCalCommand) {
		// command ---> dto ---> mapper전달
		//"202410181024"변환하는 작업
			String mdate=updateCalCommand.getYear()
					    +util.isTwo(updateCalCommand.getMonth()+"")
						+util.isTwo(updateCalCommand.getDate()+"")
						+util.isTwo(updateCalCommand.getHour()+"")
						+util.isTwo(updateCalCommand.getMin()+"");
			
			// command --> dto 값 복사해서 넣는 작업
			CalDto dto=new CalDto();
			dto.setSeq(updateCalCommand.getSeq());
			dto.setTitle(updateCalCommand.getTitle());
			dto.setContent(updateCalCommand.getContent());
			dto.setMdate(mdate);
			
			return calMapper.calBoardUpdate(dto);
					
	}
	
	public List<CalDto> calViewList(String id, String yyyyMM){
		Map<String, String>map=new HashMap<String, String>();
		map.put("id", id);
		map.put("yyyyMM", yyyyMM);
		return calMapper.calViewList(map);
	}
	
	public int calBoardCount(String id, String yyyyMMdd) {
		Map<String, String>map=new HashMap<String, String>();
		map.put("id", id);
		map.put("yyyyMMdd", yyyyMMdd);
		return calMapper.calBoardCount(map);
	}
	
}










