package hk.edu20240708.day07;

public class D2_StringMethodMain {

	public static void main(String[] args) {
		D2_StringMethodTest smt=new D2_StringMethodTest();
		String s=smt.sTest01("java",2);//객체명.메서드()
		System.out.println(s);
		
		String ss=smt.sTest2("선재 업고 튀어");
		System.out.println(ss);
		
		System.out.println(smt.sTest03("java"));

		smt.sTest04();
		
		String sss=smt.sTest5("java프로그래밍언어");
		System.out.println(sss);
	}

}






