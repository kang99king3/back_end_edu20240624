package hk.edu20240708.day07;

import java.util.List;

public class D1_StringCompare {

	public static void main(String[] args) {
		//리터럴과 리터럴 비교
		String s1="java";
		String s2="java";
		
		System.out.println(s1==s2);//주소로 비교
		System.out.println(s1.equals(s2));//hashcode 비교
		
		//객체와 객체 비교
		String obj1=new String("java");
		String obj2=new String("java");
		System.out.println(obj1==obj2);
		System.out.println(obj1.equals(obj2));
		
		//객체와 리터럴 비교
		String s3="java";
		String obj3=new String("java");
		System.out.println(s3==obj3);
		System.out.println(s3.equals(obj3));
		
		//String 특징: immutable한 성격--> 값이 변경되지 않는 성질
		String s="java";//원본
		String ss=s;// 복사본
			   ss="자바";//복사본쪽에서 값을 바꾸면... 원본이 바뀔까?
	    System.out.println(s);
	    
	    //변수 s의 값이 자주 바뀌는 상황--> 객체가 계속 새로 생성--> 메모리효율 떨어짐
	    	   s="java2";//새롭게 대입
	    	   s=s+"객체지향";//+연산을 수행
	    
	    //힙에 객체가 한번 생성되고 내부에 값이 변경되는 개념-> 메모리 효율 높음
	    StringBuffer sb=new StringBuffer("java");
	    sb.append("객체지향");
	    sb.append("프로그래밍");// "java"+"객체지향"+"프로그래밍"
	    System.out.println(sb.toString());
	    
	}
}















