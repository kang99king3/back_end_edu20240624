package hk.edu20240716.day13;

public class D3_LambdaTest {

	//내부에도 인터페이스를 만들 수 있다.
	@FunctionalInterface
	public interface D3_IinnerLambda{
		//하나의 메서드만 정의할 수 있다.
		public int add(int a, int b);
	}
	
	public static void main(String[] args) {
		//인라인 방식으로 작성하며, 클래스를 만들지 않고 기능을 바로 구현한다고 해서 익명 클래스라고 한다.
		D3_ILambda lam=new D3_ILambda() {
			@Override
			public int add(int a, int b) {
				return a+b;
			}
		};
		System.out.println(lam.add(10, 50));
		
		//람다식을 사용하면 코드를 간결하게 작성할 수 있다.
		D3_ILambda lam2=(a,b) -> a+b;//return만 있을경우 생략 가능, 코드가 한줄이면 {}생략가능
		System.out.println(lam2.add(10, 20));
		
		D3_IinnerLambda innerLam=(a,b)->{//코드가 여러줄일 경우 {} 필요 
			System.out.println(a+","+b); 
			return a+b;
		};
		innerLam.add(10, 20);
		
	}
}






