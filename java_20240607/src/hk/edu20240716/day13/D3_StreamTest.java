package hk.edu20240716.day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class D3_StreamTest {

	public static void main(String[] args) {
		//List객체를 stream객체로 생성후 filter와 sort, forEach를 사용하여 결과 출력
		List<String> list=Arrays.asList("홍길동","임꺽정","김홍도");
		Stream<String> streamList=list.stream();
//		streamList.filter(s->s.contains("홍")).sorted().forEach(s->System.out.println(s));
		streamList.filter(s->s.startsWith("홍")).forEach(s->System.out.println(s));
		
		//List객체를 stream객체로 생성후 맵핑과 수집
		List<Integer> listNum=list.stream() 
								  .map(String::length)//각 요소를 요소의길이값으로 변환
								  .collect(Collectors.toList());//List객체로 반환
		System.out.println(listNum.toString());
		
		System.out.println("--Stream을 사용하지 않을 경우-------------------------");
		
		//만약 Stream을 사용하지 않을 경우
		List<String> list2=new ArrayList<>();
		for (String s : list) {
//			if(s.startsWith("홍")) {
			if(s.contains("홍")) {
				list2.add(s);
			}
		}
		
		Collections.sort(list2);
		for (String s : list2) {
			System.out.println(s);
		}
		System.out.println("--병렬처리-------------------------");
		
		List<String> list3 = List.of("A", "B", "C", "D");

        // 일반 스트림
        list3.stream().forEach(s -> {
            System.out.println(s + " - " + Thread.currentThread().getName());
        });

        System.out.println("---------------------------");

        // 병렬 스트림
        list3.parallelStream().forEach(s -> {
            System.out.println(s + " - " + Thread.currentThread().getName());
        });
	}
	
	
}
