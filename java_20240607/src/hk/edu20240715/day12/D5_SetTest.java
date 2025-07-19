package hk.edu20240715.day12;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class D5_SetTest {

	public static void main(String[] args) {
		
		Set<String> set=new HashSet<>();
		set.add("건");
		set.add("양");
		set.add("대");
		set.add("학");
		set.add("교");
		set.add("교");//중복된 값 X
		
		//순서가 없기때문에 값을 꺼낼때 Iterator클래스를 활용해줘야 한다.
		Iterator iter=set.iterator();//HashSet클래스에 iterator()가 객체를 구해줌
		while(iter.hasNext()) { //hasNext()는 Set에 값이 존재하는지 확인
			String str =(String)iter.next();//값을 꺼낸다
			System.out.print(str+" ");
		}
		//향상된 for문도 가능
		for (String s : set) {
			System.out.println(s);
		}
	}

}










