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
	public D4_ConstructorTest() {
		super();//부모의 생성자를 호출(반드시 첫줄에 작성한다)
//		this(2);// super()와 this()는 같이 쓸 수 없다
		        //  -> 생성자는 하나만 실행되기 때문에 this(2)를 쓰는 순간  
		        //     파라미터 1개짜리 생성자가 실행된다. 
		//             그래서 현재 default생성자에 코드들은 실행되면 안된다. 
		this.size=60;
	}
	
	//생성자 오버로딩(파라미터 1개짜리)
	public D4_ConstructorTest(int size) {
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




