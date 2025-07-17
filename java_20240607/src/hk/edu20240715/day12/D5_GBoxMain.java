package hk.edu20240715.day12;

import java.util.ArrayList;
import java.util.List;

public class D5_GBoxMain {

	public static void main(String[] args) {
		D5_GBox<String> strBox =new D5_GBox<>();
		strBox.set("Hello Generic");
		System.out.println(strBox.get());
		
		D5_GBox<Integer> intBox=new D5_GBox<Integer>();
		intBox.set(123);
		System.out.println(intBox.get());
		
		//와일드카드
		//<? extends T> : T 또는 하위타입(읽기전용)
		List<? extends Number> numbers=new ArrayList<Integer>();
//		numbers.add(434);
		
		List<Integer> num=new ArrayList<Integer>();
		num.add(1);num.add(2);num.add(3);
		numbers=num;//와일드카드 적용 객체에 넘기면..
//		numbers.add(99);//추가 안됨
		
		List<? super Integer> ints=new ArrayList<Number>();
		ints.add(123);
	}
}
