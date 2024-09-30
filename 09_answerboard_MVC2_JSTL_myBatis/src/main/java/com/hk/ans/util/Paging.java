package com.hk.ans.util;

import java.util.HashMap;
import java.util.Map;

public class Paging {

	//prePageNum:전페이지의 마지막번호                  1 2 3 4  5 < 6 7 8 9 10 > 11 12 13 
	//nextPageNum:다음페이지의 첫번째 번호
	//startPage:시작페이지 번호
	//endPage:끝나는 페이지 번호  
	
	//pageEndNum:페이지 그룹의 마지막 번호
	//pcount:총페이지수
	//pNum:현재 보여줄 페이지 번호
	//pageRange:한번에 보여줄 페이지 범위
	
	public static Map<String, Integer> pagingValue(int pcount,String pNum,int pageRange){
		Map<String, Integer> map=new HashMap<String, Integer>();
		
		int pNumber=Integer.parseInt(pNum);
		//페이지들을 5개씩 페이징 처리를 위해
		//1234(5)   6789(10) : 페이지 번호를 받아 해당 페이지의 마지막 페이지 번호를 구함
		int pageEndNum=((pNumber-1)/pageRange+1)==1?pageRange:((pNumber-1)/pageRange+1)*pageRange;    
		
		int prePageNum=pageEndNum-pageRange==0?1:pageEndNum-pageRange;
		                                     //      10-5=5
		int nextPageNum=pageEndNum>=pcount?pcount:pageEndNum+1;
		//     현재페이지가 8일경우:  10   >=   14 ?   15  :  10+1   ---> 11
		//     현재페이지가 12일경우:  15   >=   14 ?   14  :  15+1   ---> 14   
		//   1 2 3 4 5 < 6 7 8 9 10 > 11 12 13 14 
		
		int startPage=pageEndNum-(pageRange-1);//현재페이지번호가 8일경우 10-(5-1)= 6
		int endPage=pageEndNum>pcount?pcount:pageEndNum;
		
		map.put("prePageNum", prePageNum);
		map.put("nextPageNum", nextPageNum);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		
		return map;
	}
}










