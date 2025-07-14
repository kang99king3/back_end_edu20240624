package hk.edu20240729.day14;

public class D0_NestedClassTest {

	public static void main(String[] args) {
//		InnerClass ic=new InnerClass();//자체 생성 못함
		InnerClass ic=new D0_NestedClassTest().new InnerClass("내부클래스");
		System.out.println(ic.getResult());
		
		StaticInnerClass sic=new StaticInnerClass("정적내부클래스");
		System.out.println(sic.getResult());
		
		D0_NestedClassTest nct=new D0_NestedClassTest();
		nct.nestedMethod();
		
		//익명클래스: 생성자 다음에 {}중괄호 작성, 중괄호 내부에 클래스 내용 작성-> 이름이 없기때문에 일회성
		D0_Anonymous anonymous=new D0_Anonymous() {
			
			@Override
			public void anonyMethod() {
				// TODO Auto-generated method stub
				
			}
		};
	}
	
	public int a=5;
	public int b=10;
	
	
	public static int aa=7;
	public static int bb=3;
	
	public void nestedMethod() {
		int c=5;
		class LocalInnerClass{
			public int number;
			public LocalInnerClass(int number) {
				this.number=number;
			}
			public int getLic() {
				int ss=c;
				a=90;
				return ss+number;
			}
//			c=30;//메서드 내부에서 값을 변경하면 오류발생
			
		}
		LocalInnerClass licObj=new LocalInnerClass(100);
		System.out.println("지역클래스:"+licObj.getLic());
		
		
	}
	
	//인스턴스 내부 클래스: 외부 클래스 객체 생성해야 사용가능
	class InnerClass{
		public String message;
		
		public InnerClass(String message) {
			this.message=message;
		}
		
		public int getResult() {
			int result=a+b;
			return result;
		}
		
	}
	
	//정적 내부 클래스: 독립적으로 사용가능
	static class StaticInnerClass{
			public String message;
			
			public StaticInnerClass(String message) {
				this.message=message;
			}
			
			public int getResult() {
//				int result=a+b;//static맴버만 접근할 수 있다.
				int result=aa+bb;
				return result;
			}
		}
}




