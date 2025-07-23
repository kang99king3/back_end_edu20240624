package hk.edu20240715.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hk.edu20240710.day09.D1_Lotto;

public class D5_ListTest {

	public static void main(String[] args) {
		//제네릭: 형변환을 미리 해주는 개념
		List<String> list=new ArrayList<>();
		list.add("한");//값을 저장하면 자동으로 저장공간과 인덱스가 생성
		list.add("경");
		list.add("닷");
		list.add("컴");
		
		for (int i = 0; i < list.size(); i++) {
			String str=list.get(i);//미리 저장하는 값의 타입으로 형변환했기 때문에 바로 담김
			System.out.print(str+" "); 
		}
		
		System.out.println();
		
		System.out.println(list.contains("한"));//검색기능
		list.add(1, "국");list.add(3, "제");
		list.remove(0);//특정 인덱스에 값을 삭제
//		list.clear();//모두 삭제
		System.out.println(list);
		System.out.println("list의 길이값:"+list.size());
		
		//Lotto객체를 저장해보자
		List<D1_Lotto> lottoList=new ArrayList<D1_Lotto>();
		for (int i = 0; i < 5; i++) {
			lottoList.add(new D1_Lotto());
		}
		for (D1_Lotto d1_Lotto : lottoList) {
			System.out.println(Arrays.toString(d1_Lotto.getLots()));
		}
	}

}






