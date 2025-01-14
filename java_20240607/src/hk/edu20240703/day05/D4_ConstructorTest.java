package hk.edu20240703.day05;

public class D4_ConstructorTest extends D3_AccessTest {

	public static void main(String[] args) {
		D4_ConstructorTest con=new D4_ConstructorTest();
		System.out.println(con.getSize());
		
		D4_ConstructorTest con2=new D4_ConstructorTest(40);
		System.out.println(con2.getSize());
		
		D4_ConstructorTest con3=new D4_ConstructorTest(30,"빨강");
		System.out.println(con3.getSize());
		System.out.println(con3.color);
	}
	
	//티비 객체
	private int size=0;//중요한 데이터인경우 private선언
	public String color="검정색";//색상
	
	//default 생성자는 단독으로 사용할땐 생략가능하지만 오버로딩하면 생략 불가능
	//생성자 호출은 반드시 첫줄에 작성해야 한다.(제일 먼저 실행되어야 함)
	public D4_ConstructorTest() {
//		super();//부모의 생성자를 호출(명시적으로 선언하거나, 생략 가능하다)
		this(2);// super()와 this()는 같이 쓸 수 없다-> 둘다 첫줄에 작성되어 하기때문에..  
		this.size=60;
	}
	
	//생성자 오버로딩(파라미터 1개짜리)
	public D4_ConstructorTest(int size) {
		super();
		this.size=size;
	}
	public D4_ConstructorTest(int size,String color) {
		this.size=size;
		this.color=color;
	}
	
	//값을 가져오기
	public int getSize() {
		return size;
	}
	//값을 저장하기
	public void setSize(int size) {
		this.size=size;
	}
}




