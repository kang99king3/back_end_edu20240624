package hk.edu20240715.day12;

public class D4_CompleteCalc extends D4_Calculator{

	@Override
	public int times(int num1, int num2) {
		return num1*num2;
	}

	@Override
	public int divide(int num1, int num2) {
		if(num2!=0) {//어떤수를 0으로 나누면 에러가 발생한다.
			return num1/num2;
		}else {
			return D4_Calc.ERROR;
		}
	}
	
	//하위클래스에서 새로 추가된 메서드
	public void showInfo() {
		System.out.println("하위클래스에서 새롭게 정의된 메서드");
	}

}





