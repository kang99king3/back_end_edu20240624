package hk.edu20240715.day12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class D5_MapTest {

	public static void main(String[] args) {
		//javascript ---> Json객체 비슷한 구조 : Key와 value 저장
		
		Map<String, String> map = new HashMap<>(); 
		map.put("하나", "한경");
		map.put("둘", "닷컴");
		map.put("셋", "IT");
		
		System.out.println("Map의 값:"+map.get("하나")
		                             +map.get("둘")
		                             +map.get("셋"));
		
		Set<String> setKeyMap=map.keySet();//key값만 set으로 반환
		Iterator<String> iterKeyMap=setKeyMap.iterator();
		while(iterKeyMap.hasNext()) {
			String str=iterKeyMap.next();//key값을 하나 꺼냄
			System.out.println(map.get(str));
		}
	}

}








