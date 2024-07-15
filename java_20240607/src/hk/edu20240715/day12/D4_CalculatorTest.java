package hk.edu20240715.day12;

public class D4_CalculatorTest {

	public static void main(String[] args) {
		D4_Calc calc=new D4_CompleteCalc();//인터페이스 타입으로 생성
		D4_CompleteCalc calc2=new D4_CompleteCalc();
		
		System.out.println(calc.add(10, 20));
		System.out.println(calc.substract(20, 10));
		System.out.println(calc.times(10, 20));
		System.out.println(calc.divide(30, 2));
//		calc.showInfo();//<------ 부모 설계도에 공개된 메서드만 사용가능하다
		D4_CompleteCalc calc3=(D4_CompleteCalc)calc;
		calc3.showInfo();//자식에만 있는 메서드를 사용하려면 자식타입으로 다운 캐스팅해야함
	}
}






